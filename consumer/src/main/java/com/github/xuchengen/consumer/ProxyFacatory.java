package com.github.xuchengen.consumer;

import java.io.Serializable;
import java.lang.reflect.Proxy;

public class ProxyFacatory {

    public static <T> T getInstance(Class<T> service) {
        return (T) Proxy.newProxyInstance(ProxyFacatory.class.getClassLoader(), new Class[]{
                service, Serializable.class
        }, new RpcInvocationHandler());
    }

}
