package com.amadeus.cmath;

public enum InputType {
    FILE_INPUT("from a file"),
    CMD_INPUT("from the command line"),
    RANDOM_COEFFICIENT("filling randomise coefficients");

    InputType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
