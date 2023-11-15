package christmas.common.util;

import christmas.common.enumerator.ExceptionMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {
    private static final Pattern REGEX_BLANK = Pattern.compile("\\s");
    private static final String DIGIT_COMMA = ",";
    private static final String DIGIT_HYPHEN = "-";
    private static final String DIGIT_NONE = "";

    public static Map<String, Integer> separateStringWithCommaAndHyphen(String input) {
        try {
            return Arrays
                    .stream(removeSpaceAll(input).split(DIGIT_COMMA))
                    .map(entry -> entry.split(DIGIT_HYPHEN))
                    .collect(Collectors.toMap(parts -> parts[0],
                            parts -> Integer.parseInt(parts[1])));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | IllegalStateException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static String removeSpaceAll(String numbers) {
        return numbers.replaceAll(String.valueOf(REGEX_BLANK), DIGIT_NONE);
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DAY_FORMAT.getMessage());
        }
    }
}
