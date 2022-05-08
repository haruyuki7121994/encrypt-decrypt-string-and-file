package com.company;

import java.util.List;

public class ShiftEncryptAlgorithm implements EncryptSelectionAlgorithm{
    private final List<Character> lowercaseAlphabet = List.of(
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    );

    private final List<Character> uppercaseAlphabet = List.of(
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    );

    @Override
    public String encrypt(String data, int seed) {
        char[] chars = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        int alphabetLen = 26;
        for (char c : chars) {
            char encryptChar = c;
            List<Character> alphabet = Character.isUpperCase(c) ? uppercaseAlphabet : lowercaseAlphabet;
            int idx = alphabet.indexOf(c);
            if (idx != -1) {
                int encryptIdx = (idx + seed) % alphabetLen;
                encryptChar = alphabet.get(encryptIdx >= 0 ? encryptIdx : alphabetLen + encryptIdx);
            }
            sb.append(encryptChar);
        }
        return sb.toString();
    }
}
