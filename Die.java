import java.util.Random;

public class Die {
    private int currentNum;
    private int sides;

    private static Random randomGenerator = new Random();

    public Die(int sides) {
        if (sides < 2) {
            throw new IllegalArgumentException("maxNum måste vara större än 1");
        }
        this.sides = sides;
        this.currentNum = roll();
    }

    public int roll() {
        this.currentNum = randomGenerator.nextInt(sides) + 1;
        return this.currentNum;
    }

    public int getCurrentNum() {
        return this.currentNum;
    }

    public int getSides() {
        return this.sides;
    }
}