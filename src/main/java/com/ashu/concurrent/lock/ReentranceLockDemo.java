package com.ashu.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranceLockDemo {

  ReentrantLock lock = new ReentrantLock();
  Condition condition = lock.newCondition();
  int cnt = 0;

  void syncMethod() throws InterruptedException {
    if (Thread.currentThread().getName().equals("mythread-"+1)) {
      System.out.println(Thread.currentThread().getName());
    }
    if (Thread.currentThread().getName().equals("mythread-"+2)) {
      System.out.println(Thread.currentThread().getName());
    }
    lock.lock();

    try {
      while (cnt < 10) {
        condition.await();
        condition.signal();
        cnt = 11;
      }
      cnt++;
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    ReentranceLockDemo reentranceLockDemo = new ReentranceLockDemo();

    for (int i = 0; i < 2; i++) {
      Thread t = new Thread(() -> {
        try {
          reentranceLockDemo.syncMethod();

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
      t.setName("mythread-" + (i+1));
      t.start();
    }


  }

}
