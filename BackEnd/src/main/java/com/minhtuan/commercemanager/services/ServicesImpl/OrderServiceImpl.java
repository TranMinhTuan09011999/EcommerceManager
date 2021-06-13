package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.converter.OrderConverter;
import com.minhtuan.commercemanager.message.request.OrderDetailsRequest;
import com.minhtuan.commercemanager.model.AddCart;
import com.minhtuan.commercemanager.model.DTO.AddCartDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDTO;
import com.minhtuan.commercemanager.model.DTO.OrderDetailsDTO;
import com.minhtuan.commercemanager.model.Order;
import com.minhtuan.commercemanager.model.Product;
import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.repository.OrderRepository;
import com.minhtuan.commercemanager.repository.UserRepository;
import com.minhtuan.commercemanager.services.CartService;
import com.minhtuan.commercemanager.services.OrderDetailsService;
import com.minhtuan.commercemanager.services.OrderService;
import com.minhtuan.commercemanager.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderDetailsService orderDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) throws Exception {
        try {
            Order obj = new Order();
            obj.setOrder_date(orderDTO.getOrder_date());
            obj.setAmount(orderDTO.getAmount());
            obj.setAddress(orderDTO.getAddress());
            obj.setPhone_number(orderDTO.getPhone_number());
            obj.setReceiver(orderDTO.getReceiver());
            obj.setStatus(orderDTO.getStatus());
            User pro = userService.findById(orderDTO.getUser_id()).orElseThrow();
            obj.setUser(pro);
            orderRepository.save(obj);
            List<AddCartDTO> list = cartService.getCartByUserId(orderDTO.getUser_id());
            list.stream().forEach(
                    (s) -> {
                        OrderDetailsRequest orderDetailsRequest = new OrderDetailsRequest();
                        orderDetailsRequest.setOrderId(obj.getId());
                        orderDetailsRequest.setProductId(s.getProduct().getId());
                        orderDetailsRequest.setQuantity(s.getQuantity());
                        orderDetailsRequest.setAmount(s.getPrice());
                        orderDetailsRequest.setDiscount(s.getProduct().getPromotion());
                        try {
                            OrderDetailsDTO orderDetailsDTO = orderDetailsService.addOrderDetailByOrderId(orderDetailsRequest);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
            System.out.println("aa");
            cartService.removeCartByUserId(orderDTO.getUser_id());
            return orderConverter.toDTO(obj);
        }catch(Exception e) {
            e.printStackTrace();
            logger.error(""+e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Order getOrderById(Long id) throws Exception {
        Order order = orderRepository.getById(id);
        return order;
    }

    @Override
    public List<OrderDTO> getListOrderByUserId(Long user_Id) throws Exception {
        User user = userService.findById(user_Id).orElseThrow();
        List<Order> list = orderRepository.findOrdersByUser(user);
        List<OrderDTO> listDTO = new ArrayList<>();
        list.stream().forEach(
                (s) -> {
                    listDTO.add(orderConverter.toDTO(s));
                }
        );
        return listDTO;
    }
}
