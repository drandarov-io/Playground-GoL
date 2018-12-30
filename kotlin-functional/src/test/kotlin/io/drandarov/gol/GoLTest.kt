package io.drandarov.gol

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class GoLTest {

    companion object {
        private val testWorld: World = createWorld(10, 12)
                .flipAt(1, 0)
                .flipAt(2, 1)
                .flipAt(0, 2)
                .flipAt(1, 2)
                .flipAt(2, 2)
                .flipAt(9, 14)

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            println("Test-World\n----------\n${testWorld.asString()}")
        }
    }

    @Test
    fun neighborCountTest() {
        assertEquals(1, testWorld.neighbourCount(1, 0))
        assertEquals(3, testWorld.neighbourCount(2, 1))
        assertEquals(1, testWorld.neighbourCount(0, 2))
        assertEquals(3, testWorld.neighbourCount(1, 2))
        assertEquals(2, testWorld.neighbourCount(2, 2))
        assertEquals(0, testWorld.neighbourCount(9, 11))
    }

    @Test
    fun isAliveTest() {
        assertTrue(testWorld.isAliveNeighbor(0, 0, 1, 0))
        assertTrue(testWorld.isAliveNeighbor(1, 1, 2, 1))
        assertTrue(testWorld.isAliveNeighbor(1, 1, 1, 2))

        assertFalse(testWorld.isAliveNeighbor(1, 0, 0, -1))
        assertFalse(testWorld.isAliveNeighbor(-100, 5, -101, 6))
    }

    @Test
    fun flipAtTest() {
        assertTrue(testWorld.flipAt(8, 8).isAlive(8, 8))

        assertFalse(testWorld.flipAt(2, 2).isAlive(2, 2))
        assertFalse(testWorld.flipAt(1, 80).isAlive(1, 80))
    }

}

