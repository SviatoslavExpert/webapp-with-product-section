package com.granovskiy.controller;

import com.granovskiy.Request;
import com.granovskiy.ViewModel;

public interface Controller {
    ViewModel process(Request req);
}
