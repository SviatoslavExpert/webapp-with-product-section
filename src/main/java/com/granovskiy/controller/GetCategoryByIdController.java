package com.granovskiy.controller;

import com.granovskiy.Request;
import com.granovskiy.ViewModel;
import com.granovskiy.service.CategoryService;

import static java.util.Collections.emptyList;

public class GetCategoryByIdController implements Controller {

    private final CategoryService categoryService;

    public GetCategoryByIdController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request req) {
        String param = req.getParam("c_id")[0];
        System.out.println("Hello, this is the info: " + req.getParam("c_id")[0]);
        Long id = Long.parseLong(param);
        return categoryService.getById(id)
                //object with property string is created , adding string and object to map
                .map(c -> ViewModel.of("category").withAttribute("category", c))
                .orElseGet(() -> ViewModel.of("category").withAttribute("category", emptyList()));
    }
}
