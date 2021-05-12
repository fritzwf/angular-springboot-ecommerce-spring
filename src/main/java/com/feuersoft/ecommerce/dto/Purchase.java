package com.feuersoft.ecommerce.dto;

import com.feuersoft.ecommerce.entity.Address;
import com.feuersoft.ecommerce.entity.Customer;
import com.feuersoft.ecommerce.entity.Order;
import com.feuersoft.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

/**
 * Created by ffeuerbacher on 5/10/2021
 */

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
