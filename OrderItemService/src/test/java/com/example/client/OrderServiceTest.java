package com.example.client;

import com.example.client.entity.OrderItem;
import com.example.client.repository.OrderItemRepository;
import com.example.client.service.impl.OrderItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    OrderItemService orderItemService;

    @Mock
    OrderItemRepository orderItemRepository;

    @Test
    public void test_createOrderItem() {
        Mockito.when(orderItemRepository.save(Mockito.any())).thenReturn(new OrderItem());
        OrderItem item = new OrderItem();
        item.setOrderId(1);
        item.setPerItemCost(10);
        item.setId((long)1);
        item.setProductCode("AAB");
        item.setQuantity(1);
        boolean res = orderItemService.createOrderItem(item);
        assertThat(res).isEqualTo(true);

    }

}
