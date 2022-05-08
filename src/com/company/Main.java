package com.company;

import java.io.IOException;

public class Main {
    static int key = 0;
    static String operation = "enc";
    static String data = "";
    static String outDirectory = null;
    static String alg = "shift";

    public static void main(String[] args) {
        getConfiguration(args);

        EncryptSelectionAlgorithm algorithm = EncryptAlgorithmFactory.select(alg);
        if (algorithm == null) System.out.println("Error: Null");

        SelectionContext selectionContext = new SelectionContext();
        selectionContext.setAlgorithm(algorithm);

        String cypher = selectionContext.getCypher(operation, data, key);

        if (outDirectory == null) {
            System.out.println(cypher);
        } else {
            try {
                FileService.writeToFile(outDirectory, cypher);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void getConfiguration(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-in":
                    try {
                        if (data.length() == 0) data = FileService.readFileAsString(args[i + 1]);
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "-out":
                    outDirectory = args[i + 1];
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
            }
        }
    }
}
