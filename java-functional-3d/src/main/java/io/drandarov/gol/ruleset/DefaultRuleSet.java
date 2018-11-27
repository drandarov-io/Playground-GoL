package io.drandarov.gol.ruleset;

public class DefaultRuleSet implements RuleSet {

    public boolean isCellAlive(boolean isAlive, int neighborCount) {
        return !(neighborCount < 2) && !(neighborCount > 3) && !(!isAlive && neighborCount == 2);
    }

}
