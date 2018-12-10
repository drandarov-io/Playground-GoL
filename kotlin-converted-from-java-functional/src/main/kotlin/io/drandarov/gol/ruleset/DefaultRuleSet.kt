package io.drandarov.gol.ruleset

class DefaultRuleSet : RuleSet {

    override fun isCellAlive(isAlive: Boolean, neighborCount: Int): Boolean {
        return neighborCount in 2..3 && (isAlive || neighborCount != 2)
    }

}
