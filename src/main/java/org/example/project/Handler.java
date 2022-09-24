package org.example.project;

import org.example.project.handler.HandlerStringAndNumber;
import org.example.project.handler.HandlerStrings;
import org.example.project.parse.ElementsParser;

import java.util.List;

public class Handler {
    private final ElementsParser parser = new ElementsParser();
    private final HandlerStrings handlerStrings = new HandlerStrings();
    private final HandlerStringAndNumber handlerStringAndNumber = new HandlerStringAndNumber();

    public static boolean FLAG = true;

    public void handle(String line) {
        List<Object> elements = getAllElements(line);
        handle(elements);
    }

    private List<Object> getAllElements(String line) {
        return parser.parse(line);
    }

    public void handle(List<Object> elements) {
        if (elements.get(2) instanceof String) {
            handlerStrings.handle(elements);
        } else if (elements.get(2) instanceof Integer) {
            handlerStringAndNumber.handle(elements);
        } else {
            throw new NullPointerException();
        }
    }
}
