package com.sau.entity;

import java.util.Arrays;

public class RequestToMethodItem {

    private int id;
    private String requestUrl;
    private String requestType;
    private String controllerName;
    private String requestMethodName;
    private Class<?>[] methodParamTypes;

    public RequestToMethodItem(int id, String requestUrl, String requestType, String controllerName, String requestMethodName, Class<?>[] methodParamTypes) {
        this.id = id;
        this.requestUrl = requestUrl;
        this.requestType = requestType;
        this.controllerName = controllerName;
        this.requestMethodName = requestMethodName;
        this.methodParamTypes = methodParamTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getRequestMethodName() {
        return requestMethodName;
    }

    public void setRequestMethodName(String requestMethodName) {
        this.requestMethodName = requestMethodName;
    }

    public Class<?>[] getMethodParamTypes() {
        return methodParamTypes;
    }

    public void setMethodParamTypes(Class<?>[] methodParamTypes) {
        this.methodParamTypes = methodParamTypes;
    }

    @Override
    public String toString() {
        return "RequestToMethodItem{" +
                "requestUrl='" + requestUrl + '\'' +
                ", requestType='" + requestType + '\'' +
                ", controllerName='" + controllerName + '\'' +
                ", requestMethodName='" + requestMethodName + '\'' +
                ", methodParamTypes=" + Arrays.toString(methodParamTypes) +
                '}';
    }
}
