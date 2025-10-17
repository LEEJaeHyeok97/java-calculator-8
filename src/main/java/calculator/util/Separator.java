package calculator.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public static final String CUSTOM_PATTERN = "^//(.*)\\\\n(.*)$";
    public static final String CUSTOM_UNINPUTTED_PATTERN = "^//\\\\n(.*)$";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_PATTERN);
    public static final Pattern CUSTOM_DELIMITER_UNINPUTTED_PATTERN = Pattern.compile(CUSTOM_UNINPUTTED_PATTERN);
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    public static final int VALUES_GROUP_INDEX = 2;
    public static final String REGEX_OR_OPERATION = "|";
    public static final String MISSING_CUSTOM_DELIMITER_EXCEPTION_MESSAGE = "커스텀 구분자가 입력되지 않았습니다.";
    public static final String NUMBER_DELIMITER_EXCEPTION_MESSAGE = "숫자는 구분자가 될 수 없습니다.";
    public static final String NUMBER_DELIMITER_PATTERN = "^[0-9]+$";

    public static String[] separate(String input) {
        validateMissingCustomDelimiter(input);

        Matcher matcher = getCustomDelimiterMatcher(input);

        if (isMatches(matcher)) {
            String customDelimiter = getCustomDelimiter(matcher);

            return splitByCustomDelimiter(matcher, customDelimiter);
        }

        return splitByDefaultDelimiter(input);
    }

    private static void validateMissingCustomDelimiter(String input) {
        Matcher matcher = getUninputtedCustomDelimiterMatcher(input);
        if (isMatches(matcher)) {
            throw new IllegalArgumentException(MISSING_CUSTOM_DELIMITER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isMatches(Matcher matcher) {
        return matcher.matches();
    }

    private static Matcher getUninputtedCustomDelimiterMatcher(String input) {
        return CUSTOM_DELIMITER_UNINPUTTED_PATTERN.matcher(input);
    }

    private static Matcher getCustomDelimiterMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private static String getCustomDelimiter(Matcher matcher) {
        validateIsNumberDelimiter(matcher);

        return matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
    }

    private static void validateIsNumberDelimiter(Matcher matcher) {
        if (isNumberDelimiter(matcher.group(CUSTOM_DELIMITER_GROUP_INDEX))) {
            throw new IllegalArgumentException(NUMBER_DELIMITER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumberDelimiter(String delimiter) {
        return delimiter.matches(NUMBER_DELIMITER_PATTERN);
    }

    private static String[] splitByCustomDelimiter(Matcher matcher, String customDelimiter) {
        return getValue(matcher).split(DEFAULT_DELIMITER + REGEX_OR_OPERATION + Pattern.quote(customDelimiter));
    }

    private static String getValue(Matcher matcher) {
        return matcher.group(VALUES_GROUP_INDEX);
    }

    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}
