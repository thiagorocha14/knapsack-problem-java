package com.thiagorocha14.knapsackproblemjava.controllers;

import com.thiagorocha14.knapsackproblemjava.dtos.KnapsackDTO;
import com.thiagorocha14.knapsackproblemjava.dtos.ProductDTO;
import com.thiagorocha14.knapsackproblemjava.requests.SolveKnapsackRequest;
import com.thiagorocha14.knapsackproblemjava.responses.SolvedKnapsackResponse;
import com.thiagorocha14.knapsackproblemjava.services.KnapsackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("solve")
public class SolveKnapsackController {

    private final KnapsackService knapsackService;

    public SolveKnapsackController(KnapsackService knapsackService) {
        this.knapsackService = knapsackService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public SolvedKnapsackResponse solveKnapsack(@RequestBody SolveKnapsackRequest request) {
        long startTime = System.currentTimeMillis();

        int knapsackCapacity = request.knapsack_capacity();
        List<ProductDTO> products = request.products();

        KnapsackDTO knapsack = this.knapsackService.solve(products, knapsackCapacity);

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        return new SolvedKnapsackResponse(
            knapsack,
            "Knapsack problem solved successfully",
            String.valueOf(timeTaken)
        );
    }
}
