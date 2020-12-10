package com.example.client;

import com.example.client.dto.Order;
import com.example.client.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class MockObjects {

    public static OrderItem getOrderItem(){
        OrderItem item = new OrderItem();
        item.setPerItemCost(20);
        item.setProductCode("PA3");
        item.setProductName("Shampoo");
        item.setQuantity(2);
        item.setOrderId(1);
        return item;
    }

    public static List<OrderItem> getOrderItems(){
        OrderItem item = new OrderItem();
        item.setPerItemCost(20);
        item.setProductCode("PA");
        item.setProductName("Shampoo");
        item.setQuantity(2);
        item.setOrderId(1);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(item);
        return orderItemList;
    }

    public static Order getOrder(){
        Order order = new Order();
        order.setCustomerName("Ayan");
        order.setOrderDate("2020-10-12");
        order.setId((long) 1);
        return order;
    }
}
