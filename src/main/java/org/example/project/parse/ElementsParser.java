package org.example.project.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementsParser {
    private final static Pattern LEGAL_LINE = Pattern.compile("(\".*\")([*\\-+/\s])(.*)");
    private final static Pattern NUMBER = Pattern.compile("\\d*");

    public List<Object> parse(String line) {

        return new ArrayList<>() {{
            add(getFirstElement(line));
            add(getSecondElement(line));
            add(getThirdElement(line));
        }};
    }

    private String getFirstElement(String line) {
        Matcher matcher = LEGAL_LINE.matcher(line);
        if (matcher.matches()) {
            if (matcher.groupCount() == 3) {
                String group = matcher.group(1);
                if (group.replaceAll("\"", "").length() <= 10) {
                    return group;
                } else {
                    throw new NullPointerException();
                }
            }
        }
        throw new NullPointerException();
    }

    private String getSecondElement(String line) {
        Matcher matcher = LEGAL_LINE.matcher(line.replaceAll(" ", ""));
        if (matcher.matches()) {
            if (matcher.groupCount() == 3) {
                return matcher.group(2);
            }
        }
        throw new NullPointerException();
    }

    private Object getThirdElement(String line) {
        Matcher matcher = LEGAL_LINE.matcher(line);
        if (matcher.matches()) {
            if (matcher.groupCount() == 3) {
                String thirdElement = matcher.group(3).substring(2);
                if (NUMBER.matcher(thirdElement).matches()) {
                    int number = Integer.parseInt(thirdElement);
                    if (number > 0 && number <= 10) {
                        return number;
                    } else {
                        throw new ArithmeticException();
                    }

                } else {
                    if (thirdElement.replaceAll("\"", "").length() <= 10) {
                        return thirdElement;
                    } else {
                        throw new NullPointerException();
                    }
                }
            }
        }
        throw new NullPointerException();
    }
}
