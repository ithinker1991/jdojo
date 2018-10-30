package com.ashu.jvm.oom;

// vm args: -Xss2m
public class JVMStackOOM {
    private void notStop() throws InterruptedException {
        for(;;) {
            Thread.sleep(100);
        }
    }

    public void stackLeakByThread() {
        for (;;) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        notStop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) {
        JVMStackOOM oom = new JVMStackOOM();
        oom.stackLeakByThread();
    }
}
