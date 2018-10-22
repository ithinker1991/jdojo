package com.ashu.lang.commoninterface;

import java.util.Iterator;

public class IterableDemo {

  static class MyIter implements Iterable<String> {

    private String[] data = "The marathon is a long-distance race, completed by running, walking, or a run/walk strategy. There are also wheelchair divisions. The marathon has an official distance of 42.195 kilometres (26.219 miles; 26 miles 385 yards),[1] usually run as a road race. The event was instituted in commemoration of the fabled run of the Greek soldier Pheidippides, a messenger from the Battle of Marathon to Athens, who reported the victory.".split(" ");
    @Override
    public Iterator<String> iterator() {
      return new Iterator<String>() {
        private int index = 0;
        @Override
        public boolean hasNext() {
          return index < data.length;
        }

        @Override
        public String next() {
          return data[index++];
        }
      };
    }
  }

  public static void main(String[] args) {
    MyIter iter = new MyIter();
    for (String s: iter) {
      System.out.println(s);
    }
  }

}
