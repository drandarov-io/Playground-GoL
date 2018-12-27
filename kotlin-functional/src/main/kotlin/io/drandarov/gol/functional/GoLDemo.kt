package io.drandarov.gol.functional

fun main(args: Array<String>) {
    var world: World = createWorld(10, 15)
            .flipAt(1, 0)
            .flipAt(2, 1)
            .flipAt(0, 2)
            .flipAt(1, 2)
            .flipAt(2, 2)
    println("${world.asString()}\n")

    for (i in 0..40) {
        Thread.sleep(75)
        world = world.step()
        println("${world.asString()}\n")
    }
}