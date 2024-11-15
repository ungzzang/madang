package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // 빈 등록
@RequiredArgsConstructor // mapper에 객체 주소값받으려고(DI)
public class BookService {
    private final BookMapper mapper;

    public int postBook(BookPostReq p){
        return mapper.insBook(p);
    }

    public List<BookGetRes> getBookList(BookGetReq p) {
        // sIdx값 세팅
        /*int page = p.getPage();
        int size = p.getSize();
        int sIdx = (page - 1) * size;
        p.setStartIdx(sIdx);*/ //쿼리문에서 직접 계산하면 이거 필요없음.

        System.out.println(p);
        //p.setSIdx((p.getPage() - 1) * p.getSize()); 위에껄 한줄로
        return mapper.selBookList(p);
    }

    public int putBook(BookUpdateReq p){
        return mapper.updBook(p);
    }

    public int deleteBook(BookDeleteReq p) {
        return mapper.delBook(p);
    }
}
