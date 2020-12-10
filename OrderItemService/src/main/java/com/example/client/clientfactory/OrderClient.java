package com.example.client.clientfactory;


import com.example.client.response.CustomResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8080", name="ORDER-CLIENT")
public interface OrderClient {

    /**
     * Gets all order details
     * @return
     */
    @GetMapping("/orders/{id}")
    CustomResponse getOrderByOrderId(@PathVariable("id") long id);
}
