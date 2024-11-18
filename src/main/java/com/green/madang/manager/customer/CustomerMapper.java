package com.green.madang.manager.customer;

import com.green.madang.manager.customer.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int insCustomer(CustomerPostReq p);
    List<CustomerGetRes> selCustomerList(CustomerGetReq p); //select는 list 또는 하나만 2개로 만들수있다.
    int updCustomer(CustomerPutReq p);
    int delCustomer(int p);

}
