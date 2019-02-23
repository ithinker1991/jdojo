package com.ashu.jvm.gc;

import java.util.ArrayList;
import java.util.List;

public class FrequentlyFullGC {
    public static int _1M = 1024 * 1024 / 4;
    public static int GARABGE_SIZE = 10;

    private void generateGarabge() {
        byte[] bytesToGC = new byte[_1M];
    }

    private void canBeSwap() {
        for (;;) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            generateGarabge();
        }
    }

    private void cannotSawp() {
        List<byte[]> list = new ArrayList<>();
        for (;;) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            list.add(new byte[_1M / 10]);
            System.err.println(1L * list.size() * _1M / 10);
        }
    }

    public void run() {
        for (int i = 0; i < GARABGE_SIZE; i++) {
            Thread t = new Thread(() -> {
                canBeSwap();
            });
            t.setName("garabge" + i);
            t.start();
        }

        Thread t = new Thread(this::cannotSawp);
        t.setName("trigger");
        t.start();
    }

    public static void main(String[] args) {

//        VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
        new FrequentlyFullGC().run();
    }
}
