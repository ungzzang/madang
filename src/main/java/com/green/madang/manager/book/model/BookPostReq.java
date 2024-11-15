package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPostReq { //프론트가 bookid에 관여안하니까 생략
    private String bookName;
    private String publisher;
    private int price;
}
