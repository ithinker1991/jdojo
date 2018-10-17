package com.ashu.lang.commoninterface;

import java.util.Iterator;

public class IterableDemo {

  class MyIter implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
      return null;
    }
  }

}
