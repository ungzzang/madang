package com.green.madang.manager.order;

import com.green.madang.manager.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    List<OrderGetRes> getOrderList(OrderGetReq p){ // 주소값 p는 무조건 8byte
        // startIdx값 세팅
        p.setStartIdx((p.getPage()-1)*p.getSize());
        /*
        int page = p.getPage();
        int size = p.getSize();
        int startIdx = (page - 1) * size;
        p.setStartIdx(startIdx);
         */
        return mapper.selOrderList(p);
    }
}
