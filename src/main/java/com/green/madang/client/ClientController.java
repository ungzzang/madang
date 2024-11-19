package com.green.madang.client;

import com.green.madang.client.model.OrderGetReq;
import com.green.madang.client.model.OrderGetRes;
import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
@Tag(name="클라이언트", description = "도서 주문 처리 가능")
public class ClientController {
    private final ClientService service;

    //@ResponseBody
    @PostMapping("order")//client 안에 order가 있다고 생각(/client/order 이런식)
    @Operation(summary = "책 주문")
    public MyResponse<Integer> postOrder(@RequestBody OrderPostReq p){
        int result = service.postOrder(p);//result는 1이나옴.
        return new MyResponse<>("주문이 등록되었습니다.", result);
        //MyResponse<>라는 클래스와 그걸 객체로 만들어 리턴한거
    }

    //본인이 주문한 책 리스트
    @GetMapping("order")
    @Operation(summary = "책 주문 리스트")
    public MyResponse<List<OrderGetRes>> getOrderList(@ParameterObject @ModelAttribute OrderGetReq p){
        List<OrderGetRes> list = service.getOrderList(p);
        return new MyResponse<>(list.size() + "개의 row", list);
    }


}
