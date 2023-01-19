package com.malchev.HomeWork16.services;

import com.malchev.HomeWork16.domain.dto.OrderReqDTO;
import com.malchev.HomeWork16.domain.dto.OrderRespDTO;
import com.malchev.HomeWork16.mappers.OrderMapper;
import com.malchev.HomeWork16.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Optional<OrderRespDTO> getOrderById(Long orderId) {
        return orderRepository.getOrderById(orderId)
                .map(orderMapper::orderToRespDTO);
    }

    @Override
    public List<OrderRespDTO> getOrders() {
        return orderRepository.getOrders()
                .stream()
                .map(orderMapper::orderToRespDTO)
                .toList();
    }

    @Override
    public Optional<OrderRespDTO> addOrder(OrderReqDTO orderReqDTO) {
        return orderMapper.orderReqDTOToOrder(orderReqDTO)
                .map(orderRepository::addOrder)
                .map(orderMapper::orderToRespDTO);

    }
}
