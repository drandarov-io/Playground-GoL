public class GOLMain {

    public static void main(String[] args) {
        Playboard playboard = new Playboard(20, 20);
        playboard.addRuleSet(new DefaultRuleSet());

        playboard.step();

        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        System.out.println(defaultRuleSet.applyRules(0));
        System.out.println(defaultRuleSet.applyRules(1));
        System.out.println(defaultRuleSet.applyRules(2));
        System.out.println(defaultRuleSet.applyRules(3));
        System.out.println(defaultRuleSet.applyRules(4));
        System.out.println(defaultRuleSet.applyRules(5));
    }

}
