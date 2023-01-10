package com.vkonstdev.encryptdecrypt;

public interface CipherAlgorithm {

    String encrypt(String data, int key);
    String decrypt(String data, int key);
}
