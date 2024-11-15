package com.green.madang.manager.book;

import com.green.madang.manager.book.model.BookPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    int insBook(BookPostReq p);

}
