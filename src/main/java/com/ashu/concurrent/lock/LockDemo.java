package com.ashu.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

  public static void main(String[] args) {
    ReentrantLock l = new ReentrantLock(true);
    l.lock();

    l.unlock();
  }

}
