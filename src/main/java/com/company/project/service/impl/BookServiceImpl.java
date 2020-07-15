package com.company.project.service.impl;

import com.company.project.dao.BookMapper;
import com.company.project.model.Book;
import com.company.project.service.BookService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/05/15.
 */
@Service
@Transactional
public class BookServiceImpl extends AbstractService<Book> implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public Book findByBook(Book queryBook) {
        return bookMapper.findByBook(queryBook);
    }
}
