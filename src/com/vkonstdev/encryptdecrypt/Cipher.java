package com.vkonstdev.encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {

    private CipherAlgorithm algorithm;
    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String in = null;
    private String out = null;
    private String alg = "shift";
    private String outString;

    private void setAlgorithm(CipherAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    private String encrypt(String data, int key) {
        return algorithm.encrypt(data, key);
    }

    private String decrypt(String data, int key) {
        return algorithm.decrypt(data, key);
    }

    public void run(String[] args) {
        parseData(args);
        read();
        crypt();
        write();
    }

    private void parseData(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode" -> mode = args[i + 1];
                case "-key" -> key = Integer.parseInt(args[i + 1]);
                case "-data" -> data = args[i + 1];
                case "-in" -> in = args[i + 1];
                case "-out" -> out = args[i + 1];
                case "-alg" -> alg = args[i + 1];
            }
        }
    }

    private void read() {
        if ("".equals(data) && in != null) {
            StringBuilder sb = new StringBuilder();
            try (Scanner sc = new Scanner(new File(in))) {
                while (sc.hasNext()) {
                    sb.append(sc.nextLine());
                }
                data = sb.toString();
            } catch (FileNotFoundException ex) {
                System.out.println("No file found: " + in);
            }
        }
    }

    private void crypt() {
        setAlgorithm(AlgorithmFactory.chooseCipherAlgorithm(alg));
        if ("enc".equals(mode)) {
            outString = encrypt(data, key);
        } else {
            outString = decrypt(data, key);
        }
    }

    private void write() {
        if (out == null) {
            System.out.println(outString);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(outString);
            } catch (IOException ex) {
                System.out.printf("An exception occurs %s", ex.getMessage());
            }
        }
    }
}
