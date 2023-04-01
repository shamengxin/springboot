package com.shamengxin.reids.controller;

import com.shamengxin.reids.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("新增订单")
    @RequestMapping(value = "/order/add",method = RequestMethod.POST)
    public void addOrder(){

        orderService.addOrder();

    }

    @ApiOperation("按照可以Id查询订单")
    @GetMapping("/order/{keyId}")
    public String getOrderById(@PathVariable Integer keyId){

       return orderService.getOrderById(keyId);

    }

}
