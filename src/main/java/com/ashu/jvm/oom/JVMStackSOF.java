package com.ashu.jvm.oom;

// vm args: -Xss160k
public class JVMStackSOF {

    private int stackDepth = 0;
    private void stackLeak() {
        stackDepth++;
        stackLeak();
    }
    public static void main(String[] args) {
        JVMStackSOF demo = new JVMStackSOF();
        try {
            demo.stackLeak();
        } catch (StackOverflowError e) {
            System.out.println("current stack depth:" + demo.stackDepth);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("program can continue");
        }

    }
}
