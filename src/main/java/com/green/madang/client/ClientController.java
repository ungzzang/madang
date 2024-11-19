package com.green.madang.client;

import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
@Tag(name="클라이언트", description = "도서 주문 처리 가능")
public class ClientController {
    private final ClientService service;

    //@ResponseBody
    @PostMapping("order")
    @Operation(summary = "책 주문")
    public MyResponse<Integer> postOrder(@RequestBody OrderPostReq p){
        int result = service.postOrder(p);
        return new MyResponse<>("주문이 등록되었습니다.", result);
    }

}
