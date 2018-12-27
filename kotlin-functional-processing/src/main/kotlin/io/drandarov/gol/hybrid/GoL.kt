package io.drandarov.gol.hybrid

typealias World = List<List<Cell>>
typealias Cell = Map<Pair<Int, Int>, Boolean>


val cellChar = mapOf(true to "X", false to "·")


//fun createWorld(width: Int, height: Int): World = (0 until width * height).map {i -> mapOf() }.chunked(width)
//
//
//fun World.asString() =
//        this.joinToString("\n") { bools ->
//            bools.joinToString(" ") { cellChar[it]!! } }
//
//
//fun World.flipAt(x: Int, y: Int) =
//        this.mapIndexed { i, row ->
//            row.mapIndexed { j, field ->
//                if (j == x && i == y) !field else field } }
//
//
//fun World.isAliveNeighbor(x: Int, y: Int, i: Int, j: Int) = y in 0..this.size && x in 0..this[0].size && this[y][x] && !(i == x && j == y)
//
//
//fun World.neighbourCount(x: Int, y: Int) = (x - 1..x + 1)
//        .sumBy { j -> (j to (y - 1..y + 1)).second.filter { i -> isAliveNeighbor(x, y, i, j) }.count() }
//
//
//fun main(vararg args: String) {
//    val width = 10
//    val height = 10
//    val world: World = createWorld(width, height)
//            .flipAt(1, 4)
//            .flipAt(1, 5)
//            .flipAt(2, 5)
//            .flipAt(3, 1)
//            .flipAt(3, 3)
//            .flipAt(3, 5)
//            .flipAt(4, 4)
//
//    println(world.asString())
//}