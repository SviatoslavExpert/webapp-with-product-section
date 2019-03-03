package com.granovskiy;

import com.granovskiy.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.granovskiy.Factory.*;

public class MainServlet extends HttpServlet {

    private static final Map<Request, Controller> controllerMap = new HashMap<>();

    //  controllers are in the map, the controllers direct ...
    static {
        //  to the map - to put:   Request - Controller
        controllerMap.put(Request.of("GET", "/servlet/login"), r -> ViewModel.of("login"));
        controllerMap.put(Request.of("POST", "/servlet/login"), getLoginUserController(getUserServiceImpl()));
        controllerMap.put(Request.of("GET", "/servlet/categories"), getGetAllCategoriesController(getCategoryService()));
        controllerMap.put(Request.of("GET", "/servlet/category"), getGetCategoryByIdController(getCategoryService()));
        controllerMap.put(Request.of("GET", "/servlet/product"), getGetProductByIdController(getProductService()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = Request.of(req.getMethod(), req.getRequestURI(), req.getParameterMap());
        Controller controller = controllerMap.getOrDefault(request, r -> ViewModel.of("404"));
        ViewModel vm = controller.process(request);  //  ???
        processViewModel(vm, req, resp);
    }

    private void processViewModel(ViewModel vm, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //vm.getAttributes().forEach((k, v) -> req.setAttribute(k, v));
        vm.getAttributes().forEach(req::setAttribute);
        req.getRequestDispatcher(vm.getRedirectUri()).forward(req, resp);
    }
}
