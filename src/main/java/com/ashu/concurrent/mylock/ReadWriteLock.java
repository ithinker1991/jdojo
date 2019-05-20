package com.ashu.concurrent.mylock;

public class ReadWriteLock {
  private int readers = 0;
  private int writers = 0;
  private int writeRequest = 0;
  private Thread thread;

  public synchronized void unlockRead() {
   readers--;
   notifyAll();
  }

  public synchronized void unlockWrite() {
   writers--;
   notifyAll();
  }

  public synchronized void lockRead() throws InterruptedException {
    thread = Thread.currentThread();
    while (writers > 0 || writeRequest > 0 || readers > 0) {
      wait();
    }
    readers++;
  }

  public synchronized void lockWrite() throws InterruptedException {
    if (readers > 0 ) {
      thread.interrupt();
      readers--;
    }
    writeRequest++;
    while (readers > 0 || writers > 0) {
      wait();
    }
    writers++;
    writeRequest--;
  }

  public static void main(String[] args) {

  }
}
