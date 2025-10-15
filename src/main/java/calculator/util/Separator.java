package calculator.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*)\\n(.*)$");
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    public static final int VALUES_GROUP_INDEX = 2;
    public static final String REGEX_OR_OPERATION = "|";

    public static String[] separate(String input) {
        Matcher matcher = getMatcher(input);

        if (matcher.matches()) {
            String customDelimiter = getCustomDelimiter(matcher);

            return splitByCustomDelimiter(matcher, customDelimiter);
        }

        return splitByDefaultDelimiter(input);
    }

    private static String[] splitByCustomDelimiter(Matcher matcher, String customDelimiter) {
        return getValue(matcher).split(DEFAULT_DELIMITER + REGEX_OR_OPERATION + Pattern.quote(customDelimiter));
    }

    private static String getValue(Matcher matcher) {
        return matcher.group(VALUES_GROUP_INDEX);
    }

    private static String getCustomDelimiter(Matcher matcher) {
        return matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
    }

    private static Matcher getMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}
