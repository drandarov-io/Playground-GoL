import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultRuleSetTest {

    @Test
    void rule1Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertFalse(defaultRuleSet.applyRules(0));
    }

    @Test
    void rule2Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertTrue(defaultRuleSet.applyRules(2));
    }

    @Test
    void rule3Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertTrue(defaultRuleSet.applyRules(3));
    }

    @Test
    void rule4Test() {
        DefaultRuleSet defaultRuleSet = new DefaultRuleSet();
        assertFalse(defaultRuleSet.applyRules(4));
    }

}
