package org.test.challenge;

import org.challenge.Palindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    @Test
    void validateListReverse() {
        Assertions.assertEquals(Constant.EXPECTED_MAP_PALINDROME, Palindrome.validateListReverse(Constant.INPUT_LIST_PALINDROME));
    }

    @Test
    void validateListFor() {
        Assertions.assertEquals(Constant.EXPECTED_MAP_PALINDROME, Palindrome.validateListFor(Constant.INPUT_LIST_PALINDROME));
    }

    @Test
    void shouldBePalindromeReverse() {
        Assertions.assertTrue(Palindrome.isPalindromeReverse(Constant.PALINDROME_INPUT));
    }

    @Test
    void shouldNotBePalindromeReverse() {
        Assertions.assertFalse(Palindrome.isPalindromeReverse(Constant.NO_PALINDROME_INPUT));
    }

    @Test
    void shouldBePalindromeFor() {
        Assertions.assertTrue(Palindrome.isPalindromeFor(Constant.PALINDROME_INPUT));
    }

    @Test
    void shouldNotBePalindromeFor() {
        Assertions.assertFalse(Palindrome.isPalindromeFor(Constant.NO_PALINDROME_INPUT));
    }
}