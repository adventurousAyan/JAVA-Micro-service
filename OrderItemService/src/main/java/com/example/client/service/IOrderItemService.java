package com.example.client.service;

import com.example.client.entity.OrderItem;

import java.util.List;

public interface IOrderItemService {

    /**
     * Create an Order-Item
     * @param orderItem
     * @return
     */
    boolean createOrderItem(OrderItem orderItem);

    /**
     * Create multiple order-items
     * @param orderItems
     * @return
     */
    List<OrderItem> createOrderItems(List<OrderItem> orderItems);

    /**
     * Get Items by Order-Id
     * @param id
     * @return
     */
    List<OrderItem> getItemsByOrderId(long id);
}
