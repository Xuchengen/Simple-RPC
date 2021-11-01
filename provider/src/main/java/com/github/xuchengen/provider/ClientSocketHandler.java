package com.github.xuchengen.provider;

import com.github.xuchengen.api.dto.RpcRequestInfoDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Objects;

/**
 * 客户端套接字处理器
 */
public class ClientSocketHandler implements Runnable {

    private Socket clientSocket;

    public ClientSocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            RpcRequestInfoDTO request = (RpcRequestInfoDTO) objectInputStream.readObject();
            System.out.println("[RPC请求信息]：" + request);
            Object[] params = request.getParams();
            Class[] paramTypes = null;
            if (Objects.nonNull(params)) {
                paramTypes = new Class[params.length];
                for (int i = 0; i < params.length; i++) {
                    paramTypes[i] = params[i].getClass();
                }
            }

            Class<?> clazz = Class.forName(request.getClassPath());
            Object instance = clazz.newInstance();
            Method method = clazz.getDeclaredMethod(request.getMethod(), paramTypes);
            Object response = method.invoke(instance, params);
            System.out.println("[RPC响应信息]：" + response);

            objectOutputStream.writeObject(response);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(objectInputStream)) {
                    objectInputStream.close();
                }
                if (Objects.nonNull(objectOutputStream)) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
