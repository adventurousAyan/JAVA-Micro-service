package com.example.client.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Order {
    private Long id;
    private String customerName;
    private String orderDate;
    @Column(name="SHIPPING_ADDRESS")
    private String shippingAddress;
    @Column(name="TOTAL_COST")
    private double total;
}
