package com.chinaunicom.get_info.controller;

import com.chinaunicom.get_info.bean.OrderDO;
import com.chinaunicom.get_info.bean.OrderFullInfoDO;
import com.chinaunicom.get_info.bean.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InfoController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.userServiceUrl}")
    private String userServiceUrl;
    @Value("${user.orderServiceUrl}")
    private String orderServiceUrl;

    @GetMapping("/user/{id}")
    public UserDO findUserById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServiceUrl + "/" + id, UserDO.class);
    }

    @GetMapping("/order/{id}")
    public OrderDO findOrderById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.orderServiceUrl + "/" + id, OrderDO.class);
    }

    @GetMapping("/{id}")
    public OrderFullInfoDO findOrderFullInfoById(@PathVariable Long id) {
        OrderDO orderDO = this.restTemplate.getForObject(this.orderServiceUrl + "/" + id, OrderDO.class);
        UserDO userDO = this.restTemplate.getForObject(this.userServiceUrl + "/" + orderDO.getId().toString(), UserDO.class);
        OrderFullInfoDO orderFullInfoDO = new OrderFullInfoDO(orderDO,userDO);
        return orderFullInfoDO;
    }
}
