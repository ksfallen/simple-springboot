package com.simple.controller;

import com.simple.mapper.BookMapper;
import com.simple.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author: Jfeng
 * @date: 2017/7/13
 */
public class BookControllerTest {
    @Mock
    BookMapper bookMapper;
    @InjectMocks
    BookController bookController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReadersBooks() throws Exception {
        String result = bookController.readersBooks("reader", null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testAddToReadingList() throws Exception {
        String result = bookController.addToReadingList("reader", new Book());
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
