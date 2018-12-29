package io.drandarov.gol.functional

import processing.core.PApplet


class GoLDemo : PApplet() {

    // TODO Implement new ruleset -> either all < 3 distance || that fancy Dewdney one
    // TODO Improve camera
    // TODO Fix maximized mouse click detection

    companion object Factory {
        var world: World = createWorld(10, 15, 4)

        val viewSize = 750f
        val gap = 2f
        val size = 20f
        val sliceGap = 10f
        val sliceWidth = world.width * (size + gap) + sliceGap
        var sliceWidthSum = sliceWidth * world.depth - sliceGap
        val sliceHeightSum = world.height * (size + gap)

        var size3D = 20f
        var gap3D = 0f
        var rotation = 0f

        fun run() = GoLDemo().runSketch()
    }

    override fun settings() {
        println("width ${world.width} + height ${world.height} + depth ${world.depth}")
        size (sliceWidthSum.toInt(), (viewSize + sliceHeightSum).toInt(), P3D)
    }

    override fun setup() {
        frameRate(24f)

        surface.setResizable(true)

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
            val z = ((mouseX + sliceGap) / sliceWidth).toInt()
            val y = ((mouseY - (height - sliceHeightSum)) / (size + gap)).toInt()
            val x = ((mouseX - (sliceWidth * (z))) / (size + gap)).toInt()

            println("clicked x=$x, y=$y, z=$z")
            world = world.flipAt(x, y, z)
        }
    }

    private fun drawGoL() {
        background(240f)


        // View
        fill(240f)
        stroke(120f)
        rect(4f,2f, width.toFloat() - 8f, (height - sliceHeightSum) - 8f)


        // Cube
        val sliceWidth3D = (world.width - 1) * (size3D + gap3D)
        val sliceHeight3D = (world.height - 1) * (size3D + gap3D)
        val sliceDepth3D = (world.depth - 1) * (size3D + gap3D)
        val viewHeight = height - sliceHeightSum

        line(0f, viewHeight / 2f, width.toFloat(), viewHeight / 2f)
        pushMatrix()
        translate(
                width / 2f,
                (viewHeight) / 2f + 50f,
                (world.depth - 1) * (size3D + gap3D))
        rotateY(rotation)

        stroke(200f, 0f, 0f)
        line(-200f, 0f, 0f, 200f, 0f, 0f)
        line(0f, -200f, 0f, 0f, 200f, 0f)
        line(0f, 0f, -200f, 0f, 0f, 200f)

        world.forEachIndexed { z, slice ->
            slice.forEachIndexed { y, row ->
                row.forEachIndexed { x, cell ->
                    pushMatrix()
                    translate(
                            x * (size3D + gap3D) - (sliceWidth3D / 2f),
                            y * (size3D + gap3D) - (sliceHeight3D / 2f),
                            -z * (size3D + gap3D) + (sliceDepth3D / 2f))
                    if (cell) fill((70 / (world.depth)) * z.toFloat(), 220f - (50 / world.depth) * z.toFloat()) else noFill()
                    stroke(100f, 60f)
                    box(size3D)
                    popMatrix()
                } } }
        popMatrix()


        // Slices
        pushMatrix()
        translate(width / 2f, 0f, 0f)
        world.forEachIndexed { z, slice ->
            slice.forEachIndexed { y, row ->
                row.forEachIndexed { x, cell ->
                    fill (if (cell) 40f else 230f)
                    stroke(120f)
                    rect(
                            x * (size + gap) + z * sliceGap + z * (sliceWidth - sliceGap) - sliceWidthSum / 2f + gap / 2f,
                            y * (size + gap) + (height - sliceHeightSum),
                            size,
                            size)
                } } }
        popMatrix()
    }
}


fun main(args: Array<String>) {
    GoLDemo.run()
}