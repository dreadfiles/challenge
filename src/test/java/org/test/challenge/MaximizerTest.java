package org.test.challenge;

import org.challenge.Maximizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximizerTest {

    @Test
    void validateList() {
        Assertions.assertEquals(Constant.EXPECTED_MAP_MAXIMIZER, Maximizer.validateList(Constant.INPUT_LIST_MAXIMIZER));
    }

    @Test
    void maximizeNumberPositiveInput() {
        Integer result = Maximizer.maximizeNumber(Constant.POSITIVE_INPUT);
        Assertions.assertEquals(Constant.POSITIVE_INPUT_EXPECTED, result);
    }

    @Test
    void maximizeNumberNegativeInput() {
        Integer result = Maximizer.maximizeNumber(Constant.NEGATIVE_INPUT);
        Assertions.assertEquals(Constant.NEGATIVE_INPUT_EXPECTED, result);
    }
}