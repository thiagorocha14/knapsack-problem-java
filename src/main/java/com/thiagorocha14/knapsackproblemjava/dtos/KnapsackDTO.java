package com.thiagorocha14.knapsackproblemjava.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class KnapsackDTO {
    private int capacity;
    private int number_of_combinations;
    private CombinationDTO combination;

    public KnapsackDTO(int capacity, int number_of_combinations, CombinationDTO combination) {
        this.capacity = capacity;
        this.number_of_combinations = number_of_combinations;
        this.combination = combination;
    }
}
