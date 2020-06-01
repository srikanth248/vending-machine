package com.design.system.vendingmachine.service;

import com.design.system.vendingmachine.exception.ProductException;
import com.design.system.vendingmachine.model.Product;
import com.design.system.vendingmachine.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public double getProductPrice(String productCode) throws ProductException {
        Optional<Product> product = productRepo.findById(productCode);
        if(product.isPresent()) {
            return product.get().getProductCost();
        }
        throw new ProductException("Product not found.");
    }
}
