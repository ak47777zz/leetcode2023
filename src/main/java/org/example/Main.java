package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "123    456";
        String[] s1 = s.split(" ");
        for (String string : s1) {
            if (string.isEmpty()) {
                continue;
            }
            System.out.println(string);
        }
    }
}