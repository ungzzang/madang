package com.green.madang.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 응답할 때 사용하는 객체
@Getter
@Setter
@AllArgsConstructor //모든 멤버필드 초기화 할 수 있는 생성자를 만들어준다.
public class MyResponse<T> {
    private String resultMessage;
    private T resultData;
}
