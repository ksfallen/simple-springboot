package com.simple.jpa.dao;

import com.simple.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Jfeng
 * Date: 2017/6/2
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
