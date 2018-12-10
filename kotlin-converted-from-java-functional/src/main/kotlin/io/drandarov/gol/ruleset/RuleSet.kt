package io.drandarov.gol.ruleset

interface RuleSet {

    fun isCellAlive(isAlive: Boolean, neighborCount: Int): Boolean

}
