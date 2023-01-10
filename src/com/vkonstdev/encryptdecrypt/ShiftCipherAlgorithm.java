package com.vkonstdev.encryptdecrypt;

public class ShiftCipherAlgorithm implements CipherAlgorithm {

    private static final int LETTERS_COUNT = 26;

    @Override
    public String encrypt(String data, int key) {
        char[] letters = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        char startLetter;
        for (char ch : letters) {
            if (Character.isAlphabetic(ch)) {
                startLetter = (Character.isUpperCase(ch)) ? 'A' : 'a';
                sb.append((char) (startLetter + (ch - startLetter + key) % LETTERS_COUNT));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        char[] letters = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        char endLetter;
        for (char ch : letters) {
            if (Character.isAlphabetic(ch)) {
                endLetter = (Character.isUpperCase(ch)) ? 'Z' : 'z';
                sb.append((char) (endLetter - (endLetter - ch + key) % LETTERS_COUNT));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


}
