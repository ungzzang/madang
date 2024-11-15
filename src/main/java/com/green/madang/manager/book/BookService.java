package com.green.madang.manager.book;

import com.green.madang.manager.book.model.BookPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 빈 등록
@RequiredArgsConstructor // mapper에 객체 주소값받으려고(DI)
public class BookService {
    private final BookMapper mapper;

    public int postBook(BookPostReq p){
        return mapper.insBook(p);
    }
}
