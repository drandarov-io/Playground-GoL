package io.drandarov.gol.playboard

import io.drandarov.gol.ruleset.RuleSet

import java.util.ArrayList
import java.util.Arrays
import java.util.Collections
import java.util.stream.IntStream

class Playboard(x: Int, y: Int) {

    private val board: Array<BooleanArray> = Array(y) {BooleanArray(x)}
    private val ruleSets: MutableList<RuleSet>

    init {
        for (row in board) {
            Arrays.fill(row, java.lang.Boolean.FALSE)
        }

        this.ruleSets = ArrayList()
    }

    constructor(x: Int, y: Int, vararg ruleSets: RuleSet) : this(x, y) {
        Collections.addAll(this.ruleSets, *ruleSets)
    }

    constructor(playboard: Playboard) : this(playboard.board[0].size, playboard.board.size, *playboard.ruleSets.toTypedArray<RuleSet>()) {
        IntStream.range(0, board.size)
                .forEach { i -> System.arraycopy(playboard.board[i], 0, board[i], 0, board[0].size) }
    }

    fun step(): Playboard {
        val newPlayBoard = Playboard(this)

        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                newPlayBoard.board[i][j] = applyRuleSets(i, j)
            }
        }

        return newPlayBoard
    }

    operator fun set(x: Int, y: Int, isAlive: Boolean): Playboard {
        val newPlayBoard = Playboard(this)
        newPlayBoard.board[y][x] = isAlive
        return newPlayBoard
    }

    fun addRuleSet(ruleSet: RuleSet) {
        ruleSets.add(ruleSet)
    }

    private fun applyRuleSets(x: Int, y: Int): Boolean {
        return ruleSets.stream().allMatch { ruleSet -> ruleSet.isCellAlive(board[x][y], getNeighborCount(x, y)) }
    }

    private fun getNeighborCount(x: Int, y: Int): Int {
        var count = IntStream.rangeClosed(x - 1, x + 1)
                .flatMap { i ->
                    IntStream.rangeClosed(y - 1, y + 1)
                            .filter { j -> i >= 0 && j >= 0 && i < board.size && j < board[0].size && board[i][j] }
                }
                .count().toInt()

        return if (board[x][y]) --count else count
    }

    override fun toString(): String {
        return Arrays.stream(board).map { row ->
            row.map { cell -> if (cell) "X " else "· " }
                    .reduce { obj, str -> obj + str }.trim { it <= ' ' } + "\n"
        }
                .reduce { obj, str -> obj + str }.orElseThrow()
    }
}
