package io.drandarov.gol.functional

import processing.core.PApplet


class GoLDemo : PApplet() {

    companion object Factory {
        var world: World = createWorld(10, 15, 3)
        val gap = 2
        val size = 20
        val art = GoLDemo()

        fun run() {
            println("width ${world.width} + height ${world.height} + depth ${world.depth}")
            art.setSize(world.width * (size + gap) * world.depth, world.height * (size + gap))
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

        world[1].mapIndexed { y, row ->
            row.mapIndexed { x, cell ->
                fill (if (cell) 50f else 200f)
                rect(10 + x * (size + gap).toFloat() + (art.width) / 3 * 1, y * (size + gap).toFloat(), size.toFloat(), size.toFloat())
            } }


        world[2].mapIndexed { y, row ->
            row.mapIndexed { x, cell ->
                fill (if (cell) 50f else 200f)
                rect(20 + x * (size + gap).toFloat() + (art.width) / 3 * 2, y * (size + gap).toFloat(), size.toFloat(), size.toFloat())
            } }
    }
}


fun main(args: Array<String>) {
    GoLDemo.run()
}