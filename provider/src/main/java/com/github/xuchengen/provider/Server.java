package com.github.xuchengen.provider;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(150);

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            threadPool.submit(new ClientSocketHandler(socket));
        }
    }

}
