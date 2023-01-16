package org.github.ybqdren.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.github.ybqdren.entity.Order;
import org.github.ybqdren.entity.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhao wen
 * @sice 1/16/2023
 **/
@Mapper
@Repository
public interface OrderMapper {
    @Select("select id , user_id , order_status from `order` where user_id = #{userId} and order_status = #{orderStatus}")
    List<Order> getOrderByUserAndStatus(@Param("userId") String userId , @Param("orderStatus") OrderStatus orderStatus);
}
