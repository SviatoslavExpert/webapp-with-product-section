package com.granovskiy;

import java.util.HashMap;
import java.util.Map;

public class ViewModel {
    private final String view;
    private final Map<String, Object> attributes = new HashMap<>();
    private final String REDIRECT_TEMPLATE = "/WEB-INF/views/%s.jsp";

    public ViewModel(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //  name and object are put into a map like: key (string) -> value (object)
    public ViewModel withAttribute(String name, Object o) {
        this.attributes.put(name, o);
        return this;
    }

    public static ViewModel of(String view) {
        return new ViewModel(view);
    }

    public String getRedirectUri() {
        return String.format(REDIRECT_TEMPLATE, view);
    }
}
