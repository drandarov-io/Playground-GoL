package io.drandarov.gol.ruleset

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

internal class DefaultRuleSetTest {

    @Test
    fun rule1Test() {
        val defaultRuleSet = DefaultRuleSet()
        assertFalse(defaultRuleSet.isCellAlive(true, 0))
        assertFalse(defaultRuleSet.isCellAlive(false, 0))

        assertFalse(defaultRuleSet.isCellAlive(true, 1))
        assertFalse(defaultRuleSet.isCellAlive(false, 1))
    }

    @Test
    fun rule2Test() {
        val defaultRuleSet = DefaultRuleSet()
        assertTrue(defaultRuleSet.isCellAlive(true, 2))
        assertFalse(defaultRuleSet.isCellAlive(false, 2))
    }

    @Test
    fun rule3Test() {
        val defaultRuleSet = DefaultRuleSet()
        assertTrue(defaultRuleSet.isCellAlive(true, 3))
        assertTrue(defaultRuleSet.isCellAlive(false, 3))
    }

    @Test
    fun rule4Test() {
        val defaultRuleSet = DefaultRuleSet()
        assertFalse(defaultRuleSet.isCellAlive(true, 4))
        assertFalse(defaultRuleSet.isCellAlive(false, 4))
    }

}
