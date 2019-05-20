package com.ashu.netty.plain;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class PlainNioServer {



  public static void main(String[] args) throws IOException {
    try (Selector serverSelector = Selector.open(); Selector clientSelector = Selector.open()) {
      new Thread(() -> {
        try {
          ServerSocketChannel listenerChannel = ServerSocketChannel.open();
          listenerChannel.socket().bind(new InetSocketAddress(8000));
          listenerChannel.configureBlocking(false);
          listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

          while (true) {
            if (serverSelector.select(1) > 0) {
              Set<SelectionKey> set = serverSelector.selectedKeys();

              Iterator<SelectionKey> iterator = set.iterator();
              while(iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                  try {
                    SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                  } finally {
                    iterator.remove();
                  }
                }
              }
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      new Thread(() -> {
        while (true) {
          try {
            if (clientSelector.select() > 0) {
              Set<SelectionKey> set = clientSelector.selectedKeys();
              Iterator<SelectionKey> iterator = set.iterator();
              while(iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                  try {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    clientChannel.read(buffer);
                    buffer.flip();
                    System.out.println(Charset.defaultCharset().newDecoder().decode(buffer));
                  } finally {
                    iterator.remove();
                    key.interestOps(SelectionKey.OP_READ);
                  }
                }
              }

            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      });

    }




  }


}
