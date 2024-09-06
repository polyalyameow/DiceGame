public class RoundResult {
    private String winner;
    private int points;

    public RoundResult(String winner, int points) {
        this.winner = winner;
        this.points = points;
    }

    public String getWinner() {
        return winner;
    }

    public int getPoints() {
        return points;
    }
}
