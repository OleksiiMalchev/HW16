package com.malchev.HomeWork16.services;


import com.malchev.HomeWork16.domain.dto.OrderReqDTO;
import com.malchev.HomeWork16.domain.dto.OrderRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Optional<OrderRespDTO> getOrderById(Long orderId);

    List<OrderRespDTO> getOrders();

    Optional<OrderRespDTO> addOrder(OrderReqDTO orderReqDTO);
}
