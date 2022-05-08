package com.company;

public class UnicodeEncryptAlgorithm implements EncryptSelectionAlgorithm{
    @Override
    public String encrypt(String data, int seed) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            char encryptChar = (char) (c + seed);
            sb.append(encryptChar);
        }
        return sb.toString();
    }
}
