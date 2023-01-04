package com.wyx.test;

import com.wyx.aop.PersonProxy;
import com.wyx.aop.User;
import com.wyx.aopxml.Book;
import com.wyx.config.AopConfig;
import com.wyx.jdbcTemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class TestDemo {
    @Test
    public void testUser() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //注意，这里传需要被增强的类
        User user = context.getBean("user", User.class);
        /*
        环绕之前
        before
        add...
        环绕之后
        after
        afterReturning
         */
        user.add();

//        既可以做增强类，又可以单独调用自身方法
        PersonProxy personProxy = context.getBean("personProxy", PersonProxy.class);
        personProxy.before();
    }

    @Test
    public void testConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAopXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

    @Test
    public void testJdbcTemplate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //add
        com.wyx.jdbcTemplate.entity.Book book = new com.wyx.jdbcTemplate.entity.Book();
//        book.setUserId("009");
//        book.setUsername("tom");
//        book.setStatus("a");
//        bookService.addBook(book);

        //update
//        com.wyx.jdbcTemplate.bean.Book new_book = new com.wyx.jdbcTemplate.bean.Book();
//        new_book.setUserId("7");
//        new_book.setUsername("tom");
//        new_book.setStatus("ina");
//        bookService.updateBook(new_book);

        //delete
//        book.setUserId("9");
//        bookService.delete(book);

        //count
//        System.out.println(bookService.selectCount());

        //RowMapper返回对象
//        com.wyx.jdbcTemplate.bean.Book bookInfo = bookService.findBookInfo("1");
//        System.out.println(bookInfo);

        //RowMapper返回所有信息
//        System.out.println(bookService.findAllBookInfo());

        //批量插入
//        ArrayList<Object[]> list = new ArrayList<Object[]>();
//        Object[] o1 = {"13", "jason", "a"};
//        Object[] o2 = {"14", "jansen", "b"};
//        Object[] o3 = {"15", "tom", "a"};
//        list.add(o1);
//        list.add(o2);
//        list.add(o3);
//        bookService.batchAddBook(list);

        //批量修改
//        ArrayList<Object[]> list = new ArrayList<>();
//        Object[] o1 = {"jj", "a", "13"};
//        Object[] o2 = {"jordan", "a", "14"};
//        list.add(o1);
//        list.add(o2);
//        bookService.batchUpdateBook(list);

        //批量删除
        ArrayList<Object[]> list = new ArrayList<>();
        Object[] o1 = {"11"};
        Object[] o2 = {"12"};
        list.add(o1);
        list.add(o2);
        bookService.batchDeleteBook(list);
    }
}
