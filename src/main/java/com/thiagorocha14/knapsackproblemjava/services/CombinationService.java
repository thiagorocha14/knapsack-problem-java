package com.thiagorocha14.knapsackproblemjava.services;

import com.thiagorocha14.knapsackproblemjava.dtos.CombinationDTO;
import com.thiagorocha14.knapsackproblemjava.dtos.CombinationValueDTO;
import com.thiagorocha14.knapsackproblemjava.dtos.ProductDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationService {

    public static CombinationDTO createCombination(int index, List<ProductDTO> products) {
        List<Integer> bases = new ArrayList<Integer>();

        for (ProductDTO product : products) {
            bases.add(product.getQuantity());
        }

        List<Integer> selectedProducts = selectProducts(index, bases);
        CombinationValueDTO value = calculatePriceAndWeight(selectedProducts, products);

        return new CombinationDTO(value.price(), value.weight(), selectedProducts);
    }

    public static List<Integer> selectProducts(int index, List<Integer> bases) {
        List<Integer> selectedProducts = new ArrayList<>();
        int quotient = index;
        Collections.reverse(bases);

        for (int base : bases) {
            int rest = quotient % (base + 1);
            quotient = quotient / (base + 1);
            selectedProducts.add(rest);
        }

        Collections.reverse(selectedProducts);

        return selectedProducts;
    }

    public static CombinationValueDTO calculatePriceAndWeight(List<Integer> selectedProducts, List<ProductDTO> products) {
        int totalPrice = 0;
        int totalWeight = 0;

        for (int i = 0; i < selectedProducts.size(); i++) {
            int quantity = selectedProducts.get(i);
            ProductDTO product = products.get(i);

            totalPrice += product.getPrice() * quantity;
            totalWeight += product.getWeight() * quantity;
        }

        return new CombinationValueDTO(totalPrice, totalWeight);
    }
}
