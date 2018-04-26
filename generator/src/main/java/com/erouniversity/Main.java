package com.erouniversity;

import java.io.IOException;

public class Main {
    private static Parameters parameters = new Parameters();

    public static void main(String[] args) throws IOException {
        if (checkParameters(args))
            new Creator(parameters).create();
    }

    private static boolean checkParameters(String[] args) {
        return args.length > 0 && MainParameters.setParameters(parameters, args);
    }
}
