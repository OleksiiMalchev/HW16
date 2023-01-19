package com.malchev.HomeWork16.controllers;


import com.malchev.HomeWork16.domain.dto.OrderReqDTO;
import com.malchev.HomeWork16.domain.dto.OrderRespDTO;
import com.malchev.HomeWork16.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders/{id}")
    public ResponseEntity<? super OrderRespDTO> getOrderById(@PathVariable("id") Long id) {
        Optional<OrderRespDTO> orderById = orderService.getOrderById(id);
        if (orderById.isPresent()) {
            return ResponseEntity.status(200).body(orderById);
        }
        return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders")
    public ResponseEntity<? super List<OrderRespDTO>> allOrders() {
        List<OrderRespDTO> orders = orderService.getOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>("Orders not found ", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<? super OrderRespDTO> create(@RequestBody(required = false) OrderReqDTO orderReqDTO) {
        if (orderReqDTO.getProducts() == null) {
            return new ResponseEntity<>("Order not create", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(201).body(orderService.addOrder(orderReqDTO));
    }
}
