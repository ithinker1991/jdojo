package com.ashu.crypto;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.text.DateFormatSymbols;

public class ECKeyDemo {


    static class ECKey {
        static {
            Security.addProvider(new org.spongycastle.jce.provider.BouncyCastleProvider());
        }



    }

    static {
        Security.addProvider(new org.spongycastle.jce.provider.BouncyCastleProvider());
    }


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC",
                "SC");
        keyPairGenerator.initialize(256, new SecureRandom());

        KeyPair kp = keyPairGenerator.generateKeyPair();

        ECPublicKey publicKey = (ECPublicKey) kp.getPublic();
        ECPrivateKey privateKey = (ECPrivateKey) kp.getPrivate();

        System.out.println(kp.getPrivate());
        System.out.println(kp.getPublic());

        Cipher encrypter = Cipher.getInstance("ECIES", "SC");
        Cipher decrypter = Cipher.getInstance("ECIES", "SC");

    }
}
