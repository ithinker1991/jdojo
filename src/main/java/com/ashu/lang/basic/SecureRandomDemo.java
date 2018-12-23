package com.ashu.lang.basic;

import java.security.SecureRandom;

public class SecureRandomDemo {


    public static void main(String[] args) {
        SecureRandom generater = new SecureRandom();
        for (int i = 0; i < 10; i++)
            System.out.println(generater.nextInt(37));
    }
}
