package com.chiradet.ecommerce.dto;


import com.chiradet.ecommerce.entity.Address;
import com.chiradet.ecommerce.entity.Customer;
import com.chiradet.ecommerce.entity.Order;
import com.chiradet.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}