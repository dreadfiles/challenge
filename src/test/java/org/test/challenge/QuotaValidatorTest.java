package org.test.challenge;

import org.challenge.QuotaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuotaValidatorTest {

    @Test
    void validateList() {
        Assertions.assertEquals(Constant.QUOTA_VALIDATOR_EXPECTED_MAP, QuotaValidator.validateList(Constant.QUOTA_VALIDATOR_INPUT_LIST));
    }

    @Test
    void ShouldBeValidString() {
        Assertions.assertTrue(QuotaValidator.isValidString(Constant.QUOTA_VALIDATOR_VALID_INPUT));
    }

    @Test
    void ShouldNotBeValidString() {
        Assertions.assertFalse(QuotaValidator.isValidString(Constant.QUOTA_VALIDATOR_INVALID_INPUT));
    }
}