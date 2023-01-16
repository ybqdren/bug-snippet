package org.github.ybqdren.service;

import org.github.ybqdren.entity.Order;
import org.github.ybqdren.entity.OrderStatus;
import org.github.ybqdren.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 修改一级缓存值，缓存值发生变化，导致第二次打到缓存上时出现了问题
 *
 * @author zhao wen
 * @sice 1/16/2023
 **/

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Transactional
    public List<Order> getOrderInfo() {
        String targetUserId = "000001";
        List<Order> completeOrderByUser = getCompleteOrderByUser(targetUserId);
        Order order = new Order();
        order.setOrderStatus(OrderStatus.COMPLETED);
        order.setId("000002");
        order.setUser_id("000002");
        completeOrderByUser.add(
                order
        );
        completeOrderByUser = getCompleteOrderByUser(targetUserId);
        return completeOrderByUser;
    }

    public List<Order> getCompleteOrderByUser(String userId) {
        List<Order> orderByUserAndStatus = orderMapper.getOrderByUserAndStatus(userId, OrderStatus.COMPLETED);
        return orderByUserAndStatus;
    }

}
