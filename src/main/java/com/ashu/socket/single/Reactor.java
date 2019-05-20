package com.ashu.socket.single;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class Reactor implements Runnable {

  final Selector selector;
  final ServerSocketChannel serverSocket;

  public Reactor(int port) throws IOException {
    selector = Selector.open();
    serverSocket = ServerSocketChannel.open();
    serverSocket.socket().bind(new InetSocketAddress(port));
    SelectionKey key = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    key.attach(new Acceptor(serverSocket, selector));
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        selector.select();
        Set<SelectionKey> selected = selector.selectedKeys();
        for (SelectionKey key : selected) {
          dispatch(key);
        }
        selected.clear(); // why ?
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void dispatch(SelectionKey key) {
    // 这种把socket 传来传去的技能
    Runnable task = (Runnable)(key.attachment());
    if (task != null) {
      task.run();
    }
  }
}
