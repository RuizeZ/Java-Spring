package com.imruize.spring6.iocxml.di;

public class Book {
    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public Book(String bname, String author) {
        System.out.println("in constructor");
        this.bname = bname;
        this.author = author;
    }

    public Book() {
    }

    private String bname;
    private String author;
    private String others;

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    //生成set方法
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        Book book = new Book();
//        set方法注入
        book.setAuthor("java");
        book.setAuthor("zeze");

        //构造方法
        Book book2 = new Book("python","zeze");
    }
}
