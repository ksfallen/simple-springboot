package com.simple.controller;

import com.simple.mapper.BookMapper;
import com.simple.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User: Jfeng
 * Date: 2017/6/2
 */
@Controller
@RequestMapping("/user/readinglist")
public class ReadingListController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {

        Book book = new Book();
        book.setReader(reader);
        List<Book> readingList = bookMapper.select(book);

        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }

        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookMapper.insert(book);
        return "redirect:/user/readinglist/{reader}";
    }
}
