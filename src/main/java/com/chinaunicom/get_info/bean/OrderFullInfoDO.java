package com.chinaunicom.get_info.bean;

public class OrderFullInfoDO {

    private OrderDO orderDO;

    private UserDO userDO;

    public OrderFullInfoDO(OrderDO orderDO, UserDO userDO) {
        this.orderDO = orderDO;
        this.userDO = userDO;
    }

    public OrderDO getOrderDO() {
        return orderDO;
    }

    public void setOrderDO(OrderDO orderDO) {
        this.orderDO = orderDO;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }
}
