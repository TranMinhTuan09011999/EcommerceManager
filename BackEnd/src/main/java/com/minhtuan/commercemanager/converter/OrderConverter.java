package com.minhtuan.commercemanager.converter;

import com.minhtuan.commercemanager.model.AddCart;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderDTO toDTO(Order order){
        OrderDTO dto = new OrderDTO();
        dto.setOrder_date(order.getOrder_date());
        dto.setAmount(order.getAmount());
        dto.setAddress(order.getAddress());
        dto.setReceiver(order.getReceiver());
        dto.setPhone_number(order.getPhone_number());
        dto.setStatus(order.getStatus());
        dto.setUser_id(order.getUser().getId());
        return dto;
    }
}
