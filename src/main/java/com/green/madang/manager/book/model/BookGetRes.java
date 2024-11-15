package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookGetRes {
    private int bookId;
    private String bookName;
    private String publisher;
    private int price;
}
