package com.granovskiy;

import java.util.Map;
import java.util.Objects;

public class Request {
    private final String method;
    private final String uri;
    private Map<String, String[]> params;

    public Request(String method, String uri, Map<String, String[]> params) {
        this.method = method;
        this.uri = uri;
        this.params = params;
    }

    public Request(String method, String uri) {
        this.method = method;
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    //  overloaded method to create a new object with
    public static Request of(String method, String uri, Map<String, String[]> params) {
        return new Request(method, uri, params);
    }

    //  overloaded method
    public static Request of(String method, String uri) {
        return new Request(method, uri);
    }

    public String[] getParam(String name) {
        return params.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(method, request.method) &&
                Objects.equals(uri, request.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uri);
    }
}
