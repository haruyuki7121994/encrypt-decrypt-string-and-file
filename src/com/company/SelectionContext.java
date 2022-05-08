package com.company;

public class SelectionContext {
    private EncryptSelectionAlgorithm algorithm;

    public void setAlgorithm(EncryptSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getCypher(String operation, String data, int seed) {
        if (operation.equals("dec")) seed = -seed;
        return algorithm.encrypt(data, seed);
    }
}
