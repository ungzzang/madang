package com.green.madang.manager.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderGetReq {
    private int page;
    private int size;
    @JsonIgnore
    private int startIdx;
}
