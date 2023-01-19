package com.malchev.HomeWork16.mappers;

import com.malchev.HomeWork16.domain.Order;
import com.malchev.HomeWork16.domain.dto.OrderReqDTO;
import com.malchev.HomeWork16.domain.dto.OrderRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ProductMapper productMapper;

    public Optional<Order> orderReqDTOToOrder(OrderReqDTO orderReqDTO) {
       return Optional.of(orderReqDTO)
               .map(o ->Order.builder()
                       .date(LocalDate.now())
                       .products(productMapper.orderReqDTOToProduct(orderReqDTO)).build());

    }

    public OrderRespDTO orderToRespDTO(Order order) {
        return Optional.ofNullable(order)
                .map(o -> OrderRespDTO
                        .builder()
                        .cost(order.getCost())
                        .id(order.getId())
                        .date(order.getDate())
                        .products(o.getProducts()
                                .stream()
                                .map(productMapper::productRespDTO)
                                .collect(Collectors.toList()))
                        .build())
                .orElse(null);


    }
}
