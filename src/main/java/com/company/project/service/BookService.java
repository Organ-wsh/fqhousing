package com.company.project.service;
import com.company.project.model.Book;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2020/05/15.
 */
public interface BookService extends Service<Book> {

    Book findByBook(Book queryBook);
}
