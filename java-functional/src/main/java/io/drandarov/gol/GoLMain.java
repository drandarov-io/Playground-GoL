package io.drandarov.gol;

import io.drandarov.gol.playboard.Playboard;
import io.drandarov.gol.ruleset.DefaultRuleSet;

public class GoLMain {

    public static void main(String[] args) throws InterruptedException {
        Playboard playboard = new Playboard(20, 10, new DefaultRuleSet())
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
            .set(2, 2, true);
        System.out.println(playboard);

        for (int i = 0; i < 50; i++) {
            Thread.sleep(75);
            System.out.println(playboard = playboard.step());
        }
    }

}
