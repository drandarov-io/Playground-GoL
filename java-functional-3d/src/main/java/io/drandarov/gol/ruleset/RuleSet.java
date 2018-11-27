package io.drandarov.gol.ruleset;

public interface RuleSet {

    boolean isCellAlive(boolean isAlive, int neighborCount);

}
