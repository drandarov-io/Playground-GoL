package io.drandarov.gol.functional

import processing.core.PApplet


class GoLDemo : PApplet() {

    companion object Factory {
        var world: World = createWorld(10, 15, 3)
        val gap = 2f
        val sliceGap = 10f
        val size = 20f
        val size3DScene = 750f

        var size3D = 20f
        var gap3D = 0f
        var rotation = 0f

        fun run() = GoLDemo().runSketch()
    }

    override fun settings() {
        println("width ${world.width} + height ${world.height} + depth ${world.depth}")

        size (
                (world.width * (size + gap) * world.depth + sliceGap * (world.depth - 1)).toInt(),
                (world.height * (size + gap) + size3DScene).toInt(),
                P3D)
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
        if (key == 'd')
            rotation += PI / 8
        if (key == 'a')
            rotation -= PI / 8
        if (key == 'w')
            size3D += 2f
        if (key == 's')
            size3D -= 2f
        if (key == 'e')
            gap3D += 2f
        if (key == 'q')
            gap3D = max(0f, gap3D - 2f)
    }

    override fun mouseClicked() {
        if (mouseButton == LEFT) {
            val z = mouseX / (width / world.depth)
            val y = ((mouseY - size3DScene) / (size + gap)).toInt()
            val x = ((mouseX - ((width + sliceGap * z) / world.depth * z)) / (size + gap)).toInt()

            println("clicked x=$x, y=$y, z=$z")
            world = world.flipAt(x, y, z)
        }
    }

    private fun drawGoL() {
        val sliceWidth = (width / world.depth).toFloat()

        background(240f)

        // Cube
        pushMatrix()
        translate(sliceWidth * 1.5f, size3DScene / 4f, 0f)
        rotateY(rotation)
        world.forEachIndexed { z, slice ->
            slice.forEachIndexed { y, row ->
                row.forEachIndexed { x, cell ->
                    pushMatrix()
                    translate(
                            x * (size3D + gap3D) - (sliceWidth * (.5f / (size / size3D))),
                            y * (size3D + gap3D),
                            -z * (size3D + gap3D))
                    if (cell) fill(40f, 255f - 50f * (z)) else noFill() //fill(200f, 50f)
                    stroke(120f, 80f)

                    box(size3D, size3D, size3D)
                    popMatrix()
                } }
        }
        popMatrix()

        // Slices
        world.forEachIndexed { z, slice ->
            slice.forEachIndexed { y, row ->
                row.forEachIndexed { x, cell ->
                    fill (if (cell) 40f else 230f)
                    stroke(120f)

                    rect(
                            // width ersetzen mit slicesize * 3
                            x * (size + gap) + (width - sliceGap * (world.depth - 1)) / 3 * z + z * sliceGap,
                            y * (size + gap) + size3DScene,
                            size,
                            size)
                } }
        }
    }
}


fun main(args: Array<String>) {
    GoLDemo.run()
}