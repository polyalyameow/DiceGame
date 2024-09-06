import java.util.ArrayList;

public class Player {
    private String name;
    private int points;
    private ArrayList<Die> dices;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
        this.dices = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public void rollDice() {
        for (Die die : dices) {
            die.roll();
        }
    }

    public int getDieValue() {
        int sum = 0;
        for (Die die : dices) {
            sum += die.getCurrentNum();
        }

        return sum;
    };

    public void increaseScore() {
        points = points + 1;
    }

    public void addDie(int sides) {
        Die newDice = new Die(sides);
        dices.add(newDice);
    }

}
