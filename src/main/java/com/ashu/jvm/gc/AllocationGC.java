package com.ashu.jvm.gc;

// VM Args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
public class AllocationGC {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {

        byte[] byteArray1, byteArray2, byteArray3, byteArray4;
        byteArray1 = new byte[2 * _1MB];
        byteArray2 = new byte[2 * _1MB];
        byteArray3 = new byte[1 * _1MB];
//        System.out.println(9 * _1MB - 5 * _1MB);
        byteArray4 = new byte[1  * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
