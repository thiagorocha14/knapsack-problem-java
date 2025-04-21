package com.thiagorocha14.knapsackproblemjava.services;

import com.thiagorocha14.knapsackproblemjava.dtos.CombinationDTO;
import com.thiagorocha14.knapsackproblemjava.dtos.KnapsackDTO;
import com.thiagorocha14.knapsackproblemjava.dtos.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class KnapsackService {

    private final KnapsackDTO knapsack;

    public KnapsackService() {
        this.knapsack = new KnapsackDTO(
                0,
                0,
                new CombinationDTO(
                    0,
                    0,
                    new ArrayList<>()
                )
        );
    }

    public KnapsackDTO solve(List<ProductDTO> products, int knapsackCapacity) {
        this.knapsack.setCapacity(knapsackCapacity);
        this.knapsack.setNumber_of_combinations(this.calculateNumberOfCombinations(products));

        int begin = 0;
        int end = this.knapsack.getNumber_of_combinations();

        for (int i = begin; i < end; i++) {
            CombinationDTO combination = CombinationService.createCombination(i, products);

            if (!this.canStoreProduct(combination, knapsackCapacity)) {
                continue;
            }

            if (this.isBetterCombination(combination)) {
                this.knapsack.setCombination(combination);
            }
        }

        return this.knapsack;
    }

    private int calculateNumberOfCombinations(List<ProductDTO> products) {
        List<Integer> quantities = new ArrayList<>();

        for (ProductDTO product : products) {
            quantities.add(product.getQuantity() + 1);
        }

        int numberOfCombinations = 1;

        for (Integer quantity : quantities) {
            numberOfCombinations *= quantity;
        }

        return numberOfCombinations;
    }

    private boolean canStoreProduct(CombinationDTO combination, int knapsackCapacity) {
        return combination.getWeight() <= knapsackCapacity;
    }

    private boolean isBetterCombination(CombinationDTO combination) {
        if (combination.getPrice() > this.knapsack.getCombination().getPrice()) {
            return true;
        }

        if (combination.getPrice() == this.knapsack.getCombination().getPrice()) {
            return combination.getWeight() < this.knapsack.getCombination().getWeight();
        }

        return false;
    }
}
