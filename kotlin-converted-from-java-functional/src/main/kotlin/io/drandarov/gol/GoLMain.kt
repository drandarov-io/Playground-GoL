package io.drandarov.gol

import io.drandarov.gol.playboard.Playboard
import io.drandarov.gol.ruleset.DefaultRuleSet

object GoLMain {

    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        var playboard = Playboard(20, 10, DefaultRuleSet())
                //Stuff
                //            .set(1, 1, true)
                //            .set(1, 2, true)
                //            .set(3, 1, true)
                //            .set(0, 0, true)
                //            .set(2, 1, true)
                //            .set(2, 1, true)
                //            .set(5, 8, true)
                //            .set(4, 8, true)
                //            .set(3, 8, true)
                //            .set(5, 9, true)
                //            .set(4, 9, true);
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
