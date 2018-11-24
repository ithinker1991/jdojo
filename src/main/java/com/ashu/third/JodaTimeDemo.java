package com.ashu.third;

import org.joda.time.DateTime;

public class JodaTimeDemo {

  public static void main(String[] args) {

    new Thread(new Timer()).start();
  }

  public static class Timer implements Runnable {

    @Override
    public void run() {
      int BLOCK_PRODUCED_INTERVAL = 5000;
      int i = 0;
      while(i++ < 1000) {
        long sleep = (long) (Math.random() * 1000);
        System.out.println("sleep :" + sleep);
        try {
          Thread.sleep(sleep);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("-----------");

        DateTime time = DateTime.now();
        long timeToNextSecond = BLOCK_PRODUCED_INTERVAL
            - (time.getSecondOfMinute() * 1000 + time.getMillisOfSecond())
            % BLOCK_PRODUCED_INTERVAL;

        System.out.println("getSecondOfMinute " + time.getSecondOfMinute() * 1000);
        System.out.println("getMillisOfSecond " + time.getMillisOfSecond());
        System.out.println("timeToNextSecond " + timeToNextSecond);
        System.out.println("time " + time);
        System.out.println("+++++++++++++++++++++++");
        if (timeToNextSecond < 50L) {
          timeToNextSecond = timeToNextSecond + BLOCK_PRODUCED_INTERVAL;
        }

        System.out.println("getSecondOfMinute " + time.getSecondOfMinute() * 1000);
        System.out.println("getMillisOfSecond " + time.getMillisOfSecond());
        System.out.println("timeToNextSecond " + timeToNextSecond);
        System.out.println("time " + time);
        System.out.println("getMillis " + time.getMillis());
      }
    }
  }

}
