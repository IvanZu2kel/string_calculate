package org.example.project.handler;

import java.util.List;

public class HandlerStringAndNumber {
    private final static Integer LIMITER = 40;

    public void handle(List<Object> elements) {
        switch (String.valueOf(elements.get(1))) {
            case "*" -> multiply(elements);
            case "/" -> del(elements);
            default -> {
                System.out.println("Все в говне, давай по новой.");
                throw new NullPointerException();
            }
        }
    }

    private void multiply(List<Object> elements) {
        if (elements.get(0) instanceof String && elements.get(2) instanceof Integer) {
            print(((String) elements.get(0)).replaceAll("\"", "").repeat(Math.max(0, (Integer) elements.get(2))));
        } else {
            throw new NullPointerException();
        }
    }

    private void del(List<Object> elements) {
        if (elements.get(0) instanceof String && elements.get(2) instanceof Integer) {
            String firstElement = String.valueOf(elements.get(0)).replaceAll("\"", "");
            int secondElement = Integer.parseInt(elements.get(2).toString());
            int length = firstElement.split("").length;
            int i = length / secondElement;
            print(firstElement.substring(0, i));
        } else {
            throw new NullPointerException();
        }
    }

    private void print(String result) {
        if (result.length() > LIMITER) {
            System.out.println("Output: " + "\"" + result.substring(0, LIMITER) + "..." + "\"");
        } else {
            System.out.println("Output: " + "\"" + result + "\"");
        }
    }
}
