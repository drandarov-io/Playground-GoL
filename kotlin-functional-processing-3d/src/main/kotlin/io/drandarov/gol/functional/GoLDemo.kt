package io.drandarov.gol.functional

import processing.core.PApplet


class GoLDemo : PApplet() {

    companion object Factory {
        var world: World = createWorld(10, 15, 3)
        val gap = 2
        val size = 20

        fun run() {
            val art = GoLDemo()
            println("width ${world.width} + height ${world.height} + depth ${world.depth}")
            art.setSize(world.width * (size + gap), world.height * (size + gap))
            art.runSketch()
        }
    }

    override fun setup() {
        noStroke()
        frameRate(30f)

        world = world
                .flipAt(1, 0, 0)
                .flipAt(2, 1, 0)
                .flipAt(0, 2, 0)
                .flipAt(1, 2, 0)
                .flipAt(2, 2, 0)

        println(world.asString())

        drawGoL()
    }

    override fun draw() {
        clear()
        drawGoL()
    }

    override fun keyPressed() {
        if (key.toInt() == CODED && keyCode == RIGHT)
                world = world.step()
    }

    override fun mouseClicked() {
        if (mouseButton == LEFT) {
            world = world.flipAt(mouseX / (size + gap), mouseY / (size + gap), 0)
        }
    }

    private fun drawGoL() {
        background(240f)

        world[0].mapIndexed { y, row ->
            row.mapIndexed { x, cell ->
                fill (if (cell) 50f else 200f)
                rect(x * (size + gap).toFloat(), y * (size + gap).toFloat(), size.toFloat(), size.toFloat())
            } }

//        world.mapIndexed { z, row ->
//            row.mapIndexed { y, col ->
//                col.mapIndexed { x, cell ->
//                fill (if (cell) 50f else 200f)
//                rect(x * (size + gap).toFloat(), y * (size + gap).toFloat(), size.toFloat(), size.toFloat())
//            } } }
    }
}


fun main(args: Array<String>) {
    GoLDemo.run()
}