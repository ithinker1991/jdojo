package com.ashu.socket.single;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class HandlerState implements Runnable {
  private final SocketChannel socket;
  private final SelectionKey key;
  ByteBuffer input = ByteBuffer.allocate(1024);
  ByteBuffer output = ByteBuffer.allocate(1024);

  // handler 是可以维护状态的。Runnable 也是可以重复 run 的，带状态的Runnable
  static final int READING = 0;
  static final int WRITING = 1;
  int state = READING;

  public HandlerState(SocketChannel socket, Selector selector) throws ClosedChannelException {
    this.socket = socket;
    // 把socket 注册在 selector 上
    key = socket.register(selector, 0);
    key.attach(this);
    key.interestOps(SelectionKey.OP_READ);
    selector.wakeup();
  }

  @Override
  public void run() {
    try {
      read();
      key.attach(new WriteTask());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void read() throws IOException {
    socket.read(input);
  }

  class WriteTask implements Runnable {
    @Override
    public void run() {
      try {
        socket.write(output);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


  private void process() throws IOException {
    // add data into output
  }
}
