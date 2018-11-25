public class DefaultRuleSet implements RuleSet {

    public boolean applyRules(int neighborCount) {
        return !(neighborCount < 2) && !(neighborCount > 3);
    }

}
