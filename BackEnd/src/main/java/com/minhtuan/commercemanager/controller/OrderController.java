package com.minhtuan.commercemanager.controller;

import com.minhtuan.commercemanager.message.request.ApiResponse;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderRequest) {
        try {
            OrderDTO obj = orderService.addOrder(orderRequest);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }

    @GetMapping("/listOrder/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> listOrder(@PathVariable Long id)
    {
        try {
            List<OrderDTO> listDTO = orderService.getListOrderByUserId(id);
            return ResponseEntity.ok(listDTO);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
        }
    }



}
