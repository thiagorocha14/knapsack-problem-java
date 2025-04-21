package com.thiagorocha14.knapsackproblemjava.requests;

import com.thiagorocha14.knapsackproblemjava.dtos.ProductDTO;

import java.util.List;

public record SolveKnapsackRequest(int knapsack_capacity, List<ProductDTO> products) {
}
