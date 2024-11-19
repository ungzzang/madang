package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

/*
    우리가 만드는 API는 응답 때 JSON형태로 응답한다.
    응답시 객체에 있는 특정 멤버필드의 값을 제외하고 싶을 때
    @JsonIgnore는 멤버필드에 붙이면 제외시킬 수 있다.
    (응답 때 JsonIgnore을 쓰는 경우는 거의 없다.)

    Swagger 문서상에 응답 Schema에서 안 보이기도 한다.
 */

//immutable 객체
@Getter
@Setter
public class CustomerGetReq {//쿼리문 만들때 필요한 데이터들
    //@Schema - Swagger용 애노테이션, requiredMode = Schema.RequiredMode.REQUIRED는 꼭 받는다는 표시인데 필수아님 없어도됨. 그래도 있으면 프론트한테 매너.
    //@@JsonIgnore - Swagger용 애노테이션
    @Schema(description = "page값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;

    //@JsonIgnore와  @Schema(hidden = true)는 Swagger 문서상에 Parameters  부분에서 보이지 않게 하는 역할
    // , 같은효과(안보이게 하는거, 숨기게 하는거)
    @Schema(hidden = true)
    private int startIdx; //(page - 1) * size

    @Schema(name="search_type", description = "검색타입: {name, address, phone}중 한 값을 보낸다. ", example = "name")
    private String searchType;

    @Schema(name="search_text", description = "검색내용", example = "ani")
    private String searchText;

    //@BindParam - 생성자에서만 동작. 언더바 타입도 데이터 받을수 있게하려고, 이렇게 설정하면 ""안에 모양으로 보내야 받는다 이제.
    public CustomerGetReq(int page, int size, @BindParam("search_type") String searchType, @BindParam("search_text") String searchText) {
        this.page = page;
        this.size = size;
        this.searchType = searchType;
        this.searchText = searchText;
        this.startIdx = (page - 1) * size;
    }

}

