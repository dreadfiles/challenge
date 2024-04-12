package org.test.challenge;

import org.challenge.Prime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeTest {

    @Test
    void validateList() {
        Assertions.assertEquals(Constant.PRIME_EXPECTED_MAP, Prime.validateList(Constant.PRIME_INPUT_LIST));
    }

    @Test
    void shouldBePrime() {
        Assertions.assertTrue(Prime.isPrime(Constant.PRIME_INPUT_TRUE));
    }

    @Test
    void shouldNotBePrime() {
        Assertions.assertFalse(Prime.isPrime(Constant.PRIME_INPUT_FALSE));
    }
}