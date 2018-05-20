package com.ashu.lang.Thread;

public class ThreadDemo {

  synchronized void fun1() {
    System.out.println("fun1 start");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("fun1 end");

  }

  synchronized void fun2() {
    System.out.println("fun2 run");
  }

  public static void main(String[] args) {
    ThreadDemo td = new ThreadDemo();
    new Thread(new Runnable() {
      @Override
      public void run() {
        td.fun1();


      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        td.fun2();
      }
    }).start();
  }



}
