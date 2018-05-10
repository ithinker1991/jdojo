package com.ashu.third;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterDemo {

  public static void main(String[] args) {
//    RateLimiter limiter =
    long start = System.currentTimeMillis();

    RateLimiter limiter = RateLimiter.create(10.0);

    for (int i = 0; i < 10; i++) {
      limiter.acquire();
      System.out.println("call execute " + i);
    }

    long end = System.currentTimeMillis();

    System.out.println(end - start);
  }

}
