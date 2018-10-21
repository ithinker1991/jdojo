package com.ashu.crypto;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class SymmetricCryptographyDemo {


}


class NonSymmetricCrytography {

  private static final String PUBLIC_KEY = "publick_key";
  private static final String PRIVATE_KEY = "private_key";

  private String keyAlgorithm;

  private String cipherAlgorithm;

  private int keySize;

  public NonSymmetricCrytography(String keyAlgorithm, String cipherAlgorithm, int keySize) {
    this.keyAlgorithm = keyAlgorithm;
    this.cipherAlgorithm = cipherAlgorithm;
    this.keySize = keySize;
  }

  public byte[] encrypt(byte[] data, Key key)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    Cipher cipher = Cipher.getInstance(this.cipherAlgorithm);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    return cipher.doFinal(data);
  }

  public byte[] decrypt(byte[] data, Key key)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    Cipher cipher = Cipher.getInstance(this.cipherAlgorithm);
    cipher.init(Cipher.DECRYPT_MODE, key);
    return cipher.doFinal(data);
  }



  public PublicKey toPublicKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
    KeyFactory keyFactory = KeyFactory.getInstance(this.keyAlgorithm);
    return keyFactory.generatePublic(x509EncodedKeySpec);
  }

  public PrivateKey toPrivateKey(byte[] key)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
    KeyFactory keyFactory = KeyFactory.getInstance(this.keyAlgorithm);
    return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
  }

  public byte[] encryptByPublicKey(byte[] data, byte[] key)
      throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
    Key k = toPublicKey(key);
    return this.encrypt(data, k);
  }

  public byte[] decryptByPublicKey(byte[] data, byte[] key)
      throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
    Key k = toPublicKey(key);
    return this.decrypt(data, k);
  }




}