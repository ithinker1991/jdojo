package com.ashu.concurrent.ProducerConsumerModle;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueDemo {
  static class Consumer implements Runnable{

    private BlockingQueue<String> queue;
    private volatile boolean shouldExit;
    public Consumer(BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      while(!shouldExit) {
        String s = queue.poll();
        System.out.println("Consumer[" + Thread.currentThread().getName() + "]消费, " + s);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Producer implements Runnable {
    private BlockingQueue<String> queue;
    private volatile boolean shouldExit;
    AtomicInteger index;

    public Producer(BlockingQueue<String> queue, AtomicInteger index) {
      this.queue = queue;
      this.shouldExit = false;
      this.index = index;
    }


    @Override
    public void run() {
      try {
        while (!shouldExit) {
          int i = index.getAndIncrement();
          String s = "数据" + i;
          System.out.println("Producer[" + Thread.currentThread().getName() + "]生产, " + s);
          queue.put(s);
          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    AtomicInteger index = new AtomicInteger(0);
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(new Producer(queue, index));
      t.setName(i + "");
      t.start();
    }

    for (int i = 0; i < 9; i++) {
      Thread t = new Thread(new Consumer(queue));
      t.setName(i + "");
      t.start();
    }
  }

}
