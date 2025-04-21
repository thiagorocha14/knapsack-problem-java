package com.thiagorocha14.knapsackproblemjava.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductDTO {
    private int quantity;
    private int weight;
    private int price;

    public ProductDTO(int quantity, int weight, int price) {
        this.quantity = quantity;
        this.weight = weight;
        this.price = price;
    }
}
