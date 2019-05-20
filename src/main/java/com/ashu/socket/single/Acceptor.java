package com.ashu.socket.single;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {

  private final ServerSocketChannel serverSocket;
  private final Selector selector;

  public Acceptor(ServerSocketChannel serverSocket, Selector selector) {
    this.serverSocket = serverSocket;
    this.selector = selector;
  }

  @Override
  public void run() {
    try {
      SocketChannel socket = serverSocket.accept();
      if (socket != null) {
        // attach 这种把依赖关系给倒转了的方式很有意思，看你要把代码的控制权交给谁
        new Handler(socket, selector);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
