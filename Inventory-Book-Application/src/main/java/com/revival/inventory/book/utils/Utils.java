package com.revival.inventory.book.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Utils {

    public static String COMMA_DELIMITER = ",";
    public static String EMPTY_STRING = "";

    public String getCommaSeparatedString(List<String> values) {
        if (values == null || values.isEmpty()) {
            return EMPTY_STRING;
        }
        return values.stream()
                .collect(Collectors.joining(COMMA_DELIMITER));
    }
}
