package com.simple.mapper;

import com.simple.ApplicationTests;
import com.simple.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Jfeng
 * Date:  2017/6/26
 */
public class BookMapperTest extends ApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test() {
        Book book = bookMapper.selectByPrimaryKey(1L);
        System.out.println(book);
    }
}
