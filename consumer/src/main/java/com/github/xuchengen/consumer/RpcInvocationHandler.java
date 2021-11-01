package com.github.xuchengen.consumer;

import com.github.xuchengen.api.annotation.ServiceMappend;
import com.github.xuchengen.api.dto.RpcRequestInfoDTO;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class RpcInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequestInfoDTO rpcRequestInfoDTO = new RpcRequestInfoDTO();
        rpcRequestInfoDTO.setClassPath(method.getDeclaringClass().getAnnotation(ServiceMappend.class).value());
        rpcRequestInfoDTO.setMethod(method.getName());
        rpcRequestInfoDTO.setParams(args);

        Socket socket = new Socket("127.0.0.1", 9999);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(rpcRequestInfoDTO);
        objectOutputStream.flush();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Object response = objectInputStream.readObject();

        objectOutputStream.close();
        objectInputStream.close();
        return response;
    }
}
