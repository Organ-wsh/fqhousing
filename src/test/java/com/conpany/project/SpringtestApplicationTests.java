package com.conpany.project;

import com.company.project.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringtestApplicationTests.class)
public class SpringtestApplicationTests {


    @Test
    public void contextLoads() {
        Book book = new Book();
        book.setBookPrice("30");
        book.setBookAuthor("罗贯中");
        book.setBookName("三国演义");
    }

}
