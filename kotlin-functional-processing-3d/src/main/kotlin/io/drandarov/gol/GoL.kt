package io.drandarov.gol

typealias World = List<List<List<Boolean>>>

val cellChar = mapOf(true to "O", false to "·")

public fun createWorld(width: Int, height: Int, depth: Int): World = (0 until width * height * depth).map { false }.chunked(width).chunked(height)
public val World.width get() = this[0][0].size
public val World.height get() = this[0].size
public val World.depth get() = this.size

fun defaultRule(isAlive: Boolean, neighborCount: Int) = neighborCount in 4..6 && (neighborCount != 6 || isAlive)

fun World.isAlive(x: Int, y: Int, z: Int) = x in 0 until width && y in 0 until height && z in 0 until depth && this[z][y][x]

fun World.isAliveNeighbor(x: Int, y: Int, z: Int, i: Int, j: Int, k: Int) = isAlive(i, j, k) && !(x == i && y == j && z == k)

fun World.neighbourCount(x: Int, y: Int, z: Int) = (x - 1..x + 1)
        .sumBy { i -> (i to (y - 1..y + 1)).second
                .sumBy { j -> (j to (z - 1..z + 1)).second
                        .filter { k -> isAliveNeighbor(x, y, z, i, j, k)  }.count() } }

fun World.flipAt(x: Int, y: Int, z: Int): World =
        this.mapIndexed { k, row ->
            row.mapIndexed { j, col ->
                col.mapIndexed { i, cell ->
                    if (k == z && j == y && i == x) !cell else cell } } }

public fun World.step(): World =
        this.mapIndexed { k, row ->
            row.mapIndexed { j, col ->
                col.mapIndexed { i, cell ->
                    defaultRule(cell, neighbourCount(i, j, k)) } } }

