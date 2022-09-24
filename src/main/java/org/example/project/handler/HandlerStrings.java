package org.example.project.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HandlerStrings {
    private final static Integer LIMITER = 40;

    public void handle(List<Object> elements) {
        List<String> strings = convertToListStrings(elements);
        switch (strings.get(1)) {
            case "+" -> concat(strings);
            case "-" -> minus(strings);
            default -> {
                System.out.println("Все в говне, давай по новой.");
                throw new NullPointerException();
            }
        }
    }

    private List<String> convertToListStrings(List<Object> elements) {
        return elements.stream().map(String::valueOf).collect(Collectors.toList());
    }

    private void concat(List<String> elements) {
        print(elements.get(0).replaceAll("\"", "") + elements.get(2).replaceAll("\"", ""));
    }

    private void minus(List<String> elements) {
        List<String> firstElement = new ArrayList<>(Arrays.stream(elements.get(0)
                        .replaceAll("\"", "")
                        .split(" "))
                        .toList());
        List<String> secondElement = new ArrayList<>(Arrays.stream(elements.get(2)
                        .replaceAll("\"", "")
                        .split(" "))
                        .toList());
        firstElement.removeAll(secondElement);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : firstElement) {
            if (!s.equals(firstElement.get(firstElement.size() - 1))) {
                stringBuilder.append(s).append(" ");
            } else {
                stringBuilder.append(s);
            }
        }
        print(stringBuilder.toString());
    }

    private void print(String result) {
        if (result.length() > LIMITER) {
            System.out.println("Output: " + "\"" + result.substring(0, LIMITER) + "..." + "\"");
        } else {
            System.out.println("Output: " + "\"" + result + "\"");
        }
    }
}
