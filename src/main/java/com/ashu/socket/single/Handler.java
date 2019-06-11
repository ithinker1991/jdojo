package com.ashu.socket.single;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable {
  private final SocketChannel socket;
  private final SelectionKey key;
  private ByteBuffer input = ByteBuffer.allocate(1024);
  private ByteBuffer output = ByteBuffer.allocate(1024);

  // handler 是可以维护状态的。Runnable 也是可以重复 run 的，带状态的Runnable
  private static final int READING = 0;
  private static final int WRITING = 1;
  int state = READING;

  public Handler(SocketChannel socket, Selector selector) throws ClosedChannelException {
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
      if (state == READING) {
        read();
      } else if (state == WRITING) {
        write();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void read() throws IOException {
    socket.read(input);
    process();
    state = WRITING;
    key.interestOps(SelectionKey.OP_WRITE);
    key.selector().wakeup();
  }

  private void write() throws IOException {
    socket.write(output);
  }

  private void process() throws IOException {
    // add data into output
    write();
  }
}
