package com.hrydziushka.task1.util;

public class IdGenerator {
    private static int counter = 0;

    private IdGenerator() {
    }

    public static int generateCustomArrayId() {
        return ++counter;
    }
}
