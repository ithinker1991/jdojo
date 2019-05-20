package com.ashu.concurrent.ProducerConsumerModle;

public class WaitNotifyDemo {


  static class Buffer {
    private final String[] data;
    private final int MAX_SIZE;
    private int tail;
    private int head;
    private int size;

    public Buffer(int size) {
      MAX_SIZE = size;
      data = new String[MAX_SIZE];
      tail = 0;
      head = 0;
    }

    public synchronized void put(String s) throws InterruptedException {
      while (size >= MAX_SIZE) {
        System.out.println("buffer满了，等待");
        wait();
        System.out.println(Thread.currentThread() + " 醒过来");
      }
      data[tail] = s;
      tail = (tail + 1) % MAX_SIZE;
      size++;
      System.out.println("Consumer["+ Thread.currentThread().getName() + "]生产" + "，当前总量：" + size);
      notifyAll();
    }

    public synchronized String take() throws InterruptedException {

      while (size <= 0) {
        System.out.println("buffer空了，等待");
        wait();
        System.out.println(Thread.currentThread() + " 醒过来");
      }
      String ret = data[head];
      head = (head + 1) % MAX_SIZE;
      size--;
      notifyAll();
      System.out.println("Producer["+ Thread.currentThread().getName() + "]消费" + "，当前总量：" + size);
      return ret;
    }



  }

  static class Producer implements Runnable {
    private Buffer buffer;
    private volatile boolean shouldExit;
    public Producer(Buffer buffer) {
      this.buffer = buffer;
    }


    @Override
    public void run() {
      while (!shouldExit) {
        try {
          String s = "Consumer[" + Thread.currentThread().getName() + "]" + "生产";
          buffer.put(s);
          Thread.sleep(1000);

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Consumer implements Runnable {
    private Buffer buffer;
    private volatile boolean shouldExit;
    public Consumer(Buffer buffer) {
      this.buffer = buffer;
      shouldExit = false;
    }
    @Override
    public void run() {
      try {
        while (!shouldExit) {
          String s = buffer.take();
          Thread.sleep(1000);
        }
//        System.out.println("Producer["+ Thread.currentThread() + "]消费");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  public static void main(String[] args) {
    int maxSize = 10;
    Buffer buffer = new Buffer(maxSize);

    for (int i = 0; i < 10; i ++) {

      Thread t = new Thread(new Producer(buffer));
      t.setName(i + "");
      t.start();
    }

    for (int i = 0; i < 9; i ++) {

      Thread t = new Thread(new Consumer(buffer));
      t.setName(i + "");
      t.start();
    }
  }



}
