package com.company.project.model;

import com.sun.xml.internal.ws.developer.Serialization;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "book对象",description = "书记对象book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_price")
    private String bookPrice;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return book_name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return book_author
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * @param bookAuthor
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * @return book_price
     */
    public String getBookPrice() {
        return bookPrice;
    }

    /**
     * @param bookPrice
     */
    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
}