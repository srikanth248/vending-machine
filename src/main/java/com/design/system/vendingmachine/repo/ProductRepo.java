package com.design.system.vendingmachine.repo;

import com.design.system.vendingmachine.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, String> {
}
