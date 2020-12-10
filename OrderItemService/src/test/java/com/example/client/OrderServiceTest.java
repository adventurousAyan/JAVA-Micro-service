package com.example.client;

import com.example.client.clientfactory.OrderClient;
import com.example.client.entity.OrderItem;
import com.example.client.repository.OrderItemRepository;
import com.example.client.response.CustomResponse;
import com.example.client.service.impl.OrderItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    OrderItemService orderItemService;

    @Mock
    OrderItemRepository orderItemRepository;

    @Mock
    OrderClient orderClient;

    @Test
    public void test_createOrderItem() {
        OrderItem item = new OrderItem();
        item.setOrderId(1);
        item.setPerItemCost(10);
        item.setId((long)1);
        item.setProductCode("AAB");
        item.setQuantity(1);
        Mockito.when(orderItemRepository.save(Mockito.any())).thenReturn(item);
        boolean res = orderItemService.createOrderItem(item);
        assertThat(res).isEqualTo(true);

    }

    @Test
    public void test_createOrderItems() {
        Mockito.when(orderItemRepository.saveAll(Mockito.any())).thenReturn(MockObjects.getOrderItems());
        Mockito.when(orderClient.getOrderByOrderId(Mockito.anyLong()))
                .thenReturn(new CustomResponse(HttpStatus.OK, MockObjects.getOrder()));
        List<OrderItem> orderItems = orderItemService.createOrderItems(MockObjects.getOrderItems());
        assertThat(orderItems.size()).isEqualTo(1);

    }

    @Test
    public void test_getOrderItemByOrderId() {
        Mockito.when(orderItemRepository.findOrderItemsInfoByOrderId(Mockito.anyLong())).thenReturn(MockObjects.getOrderItems());
        List<OrderItem> orderItems = orderItemService.getItemsByOrderId(1);
        assertThat(orderItems.size()).isEqualTo(1);

    }

}
