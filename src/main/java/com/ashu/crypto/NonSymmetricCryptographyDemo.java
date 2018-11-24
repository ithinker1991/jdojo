package com.ashu.crypto;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;

public class NonSymmetricCryptographyDemo {


}


class NonSymmetricCryptography {

  private static final String PUBLIC_KEY = "public_key";
  private static final String PRIVATE_KEY = "private_key";

  private String keyAlgorithm;

  private String cipherAlgorithm;

  private int keySize;

  public NonSymmetricCryptography(String keyAlgorithm, String cipherAlgorithm, int keySize) {
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

  public byte[] encryptByPrivateKey(byte[] data, byte[] key)
      throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
    Key k = toPrivateKey(key);
    return this.encrypt(data, k);
  }

  public byte[] decryptByPrivateKey(byte[] data, byte[] key)
      throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
    Key k = toPrivateKey(key);
    return this.decrypt(data, k);
  }

  public Map<String, Key> initKey() throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(this.keyAlgorithm);
    keyPairGenerator.initialize(this.keySize);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    PrivateKey privateKey = keyPair.getPrivate();
    PublicKey publicKey = keyPair.getPublic();
    Map<String, Key> keyMap = new HashMap<>();
    keyMap.put(PRIVATE_KEY, privateKey);
    keyMap.put(PUBLIC_KEY, publicKey);
    return keyMap;
  }

  public byte[] getPrivateKey(Map<String, Key> keyMap) {
    return keyMap.get(PRIVATE_KEY).getEncoded();
  }

  public byte[] getPublicKey(Map<String, Key> keyMap) {
    return keyMap.get(PUBLIC_KEY).getEncoded();
  }



  public static void main(String[] args)
      throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchPaddingException {
    NonSymmetricCryptography nonSymmetricCryptography = new NonSymmetricCryptography("RSA", "RSA/ECB/PKCS1Padding", 512);
    byte[] data = "My Data to Crypt".getBytes();
    Map<String, Key> keyMap = nonSymmetricCryptography.initKey();
    System.out.println("公钥：" + Base64.encodeBase64String(nonSymmetricCryptography.getPublicKey(keyMap)));
    System.out.println("私钥：" + Base64.encodeBase64String(nonSymmetricCryptography.getPrivateKey(keyMap)));

// 公钥加密私钥解密
    String encryptData = Base64.encodeBase64String(nonSymmetricCryptography.encryptByPublicKey(data, nonSymmetricCryptography.getPublicKey(keyMap)));
    System.out.println("使用公钥加密后数据：" + encryptData);
    String decryptData = new String(nonSymmetricCryptography.decryptByPrivateKey(Base64.decodeBase64(encryptData), nonSymmetricCryptography.getPrivateKey(keyMap)));
    System.out.println("使用私钥解密后数据：" + decryptData);

    // 私钥加密公钥解密
    String encryptData1 = Base64.encodeBase64String(nonSymmetricCryptography.encryptByPrivateKey(data, nonSymmetricCryptography.getPrivateKey(keyMap)));
    System.out.println("使用私钥加密后数据：" + encryptData1);
    String decryptData1 = new String(nonSymmetricCryptography.decryptByPublicKey(Base64.decodeBase64(encryptData1), nonSymmetricCryptography.getPublicKey(keyMap)));
    System.out.println("使用公钥解密后数据：" + decryptData1);
  }
}






