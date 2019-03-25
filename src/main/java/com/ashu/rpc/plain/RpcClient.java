package com.ashu.rpc.plain;

import com.ashu.rpc.HiService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class RpcClient {

    @SuppressWarnings("unchecked")
    public <T> T refer(Class<T> serviceInterface, String host, int port) {
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[] {serviceInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Socket socket = new Socket(host, port);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                    output.writeUTF(method.getName());
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(args);

                    return input.readObject();
                } finally {

                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        HiService service = new RpcClient().refer(HiService.class, "localhost", 1234);
        for (;;) {
            Thread.sleep(1000);
            System.out.println(service.hello("书"));
        }
    }

}
