package com.example;

import org.apache.commons.codec.binary.StringUtils;

public class GreetingService {

    public static String greet(String name) {

        if(StringUtils.equals(name, "World")) {
            System.out.println("EQUAL");
        }
        return String.format("Hello %s!", name);
    }

    public static void main(String[] args) {
        System.out.println(greet("World"));
    }
}
