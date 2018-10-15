package com.ashu.jvm.gc;

public class FinalizeEscapeGC {

  public static FinalizeEscapeGC HOOK = null;
  public void checkAlive() {
    System.out.println("I'm alive ");
  }

  @Override
  protected void finalize() {
    HOOK = this;
    System.out.println("I can't be killed");
  }

  public static void main(String[] args) throws InterruptedException {
    HOOK = new FinalizeEscapeGC();
    HOOK = null;
    System.gc();

    Thread.sleep(500);
    if (HOOK != null) {
      HOOK.checkAlive();
    }

    HOOK = null;
    System.gc();

    if (HOOK == null) {
      System.out.println("I have been killed");
    }

  }

}
