package com.minhtuan.commercemanager.converter;

import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDetailsDTO;
import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.model.OrderDetails;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsConverter {
    public OrderDetailsDTO toDTO(OrderDetails orderDetails) {
        OrderDetailsDTO dto = new OrderDetailsDTO();
        dto.setOrder(orderDetails.getOrder());
        dto.setProduct(orderDetails.getProduct());
        dto.setQuantity(orderDetails.getQuantity());
        dto.setAmount(orderDetails.getAmount());
        dto.setDiscount(orderDetails.getDiscount());
        return dto;
    }
}
