package com.imruize.bean;

import com.imruize.anno.Bean;
import com.imruize.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{
    //创建map bean
    private Map<Class, Object> beanMap = new HashMap<>();
    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanMap.get(clazz);
    }
    //设置扫描规则，当前包和子包，有@bean的都通过反射进行实例化
    public AnnotationApplicationContext(String path){
        try {
            //1 把.换成\
            String packagePath = path.replaceAll("\\.", "\\\\");
            //2 获取绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String decode = URLDecoder.decode(url.getFile(), "utf-8");
                //获取包前面路径的部分
                rootPath = decode.substring(0, decode.length() - packagePath.length());
                //扫描包
                loadBean(new File(decode));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //完成属性的注入
        loadDi();
    }

    //
    private void loadBean(File file) throws Exception{
        //1. 判断当前是否是文件夹
        if(file.isDirectory()){
            //2. 获取文件夹内容
            File[] files = file.listFiles();
            //3. 为空，直接返回
            if (files == null || files.length == 0){
                return;
            }
            //4. 不为空，遍历所有内容
            for (File child :
                    files) {
                //4.1 得到file对象，继续判断
                //4.2 如果是文件夹，递归
                if (child.isDirectory()){
                    loadBean(child);
                }else{
                    //4.3 得到包的路径 + 类名称部分
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4 判断文件类.class
                    if (pathWithClass.contains(".class")) {
                        //4.5 把路径.换成/,去掉.class
                        String allName = pathWithClass.replaceAll("\\\\", "\\.").replace(".class", "");
                        //4.6 判断类是否有注解@Bean, 有就实例化
                        //4.6.1 获取类的class
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2 判断是否为接口
                        if (!clazz.isInterface()){
                            //4.6.3 判断是否有注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null){
                                Object instance = clazz.getConstructor().newInstance();
                                //4.7 把对象实例化，放入map,有接口，接口class作为map key
                                if (clazz.getInterfaces().length > 0){
                                    beanMap.put(clazz.getInterfaces()[0], instance);
                                }else{
                                    beanMap.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // 属性的注入
    private void loadDi() {
        //1 实例化的对象在beanMap中，遍历map
        Set<Map.Entry<Class, Object>> entries = beanMap.entrySet();
        for (Map.Entry<Class, Object> entry :
                entries) {
            //2 获取所有对象的属性
            Object obj = entry.getValue();
            // 获取对象的class
            Class<?> clazz = obj.getClass();
            //获取所有属性
            Field[] declaredFields = clazz.getDeclaredFields();
            //3 遍历属性数组，得到每个属性
            for (Field field :
                    declaredFields) {
                //4 判断属性上是否有@Di的注解
                Di annotation = field.getAnnotation(Di.class);
                //5 有注解，对象进行设置（注入）
                if (annotation != null){
                    //如果是私有属性
                    field.setAccessible(true);
                    try {
                        field.set(obj, beanMap.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
