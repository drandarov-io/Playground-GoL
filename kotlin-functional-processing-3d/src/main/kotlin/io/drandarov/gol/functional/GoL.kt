package io.drandarov.gol.functional

typealias World = List<List<Boolean>>

val cellChar = mapOf(true to "O", false to "·")

public fun createWorld(width: Int, height: Int): World = (0 until width * height).map { false }.chunked(width)
public val World.width get() = this[0].size
public val World.height get() = this.size

fun defaultRule(isAlive: Boolean, neighborCount: Int) = neighborCount in 2..3 && (isAlive || neighborCount != 2)

fun World.isAlive(x: Int, y: Int) = x in 0 until width && y in 0 until height && this[y][x]

fun World.isAliveNeighbor(x: Int, y: Int, i: Int, j: Int) = isAlive(i, j) && !(x == i && y == j)

fun World.neighbourCount(x: Int, y: Int) = (x - 1..x + 1)
        .sumBy { i -> (i to (y - 1..y + 1)).second.filter { j -> isAliveNeighbor(x, y, i, j)  }.count() }

fun World.flipAt(x: Int, y: Int): World =
        this.mapIndexed { j, row ->
            row.mapIndexed { i, cell ->
            if (j == y && i == x) !cell else cell } }

public fun World.step(): World =
        this.mapIndexed { j, row ->
            row.mapIndexed { i, cell ->
            defaultRule(cell, neighbourCount(i, j)) } }

public fun World.asString() =
        this.joinToString("\n") { bools -> bools.joinToString(" ") { cellChar[it]!! } }
