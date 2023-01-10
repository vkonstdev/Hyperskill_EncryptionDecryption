package com.vkonstdev.encryptdecrypt;

public class AlgorithmFactory {

    public static CipherAlgorithm chooseCipherAlgorithm(String type) {
        if ("shift".equals(type)) {
            return new ShiftCipherAlgorithm();
        } else if ("unicode".equals(type)) {
            return new UnicodeCipherAlgorithm();
        } else {
            return null;
        }
    }
}
