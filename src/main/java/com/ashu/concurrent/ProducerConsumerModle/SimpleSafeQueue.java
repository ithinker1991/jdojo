package com.ashu.concurrent.ProducerConsumerModle;

public class SimpleSafeQueue<T> implements SafeQueue<T> {


  @Override
  public int size() {
    return 0;
  }

  @Override
  public T pop() {
    return null;
  }

  @Override
  public void push(T t) {

  }
}
