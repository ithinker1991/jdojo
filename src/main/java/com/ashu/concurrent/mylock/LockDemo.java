package com.ashu.concurrent.mylock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

  public static void main(String[] args) {
    ReentrantLock l = new ReentrantLock(true);
    l.lock();

    l.unlock();
  }

}
