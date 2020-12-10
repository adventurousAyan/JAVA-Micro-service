package com.example.client.entity;

import com.example.client.util.TWConstants;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@Entity
@Table(name= "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="PRODUCT_CODE")
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9]+", message = TWConstants.VAL_MESSAGE_PROD_CODE)
    private String productCode;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="QUANTITY")
    @NotNull
    @Min(value = 1, message = TWConstants.VAL_MESSAGE_ITEM_QUANTITY)
    private int quantity;
    @Column(name = "ORDER_ID")
    @NotNull
    @Min(value = 1, message = TWConstants.VAL_MESSAGE_ORDER_ID)
    private long orderId;
    @Column(name = "COST")
    @NotNull
    @Min(value = 1, message = TWConstants.VAL_MESSAGE_ITEM_COST)
    private double perItemCost;
}
