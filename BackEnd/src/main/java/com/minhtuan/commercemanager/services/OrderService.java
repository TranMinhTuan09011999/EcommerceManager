package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.Order;

import java.util.List;

public interface OrderService {
    OrderDTO addOrder(OrderDTO orderDTO) throws Exception;

    Order getOrderById(Long id) throws Exception;

    List<OrderDTO> getListOrderByUserId(Long user_Id) throws Exception;
}
