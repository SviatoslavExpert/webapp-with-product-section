package com.granovskiy;

import com.granovskiy.controller.*;

import com.granovskiy.controller.LoginUserController;
import com.granovskiy.service.CategoryService;
import com.granovskiy.service.CategoryServiceImpl;
import com.granovskiy.service.ProductService;
import com.granovskiy.service.ProductServiceImpl;
import com.granovskiy.service.UserService;
import com.granovskiy.service.UserServiceImpl;

public class Factory {

    //  User methods
    public static LoginUserController getLoginUserController(UserService userService) {
        return new LoginUserController(userService);
    }

    public static UserService getUserServiceImpl() {
        return new UserServiceImpl();
    }

    //  Categories methods    ???
    public static GetAllCategoriesController getGetAllCategoriesController(CategoryService categoryService) {
        return new GetAllCategoriesController(categoryService);
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl();
    }

    public static GetCategoryByIdController getGetCategoryByIdController(CategoryService categoryService) {
        return new GetCategoryByIdController(categoryService);
    }

    //  Product methods
    public static ProductService getProductService() {
        return new ProductServiceImpl();
    }

    public static GetProductByIdController getGetProductByIdController(ProductService productService) {
        return new GetProductByIdController(productService);
    }
}
