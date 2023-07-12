package com.imruize.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //添加 修改 删除操作
    //查询: 返回对象
    @Test
    public void testSelect(){
        String sql = "SELECT * FROM t_emp WHERE id = ?";
        /*
        Emp result = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Emp emp = new Emp();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            return emp;
        }, 2);
        System.out.println(result);

         */
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 2);
        System.out.println(emp);

    }
    //查询：返回list集合
    @Test
    public void testSelectList(){
        String sql = "SELECT * FROM t_emp";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(query);
    }
    //查询：返回单个值
    @Test
    public void testSelectValue(){
        String sql = "SELECT count(*) FROM t_emp";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
    @Test
    public void testUpdate(){

        //添加
        String sql = "INSERT INTO t_emp VALUES(NULL, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, "zeze", 20, "男");
        System.out.println(rows);

        /*
        //修改
        String sql = "UPDATE t_emp SET name=? WHERE id=?";
        int rows = jdbcTemplate.update(sql, "zz", 1);
        System.out.println(rows);
        */
        /*
        //删除
        String sql = "DELETE FROM t_emp WHERE id=?";
        int rows = jdbcTemplate.update(sql, 1);
        System.out.println(rows);

         */
    }

}
