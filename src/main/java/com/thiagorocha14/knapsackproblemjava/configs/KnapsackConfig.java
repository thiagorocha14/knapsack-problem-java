package com.thiagorocha14.knapsackproblemjava.configs;

import com.thiagorocha14.knapsackproblemjava.services.KnapsackService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnapsackConfig {

    @Bean
    KnapsackService knapsackService() {
        return new KnapsackService();
    }

}
