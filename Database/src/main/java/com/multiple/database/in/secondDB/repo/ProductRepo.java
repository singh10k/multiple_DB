package com.multiple.database.in.secondDB.repo;

import com.multiple.database.in.secondDB.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
