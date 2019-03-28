package com.ashu.concurrent.lock;

public class MyReentrantLock {

    private int lockedCount = 0;
    private Thread lockedBy;
    private boolean locked;
    synchronized public void lock() throws InterruptedException {

        Thread callingThread = Thread.currentThread();
        while (locked && callingThread != lockedBy) {
            wait();
        }
        locked = true;
        lockedBy = callingThread;
        lockedCount++;
    }

    synchronized  public void unlock() {
        if (Thread.currentThread() == lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                locked = false;
                notifyAll();
            }
        } else {
            throw new IllegalThreadStateException("The thread to unlock must have lock");
        }

    }
}
