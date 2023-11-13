package christmas.common.util;

import christmas.common.enumerator.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {
    private static final Pattern REGEX_BLANK = Pattern.compile("\\s");
    private static final String DIGIT_COMMA = ",";
    private static final String DIGIT_HYPHEN = "-";
    private static final String DIGIT_NONE = "";

    public static Map<String, Integer> separateStringWithCommaAndHyphen(String input) {
        return Arrays
                .stream(removeSpaceAll(input).split(DIGIT_COMMA))
                .map(entry -> entry.split(DIGIT_HYPHEN))
                .collect(Collectors.toMap(parts -> parts[0],
                        parts -> convertStringToInt(parts[1])));
    }

    public static int convertStringToInt(String input) {
        try {
            int convert = Integer.parseInt(input);
            return convert;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public static String removeSpaceAll(String numbers) {
        return numbers.replaceAll(String.valueOf(REGEX_BLANK), DIGIT_NONE);
    }
}
