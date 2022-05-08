package com.company;

public class EncryptAlgorithmFactory {
    public static EncryptSelectionAlgorithm select(String type) {
        switch (type){
            case "shift":
                return new ShiftEncryptAlgorithm();
            case "unicode":
                return new UnicodeEncryptAlgorithm();
            default:
                return null;
        }
    }
}
