package org.text;

public class Paint {
    public static String cyan(String text) {
        return "\u001B[36m" + text + "\u001B[0m";
    }
}
