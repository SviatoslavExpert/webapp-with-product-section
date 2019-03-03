package com.granovskiy.controller;

import com.granovskiy.Request;
import com.granovskiy.ViewModel;
import com.granovskiy.service.ProductService;

import static java.util.Collections.emptyList;

public class GetProductByIdController implements Controller {

    private final ProductService productService;

    public GetProductByIdController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request req) {
        String param = req.getParam("p_id")[0];
        Long id = Long.parseLong(param);
        return productService.getById(id)
                .map(p -> ViewModel.of("product").withAttribute("product", p))
                .orElseGet(() -> ViewModel.of("product").withAttribute("product", emptyList()));
    }
}
