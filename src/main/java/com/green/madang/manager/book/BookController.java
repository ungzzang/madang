package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j //s는 스프링, 콘솔에 뭐 찍을때 sout대신 쓰는거
@RestController
@RequestMapping("manager/book")
@RequiredArgsConstructor
@Tag(name = "도서", description = "도서 API")
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 입고", description = "도서 정보 리스트 보기 API")
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p){
        log.info("BookPostReq : {}", p); //콘솔 로그, 가볍게, information의 info, p의 값을 찍는다.
        log.warn("warn"); //경고 로그
        log.error("error"); //에러 로그, 메세지
        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description = "도서 정보 리스트 <br> 보기 API <br> 하하하<br>그래") //<br>은 개행처리
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p){
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }

    @PutMapping
    @Operation(summary = "도서 수정", description = "도서 정보 리스트 보기 API")
    public int putBook(@RequestBody BookUpdateReq p){
        return service.putBook(p);
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제", description = "도서 정보 리스트 보기 API")
    public int delete(BookDeleteReq p){
        return service.deleteBook(p);
    }
}
