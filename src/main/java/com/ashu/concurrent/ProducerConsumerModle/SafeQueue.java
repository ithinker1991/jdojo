package com.ashu.concurrent.ProducerConsumerModle;

public interface SafeQueue<T> {
  int size();
  T pop();
  void push(T t);
}
