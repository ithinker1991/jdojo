package com.ashu.concurrent.ProducerConsumerModle;

public abstract class AbstractSafeQueue<T> implements SafeQueue<T> {
  private final static int DEFAULF_CAPACTITY = 1024;
  T[] data;
  int capacity;
  int size;
  public AbstractSafeQueue(int capacity) {
    int size = 0;
  }

  public AbstractSafeQueue() {
    this(DEFAULF_CAPACTITY);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T pop() {
    return null;
  }

  @Override
  public void push(T t) {

  }
}
