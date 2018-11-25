import java.util.ArrayList;
import java.util.List;

public class Playboard {

    private boolean[][] board;
    private List<RuleSet> ruleSets;

    public Playboard(int x, int y) {
        this.board = new boolean[x][y];
        this.ruleSets = new ArrayList<>();
    }

    public Playboard step() {
        for (int i = 0; i < board.length; i++) {

        }
        applyRuleSets();
        return new Playboard(board.length, board[0].length);
    }

    public void addRuleSet(RuleSet rs){
        ruleSets.add(rs);
    }

    private boolean applyRuleSets() {
        ruleSets.stream().map(ruleSet -> ruleSet.applyRules(getNeighborCount(0, 0)));
        return false;
    }

    private int getNeighborCount(int x, int y) {
        return 0;
    }
}
