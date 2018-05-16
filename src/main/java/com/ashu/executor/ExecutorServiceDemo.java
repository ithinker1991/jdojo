package com.ashu.executor;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import sun.jvm.hotspot.debugger.ThreadAccess;

public class ExecutorServiceDemo {

  public static void main(String[] args) throws InterruptedException {

////    testBasic();
//
//    ThreadPoolExecutor te = null;
//
//
    testCallable();
//    testPool();

  }

  static void testCallable() throws InterruptedException {

//    ExecutorService service = Executors.newCachedThreadPool();
    ExecutorService service = Executors.newFixedThreadPool(10);
    List<Future<Boolean>> resultList = new LinkedList<>();

    for (int i = 0; i < 10; i++) {
      Future<Boolean> future = service.submit((new TestCallable(i)));
      resultList.add(future);
    }

    while(!resultList.isEmpty()) {

      for (Iterator<Future<Boolean>> iter = resultList.iterator(); iter.hasNext(); ) {

        Future<Boolean> future = iter.next();
        if (future.isDone()) {
          try {
            System.out.println(future + " done" + future.get());
//            System.out.println("recive a exception: " + e.getMessage());
          }  catch (InterruptedException e) {
            e.printStackTrace();
          } catch (ExecutionException e) {

//            Throwable errorCode = e.getCause();
//
            System.err.println("----------------------");
//
//            System.err.println(errorCode);
//            System.err.println(e.getMessage());
//            System.err.println(e.getClass());
//            System.err.println(e);
//
            String msg = e.getMessage();

            System.err.println("msg:" + msg);


            try {
              if (e.getCause() instanceof IllegalArgumentException) {
                throw new IllegalArgumentException(e.getMessage());
              }

              if (e.getCause() instanceof NullPointerException) {
                throw new NullPointerException(e.getMessage());
              }
            } catch (IllegalArgumentException e1) {
              System.err.println("catch real exception:" + e1.getMessage());

            } catch (NullPointerException e1) {
              System.err.println("catch real exception:" + e1.getMessage());
            }

            System.err.println("+++++++++++");
//            e.printStackTrace();
            System.err.println("recive a exception: " + e.getMessage());

            e.printStackTrace();
          } finally {
            iter.remove();
          }
        } else {
          System.out.println(future + " not done");
        }
      }
      Thread.sleep(1000);
    }



//    for (Future<Boolean> future : resultList) {
//      try {
//        while (!future.isDone())
//          ;
//
//        System.out.println(future.get());
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      } catch (ExecutionException e) {
//        System.out.println("recive a exception: " + e.getMessage());
//
////        service.shutdown();
//      }
//
//
//    }

    service.shutdown();
  }

  static class TestCallable implements Callable<Boolean> {

    private int i;

    public TestCallable(int i) {
      this.i = i;
    }

    @Override
    public Boolean call() throws IllegalArgumentException, NullPointerException {
      long sleep = 0;
      try {
        sleep = (long) (1000 * Math.random());
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("I'm executing job:" + i + " sleep:" + sleep);
      System.out.println(Thread.currentThread().getName() + " run");

      if (i % 3 == 0) {
        throw new NullPointerException("3 msg");
      }

      if (i == 4) {
        throw new IllegalArgumentException("4 msg");
      }

      return i % 2 == 0;
    }
  }



  static void testBasic() {
    ExecutorService service = Executors.newCachedThreadPool();

    for (int i = 1; i < 4; i++) {
      service.execute(new TestRunnable(i));
    }

    service.shutdown();

  }

  static class TestRunnable implements Runnable {
    int job;
    public TestRunnable(int job) {
      this.job = job;
    }

    @Override
    public void run() {
      long sleep = 0;
      try {
        sleep = (long) (1000 * Math.random());
        Thread.sleep(sleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("I'm executing job:" + job + " sleep:" + sleep);
      System.out.println(Thread.currentThread().getName() + " run");
    }
  }

  static class TimeRunable implements Runnable {

    String job;
    CountDownLatch countDownLatch;

    public TimeRunable(String job, CountDownLatch countDownLatch) {
      this.job = job;
      this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
      long sleepTime = (long) (100000 * Math.random());
      try {
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " sleep " + sleepTime + "; job:" + job);
        Thread.sleep(sleepTime);
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " sleep end" + "; job:" + job);
        countDownLatch.countDown();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }


  static void testPool() throws InterruptedException {

    CountDownLatch countDownLatch = new CountDownLatch(14);
    ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "valid-sign-");
      }
    });

    for (int i = 0; i < 15; i++) {
      service.submit(new TimeRunable("batch 1." + i, countDownLatch));
    }

    countDownLatch.await();
    System.out.println("all job is down");
    System.out.println("+++++++++++++++");

    countDownLatch = new CountDownLatch(14);

    for (int i = 0; i < 15; i++) {
      service.submit(new TimeRunable("batch 2." + i, countDownLatch));
    }
    service.shutdown();
  }
}
