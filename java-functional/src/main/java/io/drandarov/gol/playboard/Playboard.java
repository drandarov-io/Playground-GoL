package io.drandarov.gol.playboard;

import io.drandarov.gol.ruleset.RuleSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Playboard {

    private final Boolean[][] board;
    private final List<RuleSet> ruleSets;

    public Playboard(int x, int y) {
        this.board = new Boolean[y][x];
        for (Boolean[] row : board) {
            Arrays.fill(row, Boolean.FALSE);
        }

        this.ruleSets = new ArrayList<>();
    }

    public Playboard(int x, int y, RuleSet... ruleSets) {
        this(x, y);
        Collections.addAll(this.ruleSets, ruleSets);
    }

    public Playboard(Playboard playboard) {
        this(playboard.board[0].length, playboard.board.length, playboard.ruleSets.toArray(new RuleSet[0]));
        IntStream.range(0, board.length)
                .forEach(i -> System.arraycopy(playboard.board[i], 0, board[i], 0, board[0].length));
    }

    public Playboard step() {
        Playboard newPlayBoard = new Playboard(this);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newPlayBoard.board[i][j] = applyRuleSets(i, j);
            }
        }

        return newPlayBoard;
    }

    public Playboard set(int x, int y, boolean isAlive) {
        Playboard newPlayBoard = new Playboard(this);
        newPlayBoard.board[x][y] = isAlive;
        return newPlayBoard;
    }

    public void addRuleSet(RuleSet ruleSet) {
        ruleSets.add(ruleSet);
    }

    private boolean applyRuleSets(int x, int y) {
        return this.board[x][y] = ruleSets.stream().allMatch(ruleSet -> ruleSet.isCellAlive(getNeighborCount(x, y)));
    }

    private int getNeighborCount(int x, int y) {
        int count = (int) IntStream.rangeClosed(x - 1, x + 1)
                .flatMap(i -> IntStream.rangeClosed(y - 1, y + 1)
                        .filter(j -> x > 0 && y > 0 && x < board.length - 1 && y < board[0].length - 1 && board[i][j]))
                .count();

        return (board[x][y] ? --count : count);
    }

    @Override
    public String toString() {
        return Arrays.stream(board).map(row -> Arrays.stream(row).map(cell -> cell ? "X " : "· ")
                .reduce(String::concat).orElseThrow().trim() + "\n")
                .reduce(String::concat).orElseThrow();
    }
}
