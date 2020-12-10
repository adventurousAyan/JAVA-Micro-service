package com.example.client.service.impl;

import com.example.client.clientfactory.OrderClient;
import com.example.client.entity.OrderItem;
import com.example.client.repository.OrderItemRepository;
import com.example.client.response.CustomResponse;
import com.example.client.service.IOrderItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
/**
 * <p>Order Item Service</p>
 */
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private ObjectMapper mapper;

    /**
     * Create single order-item
     *
     * @param orderItem
     * @return
     */
    public boolean createOrderItem(OrderItem orderItem) {
        OrderItem newOrderItem = orderItemRepository.save(orderItem);
        return newOrderItem.getId() > 0;

    }

    /**
     * Create multiple order-items
     *
     * @param orderItems
     * @return
     */
    public List<OrderItem> createOrderItems(List<OrderItem> orderItems) {
        boolean result = true;
        //Checking whether order id exists
        for (OrderItem x : orderItems) {
            CustomResponse res = orderClient.getOrderByOrderId(x.getOrderId());
            if (res.getStatus() != HttpStatus.OK) {
                result = false;
                break;
            }
        }
        if(result)
        return (List<OrderItem>)orderItemRepository.saveAll(orderItems);
        else
            return new ArrayList<>();
    }

    /**
     * Gets order-items by order-id
     *
     * @param id
     * @return
     */
    public List<OrderItem> getItemsByOrderId(long id) {
        List<OrderItem> orderItems = orderItemRepository.findOrderItemsInfoByOrderId(id);
        return  orderItems;
    }
}
