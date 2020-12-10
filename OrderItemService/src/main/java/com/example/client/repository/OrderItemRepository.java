package com.example.client.repository;

import com.example.client.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * Find order by order-id
     * @param orderId
     * @return
     */
    List<OrderItem> findByOrderId(long orderId);

    @Query("FROM OrderItem o where o.orderId=:id")
    List<OrderItem>  findOrderItemsInfoByOrderId(@Param("id") long id);
}
