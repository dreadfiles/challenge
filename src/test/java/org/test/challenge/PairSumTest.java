package org.test.challenge;

import org.challenge.PairSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PairSumTest {

    @Test
    void validatePairSumArray() {
        Assertions.assertEquals(Constant.PAIR_SUM_EXPECTED_OUTPUT, PairSum.validatePairSumArray(Constant.PAIR_SUM_INPUT_ARRAY, Constant.PAIR_SUM_INPUT_VALUE));
    }
}