package com.thiagorocha14.knapsackproblemjava.responses;

import com.thiagorocha14.knapsackproblemjava.dtos.KnapsackDTO;

public record SolvedKnapsackResponse(KnapsackDTO solution, String message, String execution_time) {
}
