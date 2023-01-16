package org.github.ybqdren.entity;

/**
 * @author zhao wen
 * @sice 1/16/2023
 **/
public class Order {
   String id;
   String user_id ;
   OrderStatus orderStatus;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   public OrderStatus getOrderStatus() {
      return orderStatus;
   }

   public void setOrderStatus(OrderStatus orderStatus) {
      this.orderStatus = orderStatus;
   }
}
