package com.ashu.concurrent.mylock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteReentrance {
  ReentrantLock lock = new ReentrantLock();
  Condition readCond =  lock.newCondition();
  Condition writeCond =  lock.newCondition();
  private int readers = 0;
  private int writers = 0;
  private int writeRequest = 0;

  public  void unlockRead() {
    lock.lock();
    readers--;
    lock.unlock();
  }

  public  void unlockWrite() {
    lock.lock();
    writers--;
    if (writeRequest == 0) {
      readCond.signalAll();
    } else {
      writeCond.signalAll();
    }
    readCond.signalAll();
    lock.unlock();
  }

  public void lockRead() throws InterruptedException {
    lock.lock();
    while (writers > 0 || writeRequest > 0) {
      readCond.await();
      writeCond.await();
    }
    readers++;
  }

  public  void lockWrite() throws InterruptedException {
    lock.lock();
    writeRequest++;
    while (readers > 0) {
      readCond.await();
    }
    writers++;
    writeRequest--;
    readCond.signalAll();
    lock.unlock();
  }


}
