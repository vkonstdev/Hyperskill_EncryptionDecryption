package com.vkonstdev.encryptdecrypt;

public class UnicodeCipherAlgorithm implements CipherAlgorithm {

    @Override
    public String encrypt(String data, int key) {
        char[] letters = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : letters) {
            ch = (char) (ch + key);
            sb.append(ch);
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        char[] letters = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : letters) {
            ch = (char) (ch - key);
            sb.append(ch);
        }
        return sb.toString();
    }
}
