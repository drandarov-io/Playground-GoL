package io.drandarov.gol

typealias World = List<List<Boolean>>

fun World.asString() =
        this.joinToString("\n") {
            it.joinToString(" ") { cellChar[it]!! }
        }

fun World.flipAt(py: Int, px: Int) =
        this.mapIndexed { y, row ->
            row.mapIndexed { x, field ->
                if (y == py && x == px) !field else field
            }
        }

val cellChar = mapOf(true to "X", false to "·")

fun neighbours(world: World, y: Int, x: Int) =
        (y - 1..y + 1).map { j -> Pair(j, (x - 1..x + 1).filter { j != y || it != x }) }

fun main(vararg args: String) {

    val world: World = (0..99).map { false }.chunked(20)

    val a : String? = "a"
    if (a!= null)
        a.length

    println(world
            .flipAt(3, 3)
            .flipAt(1, 7)
            .flipAt(1000, 2132134325)
            .asString())
    println(neighbours(world, 3, 3))
}