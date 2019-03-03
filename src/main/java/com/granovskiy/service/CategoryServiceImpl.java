package com.granovskiy.service;

import com.granovskiy.model.Category;
import com.granovskiy.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private static List<Category> categories = new ArrayList<>();

    static {
        List<Product> products = new ArrayList<>();
        Product product = new Product(1L, "iPhone", "Apple product", 999.99);
        Product product2 = new Product(2L, "samsung", "korean product", 700.99);
        products.add(product);
        products.add(product2);
        Category category = new Category(1L, "Mobile Phones", "Best ever phones");
        category.setProducts(products);
        categories.add(category);
        categories.add(new Category(2L, "Shoes", "Italian shoes"));
        categories.add(new Category(3L, "TVs", "Chines TVs"));
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categories.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public static List<Product> getAllProducts() {
        return categories.stream().flatMap(c -> c.getProducts().stream()).collect(Collectors.toList());
    }
}
