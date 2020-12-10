package com.example.client.controller;

import com.example.client.entity.OrderItem;
import com.example.client.response.CustomResponse;
import com.example.client.service.IOrderItemService;
import com.example.client.util.TWConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Order Item Service Controller Class
 */
@RestController
@Api(value = "Order Item Service")
public class OrderItemController {

    @Autowired
    private IOrderItemService orderItemService;

    @PostMapping(value = "/orderItem")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation(value = "Creates a order item", notes = "Creates an order item",
            response = CustomResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = TWConstants.API_RESPONSE_201),
            @ApiResponse(code = 401, message = TWConstants.API_RESPONSE_401),
            @ApiResponse(code = 403, message = TWConstants.API_RESPONSE_403),
            @ApiResponse(code = 404, message = TWConstants.API_RESPONSE_404),
            @ApiResponse(code = 500, message = TWConstants.API_RESPONSE_500),
    })
    public ResponseEntity<CustomResponse> createOrderItem(@Valid @RequestBody OrderItem orderItem) throws Exception{
        CustomResponse res;
       if(orderItemService.createOrderItem(orderItem))
          res = new CustomResponse<>(201, "Order item created successfully");
          else
              res = new CustomResponse<>(400, "Unable to create order item for order id: "
                      + orderItem.getId());
       return new ResponseEntity<>(res, HttpStatus.valueOf(res.getStatusCode()));
    }

    @PostMapping(value = "/orderItems")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiOperation(value = "Creates multiple order items", notes = "Creates an order items",
            response = CustomResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = TWConstants.API_RESPONSE_201),
            @ApiResponse(code = 401, message = TWConstants.API_RESPONSE_401),
            @ApiResponse(code = 403, message = TWConstants.API_RESPONSE_403),
            @ApiResponse(code = 404, message = TWConstants.API_RESPONSE_404),
            @ApiResponse(code = 500, message = TWConstants.API_RESPONSE_500),
    })
    public CustomResponse createOrderItems(@Valid @RequestBody List<OrderItem> orderItems) {
         List<OrderItem> newOrderItems =   orderItemService.createOrderItems(orderItems);
         if(newOrderItems.size() > 0)
         return new CustomResponse<>(HttpStatus.CREATED, newOrderItems);
         else
             return new CustomResponse<>(HttpStatus.BAD_REQUEST, "Unable to create order items");

    }


    @GetMapping(value = "/orderItems/{orderId}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Gets order items by order id", notes = "Gets order items by order id",
            response = CustomResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = TWConstants.API_RESPONSE_200),
            @ApiResponse(code = 401, message = TWConstants.API_RESPONSE_401),
            @ApiResponse(code = 403, message = TWConstants.API_RESPONSE_403),
            @ApiResponse(code = 404, message = TWConstants.API_RESPONSE_404),
            @ApiResponse(code = 500, message = TWConstants.API_RESPONSE_500),
    })
    public CustomResponse getOrderItemsByOrderId(@PathVariable("orderId") long orderId) {
        CustomResponse res;
        List<OrderItem> orderItems = orderItemService.getItemsByOrderId(orderId);
        if(orderItems.size() > 0)
            return new CustomResponse<>(HttpStatus.OK, orderItems);
        else {
            return new CustomResponse(HttpStatus.NOT_FOUND,
                    "Order Items not found for order id :- " + orderId);
        }
    }
}
