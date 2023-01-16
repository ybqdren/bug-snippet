package org.github.ybqdren;

import jakarta.annotation.Resource;
import org.github.ybqdren.entity.Order;
import org.github.ybqdren.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zhao wen
 * @sice 1/16/2023
 **/

@SpringBootTest
public class OrderServiceTest {
    @Resource
    OrderService orderService;

    @Test
    public void testGetOrderInfo() {
        // Setup
        // Run the test
        final List<Order> result = orderService.getOrderInfo();
        Assertions.assertTrue(result.size() == 1);
        // Verify the results
    }
}
