package com.thiagorocha14.knapsackproblemjava.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class CombinationDTO {
    private int price;
    private int weight;
    private List<Integer> products;

    public CombinationDTO(int price, int weight, List<Integer> products) {
        this.price = price;
        this.weight = weight;
        this.products = products;
    }
}
