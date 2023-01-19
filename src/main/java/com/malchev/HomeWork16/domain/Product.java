package com.malchev.HomeWork16.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private long id;
    private String name;
    private long cost;
}
