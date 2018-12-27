package io.drandarov.gol

import io.drandarov.gol.playboard.Playboard
import io.drandarov.gol.ruleset.DefaultRuleSet

object GoLDemo {

    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var playboard = Playboard(20, 10, DefaultRuleSet())
                // Glider
                .set(1, 0, true)
                .set(2, 1, true)
                .set(0, 2, true)
                .set(1, 2, true)
                .set(2, 2, true)
        println(playboard)

        for (i in 0..49) {
            Thread.sleep(75)
            playboard = playboard.step()
            println(playboard)
        }
    }

}
