package org.test.challenge;

import org.challenge.DuplicateRemover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DuplicateRemoverTest {

    @Test
    void execute() {
        Assertions.assertArrayEquals(Constant.DUPLICATE_REMOVER_EXPECTED_OUTPUT, DuplicateRemover.execute(Constant.DUPLICATE_REMOVER_INPUT));
    }
}