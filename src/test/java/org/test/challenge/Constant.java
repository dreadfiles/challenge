package org.test.challenge;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Constant {
    public static final String PALINDROME_INPUT = " anita Lava la Tina ";
    public static final String NO_PALINDROME_INPUT = " anita Lava la ";
    public static final List<String> INPUT_LIST_PALINDROME = List.of(PALINDROME_INPUT, NO_PALINDROME_INPUT);
    public static final Map<String, Boolean> EXPECTED_MAP_PALINDROME = Map.ofEntries(
            entry(PALINDROME_INPUT, true),
            entry(NO_PALINDROME_INPUT, false)
    );

    public static final Integer POSITIVE_INPUT = 500109071;
    public static final Integer NEGATIVE_INPUT = -500109071;
    public static final Integer POSITIVE_INPUT_EXPECTED = 100001579;
    public static final Integer NEGATIVE_INPUT_EXPECTED = -975110000;
    public static final List<Integer> INPUT_LIST_MAXIMIZER = List.of(POSITIVE_INPUT, NEGATIVE_INPUT);
    public static final Map<Integer, Integer> EXPECTED_MAP_MAXIMIZER = Map.ofEntries(
            entry(POSITIVE_INPUT, POSITIVE_INPUT_EXPECTED),
            entry(NEGATIVE_INPUT, NEGATIVE_INPUT_EXPECTED)
    );

    public static final Integer PRIME_INPUT_TRUE = 31;
    public static final Integer PRIME_INPUT_FALSE = 32;
    public static final List<Integer> PRIME_INPUT_LIST = List.of(PRIME_INPUT_TRUE, PRIME_INPUT_FALSE);
    public static final Map<Integer, Boolean> PRIME_EXPECTED_MAP = Map.ofEntries(
            entry(PRIME_INPUT_TRUE, true),
            entry(PRIME_INPUT_FALSE, false)
    );

    public static final int[] DUPLICATE_REMOVER_INPUT = {0, 0, 0, 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 6, 6, 7, 8, 8, 8};
    public static final int[] DUPLICATE_REMOVER_EXPECTED_OUTPUT = {0, 0, 1, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 8, 8, 0, 0, 0, 0, 0, 0};

    public static final int[] PAIR_SUM_INPUT_ARRAY = {1, 5, 7, 2, 4, 6};
    public static final int PAIR_SUM_INPUT_VALUE = 6;
    public static final int PAIR_SUM_EXPECTED_OUTPUT = 2;

    public static final String QUOTA_VALIDATOR_VALID_INPUT = "{}{}HELLO{[((({})))]}[HI]{()()[(OK)]}";
    public static final String QUOTA_VALIDATOR_INVALID_INPUT = "{}{}HELLO{[((({})){)]}[HI]{()()[(OK)]}";
    public static final List<String> QUOTA_VALIDATOR_INPUT_LIST = List.of(QUOTA_VALIDATOR_VALID_INPUT, QUOTA_VALIDATOR_INVALID_INPUT);
    public static final Map<String, Boolean> QUOTA_VALIDATOR_EXPECTED_MAP = Map.ofEntries(
            entry(QUOTA_VALIDATOR_VALID_INPUT, true),
            entry(QUOTA_VALIDATOR_INVALID_INPUT, false)
    );
}
