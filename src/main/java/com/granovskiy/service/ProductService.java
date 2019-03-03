package com.granovskiy.service;

import com.granovskiy.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> getById(Long id);
}
