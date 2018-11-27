package io.drandarov.gol.playboard;

import io.drandarov.gol.ruleset.RuleSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Playboard {

    private final Boolean[][][] board;
    private final List<RuleSet> ruleSets;

    public Playboard(int x, int y, int z) {
        this.board = new Boolean[z][y][x];
        for (Boolean[][] row : board) {
            for (Boolean[] col : row) {
                Arrays.fill(col, Boolean.FALSE);
            }
        }

        this.ruleSets = new ArrayList<>();
    }

    public Playboard(int x, int y, int z, RuleSet... ruleSets) {
        this(x, y, z);
        Collections.addAll(this.ruleSets, ruleSets);
    }

    public Playboard(Playboard playboard) {
        this(playboard.board[0][0].length, playboard.board[0].length, playboard.board.length, playboard.ruleSets.toArray(new RuleSet[0]));
        IntStream.range(0, board.length)
                .forEach(i -> IntStream.range(0, board[0].length)
                        .forEach(j -> System.arraycopy(playboard.board[i][j], 0, board[i][j], 0, board[0][0].length)));
    }

    public Playboard step() {
        Playboard newPlayBoard = new Playboard(this);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < board[0][0].length; k++) {
                    newPlayBoard.board[i][j][k] = applyRuleSets(i, j, k);
                }
            }
        }

        return newPlayBoard;
    }

    public Playboard set(int x, int y, int z, boolean isAlive) {
        Playboard newPlayBoard = new Playboard(this);
        newPlayBoard.board[z][y][x] = isAlive;
        return newPlayBoard;
    }

    public void addRuleSet(RuleSet ruleSet) {
        ruleSets.add(ruleSet);
    }

    private boolean applyRuleSets(int x, int y, int z) {
        return ruleSets.stream().allMatch(ruleSet -> ruleSet.isCellAlive(board[x][y][z], getNeighborCount(x, y, z)));
    }

    private int getNeighborCount(int x, int y, int z) {
        int count = (int) IntStream.rangeClosed(x - 1, x + 1)
                .flatMap(i -> IntStream.rangeClosed(y - 1, y + 1)
                    .flatMap(j -> IntStream.rangeClosed(z - 1, z + 1)
                        .filter(k -> i >= 0 && j >= 0 && k >= 0 && i < board.length && j < board[0].length && k < board[0][0].length && board[i][j][k])))
                .count();

        return (board[x][y][z] ? --count : count);
    }

    @Override
    public String toString() {
        // TODO Only prints z-layer 0
        return Arrays.stream(board[0]).map(row -> Arrays.stream(row).map(col -> col ? "X " : "· ")
                .reduce(String::concat).orElseThrow().trim() + "\n")
                .reduce(String::concat).orElseThrow();
    }
}
