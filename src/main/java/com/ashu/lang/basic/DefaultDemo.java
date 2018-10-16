package com.ashu.lang.basic;

public class DefaultDemo {

  interface I {
    void test1();
    default void defaultMethod() {
      System.out.println("I'm a default method.");
    }
  }

  class C implements I {

    @Override
    public void test1() {
      System.out.println("test1 must be implemented");
    }
  }

  class C1 implements I {

    @Override
    public void test1() {

    }

    @Override
    public void defaultMethod() {
      System.out.println("C1's default method");
    }
  }

  public void demo() {
    I i = new C1();
    i.defaultMethod();

    I i2 = new C();
    i2.defaultMethod();
  }

  public static void main(String[] args) {
    new DefaultDemo().demo();
  }
}
