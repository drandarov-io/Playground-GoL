package io.drandarov.gol.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultRuleSetTest {

    @Test
    void rule1Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertFalse(defaultRuleSet.isCellAlive(true, 0));
        assertFalse(defaultRuleSet.isCellAlive(false, 0));

        assertFalse(defaultRuleSet.isCellAlive(true, 1));
        assertFalse(defaultRuleSet.isCellAlive(false, 1));
    }

    @Test
    void rule2Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertTrue(defaultRuleSet.isCellAlive(true, 2));
        assertFalse(defaultRuleSet.isCellAlive(false, 2));
    }

    @Test
    void rule3Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertTrue(defaultRuleSet.isCellAlive(true, 3));
        assertTrue(defaultRuleSet.isCellAlive(false, 3));
    }

    @Test
    void rule4Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertFalse(defaultRuleSet.isCellAlive(true, 4));
        assertFalse(defaultRuleSet.isCellAlive(false, 4));
    }

}
