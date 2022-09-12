package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list = new ArrayList<>();

        String[] result = Pattern.compile(String.valueOf(delimiters))
                .splitAsStream(source)
                .toArray(String[]::new);

        for (String elem : result) {
            if (elem != null && !elem.equals("")) {
                list.add(elem);
            }
        }

        return list;
    }
}
