package com.amadeus.cmath;

public enum InputType {

    FILE_INPUT("from a file"),
    CMD_INPUT("from the command line"),
    RANDOM_COEFFICIENT("filling randomise coefficients");

    private String name;

    InputType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
