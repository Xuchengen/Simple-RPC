package com.github.xuchengen.api.dto;

import java.io.Serializable;
import java.util.Arrays;

public class RpcRequestInfoDTO implements Serializable {

    private static final long serialVersionUID = -965338092989608257L;

    private String classPath;

    private String method;

    private Object[] params;

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RpcRequestInfoDTO{" +
                "classPath='" + classPath + '\'' +
                ", method='" + method + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
