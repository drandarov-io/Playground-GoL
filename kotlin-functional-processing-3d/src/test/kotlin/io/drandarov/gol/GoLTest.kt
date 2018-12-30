package io.drandarov.gol

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GoLTest {

    companion object {
        private val testWorld: World = createWorld(10, 12, 5)
                .flipAt(1, 0, 0)
                .flipAt(2, 1, 0)
                .flipAt(0, 2, 0)
                .flipAt(1, 2, 0)
                .flipAt(2, 2, 0)
                .flipAt(9, 14, 0)
    }

    @Test
    fun neighborCountTest() {
        assertEquals(1, testWorld.neighbourCount(1, 0, 0))
        assertEquals(3, testWorld.neighbourCount(2, 1, 0))
        assertEquals(1, testWorld.neighbourCount(0, 2, 0))
        assertEquals(3, testWorld.neighbourCount(1, 2, 0))
        assertEquals(2, testWorld.neighbourCount(2, 2, 0))
        assertEquals(0, testWorld.neighbourCount(9, 11, 0))
    }

    @Test
    fun isAliveTest() {
        assertTrue(testWorld.isAliveNeighbor(0, 0, 0, 1, 0, 0))
        assertTrue(testWorld.isAliveNeighbor(1, 1, 0, 2, 1, 0))
        assertTrue(testWorld.isAliveNeighbor(1, 1, 0, 1, 2, 0))

        assertFalse(testWorld.isAliveNeighbor(1, 0, 0, 0, -1, 0))
        assertFalse(testWorld.isAliveNeighbor(-100, 5, 0, -101, 6, 0))
    }

    @Test
    fun flipAtTest() {
        assertTrue(testWorld.flipAt(8, 8, 0).isAlive(8, 8, 0))

        assertFalse(testWorld.flipAt(2, 2, 0).isAlive(2, 2, 0))
        assertFalse(testWorld.flipAt(1, 80, 0).isAlive(1, 80, 0))
    }

}

