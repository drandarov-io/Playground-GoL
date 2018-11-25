package io.drandarov.gol.ruleset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultRuleSetTest {

    @Test
    void rule1Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertFalse(defaultRuleSet.isCellAlive(0));
    }

    @Test
    void rule2Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertTrue(defaultRuleSet.isCellAlive(2));
    }

    @Test
    void rule3Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertTrue(defaultRuleSet.isCellAlive(3));
    }

    @Test
    void rule4Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertFalse(defaultRuleSet.isCellAlive(4));
    }

}
