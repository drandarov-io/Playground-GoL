package io.drandarov.gol;

import io.drandarov.gol.playboard.Playboard;
import io.drandarov.gol.ruleset.DefaultRuleSet;

public class GOLMain {

    public static void main(String[] args) {
        Playboard playboard = new Playboard(20, 10, new DefaultRuleSet())
            .set(1, 1, true)
            .set(1, 2, true)
            .set(3, 1, true)
            .set(0, 0, true)
            .set(2, 1, true)
            .set(2, 1, true)
            .set(5, 8, true)
            .set(4, 8, true)
            .set(3, 8, true)
            .set(5, 9, true)
            .set(4, 9, true);
        System.out.println(playboard);

        for (int i = 0; i < 10; i++) {
            System.out.println(playboard = playboard.step());
        }
    }

}
