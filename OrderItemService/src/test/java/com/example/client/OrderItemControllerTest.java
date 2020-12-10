package com.example.client;

import com.example.client.controller.OrderItemController;
import com.example.client.service.IOrderItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrderItemController.class)
public class OrderItemControllerTest {

    @MockBean
    IOrderItemService orderItemService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void test_createItem() throws Exception {
        when(orderItemService.createOrderItem(Mockito.any())).
                thenReturn(true);
        String json = mapper.writeValueAsString(MockObjects.getOrderItem());
        MockHttpServletResponse res = mockMvc.perform(MockMvcRequestBuilders
                .post("/orderItem")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andReturn()
                .getResponse();
        assertThat(res.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void test_getOrderItemsByOrderId() throws Exception {
        when(orderItemService.getItemsByOrderId(Mockito.anyLong())).
                thenReturn(MockObjects.getOrderItems());
        MockHttpServletResponse res = mockMvc.perform(MockMvcRequestBuilders
                .get("/orderItems/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    public void test_CreateOrderItems() throws Exception {
        when(orderItemService.createOrderItems(Mockito.any())).
                thenReturn(MockObjects.getOrderItems());
        String json = mapper.writeValueAsString(MockObjects.getOrderItems());
        MockHttpServletResponse res = mockMvc.perform(MockMvcRequestBuilders
                .post("/orderItems")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                 .content(json))
                .andReturn()
                .getResponse();
        assertThat(res.getStatus()).isEqualTo(HttpStatus.CREATED.value());

    }

}


