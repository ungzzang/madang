package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그찍는 라이브러리
@RestController
@RequestMapping("manager/customer")
@RequiredArgsConstructor
@Tag(name = "고객", description = "고객 관리")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "고객 등록")
    public MyResponse<Integer> postCustomer(@RequestBody CustomerPostReq p) {
        int result = service.postCustomer(p);
        return new MyResponse<>("고객이 등록되었습니다.", result);
    }

    @GetMapping
    @Operation(summary = "고객 리스트", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다.")
    //@ParameterObject - Swagger용 애노테이션, RequestParam으로 설정했을 때 나오는 FORM처럼 되게 한다. swagger에서 키 밸류 박스로 나타나게함. 필수는 아니지만 보기 좋아서 적어주면좋다
    //@ModelAttribute 이 자리에 @RequestParam 이거 넣으면 안됨
    //@ModelAttribute는 객체일때 사용, 객체의 자식이 중요. 자식이 키값
    //@RequestParam는  얘는 변수명이 키값이된다.
    public MyResponse<List<CustomerGetRes>> getCustomerList(@ParameterObject @ModelAttribute CustomerGetReq p) {
        log.info("get-req: {}", p); //sout대신 이걸쓰도록 하자
        List<CustomerGetRes> res = service.getCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    //RequestParam을 이용한 GetMapping
    //위에서는 key=value 이고 밑은 그거 대신
    // required = true면 안보냈을때 에러뜸
    @GetMapping("/param")
    @Operation(summary = "고객 리스트2", description = "검색할 내용이 있을 시 검색타입, 검색내용을 모두 보내주어야 한다. 자세하게 적어주자")
    public MyResponse<List<CustomerGetRes>> getCustomerList2( @RequestParam int page
                                                            , @RequestParam int size
                                                            , @RequestParam(name="search_type", required = false) String searchType
                                                            , @RequestParam(name="search_text", required = false) String searchText) {
        CustomerGetReq p = new CustomerGetReq(page, size, searchType, searchText);
        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.getCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    @PutMapping
    @Operation(summary = "고객 수정", description = "부분 수정 가능합니다.")
    public MyResponse<Integer> putCustomer(@RequestBody CustomerPutReq p) {
        int result = service.putCustomer(p);
        return new MyResponse<>(p.getCustId() + "번 고객을 수정하였습니다.", result);
    }

    // @RequestParam 이거 생략하면 자동으로 들어감, int라서 그렇다.
    // @RequestParam(value = "cust_id") 이렇게 하면 언더바 받을수 있다.
    @DeleteMapping
    @Operation(summary = "고객 삭제")
    public MyResponse<Integer> deleteCustomer(@RequestParam(value = "cust_id") int custId) {
        log.info("custId: {}", custId);
        int result = service.deleteCustomer(custId);
        return new MyResponse<>(custId + "번 고객을 삭제하였습니다.", result);
    }
}



