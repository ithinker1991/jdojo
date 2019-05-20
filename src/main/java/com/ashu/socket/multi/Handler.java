package com.ashu.socket.multi;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Handler implements Runnable {
  private static ExecutorService pool = Executors.newFixedThreadPool(10);
  static final int READING = 0;
  static final int WRITING = 1;
  private int state = READING;
  static final int PROCESSING = 3;


  private final SocketChannel socket;
  private final SelectionKey key;
  ByteBuffer input = ByteBuffer.allocate(1024);
  ByteBuffer output = ByteBuffer.allocate(1024);

  public Handler(SocketChannel socket, Selector selector) throws ClosedChannelException {
    this.socket = socket;
    // 把socket 注册在 selector 上
    key = socket.register(selector, 0);
    key.attach(this);
    key.interestOps(SelectionKey.OP_READ);
    selector.wakeup();
  }

  synchronized void read() throws IOException {
    socket.read(input);
    state = PROCESSING;
    pool.execute(new Processor());
  }

  synchronized void processAndHandOff() {
    process();
    state = WRITING;
    key.interestOps(SelectionKey.OP_WRITE);
  }

  private void process() {
    // 执行具体的业务 decode buz encode
  }


  @Override
  public void run() {

  }

  class Processor implements Runnable {

    @Override
    public void run() {
      processAndHandOff();
    }
  }

}
