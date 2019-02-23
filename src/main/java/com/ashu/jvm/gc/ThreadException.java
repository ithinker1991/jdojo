package com.ashu.jvm.gc;

public class ThreadException {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
//          throw new IllegalArgumentException();
          System.out.println("Child alive:" + Thread.currentThread().getId());
        }
      });
      t.start();
      t.setName("");
    }

              throw new IllegalArgumentException();

//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    System.out.println("I'm alive");
  }

}
