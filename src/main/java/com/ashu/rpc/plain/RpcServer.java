package com.ashu.rpc.plain;

import com.ashu.rpc.HiService;
import com.ashu.rpc.HiServiceImpl;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {

    public void export(Object service, int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        for (;;) {
            Socket socket = serverSocket.accept();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    String methodName = input.readUTF();
                    Object paramTypes = input.readObject();
                    Object[] params = (Object[]) input.readObject();

                    Method method1 = service.getClass().getMethod(methodName, (Class<?>[]) paramTypes);
                    Object result =  method1.invoke(service, params);
                    output.writeObject(result);
                } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        output.close();
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws IOException {
        HiService service = new HiServiceImpl();
        new RpcServer().export(service, 1234);
    }
}
