package io.drandarov.gol.ruleset;

public class DefaultRuleSet implements RuleSet {

    public boolean isCellAlive(int neighborCount) {
        return !(neighborCount < 2) && !(neighborCount > 3);
    }

}
