package com.ashu.socket.multireactor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Reactor {
  Selector[] selectors;
  ServerSocket serverSocket;
  int next = 0;

  class Acceptor implements Runnable {

    @Override
    public void run() {
      try {
        // 这里直接使用了阻塞式accept 方式
        Socket socket = serverSocket.accept();
        if (socket != null) {
          new Handler(selectors[next], socket);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
