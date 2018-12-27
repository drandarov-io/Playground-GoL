package io.drandarov.gol;

import io.drandarov.gol.playboard.Playboard;
import io.drandarov.gol.ruleset.DefaultRuleSet;

public class GoLDemo {

    public static void main(String[] args) throws InterruptedException {
        Playboard playboard = new Playboard(20, 10, new DefaultRuleSet())
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
