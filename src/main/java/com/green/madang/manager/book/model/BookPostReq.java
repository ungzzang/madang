package com.green.madang.manager.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookPostReq { //프론트가 bookid에 관여안하니까 생략
    @Schema(title = "도서 이름", description = "설명할 거 있으면 적으면 된다.", example = "학교 종이 땡땡땡", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bookName;
    @Schema(title = "출판사 이름", example = "한빛출판사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publisher;
    @Schema(title = "도서 가격", example = "12000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
