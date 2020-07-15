package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Book;

public interface BookMapper extends Mapper<Book> {
    Book findByBook(Book queryBook);
}