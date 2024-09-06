import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public void playersInfo(Scanner scanner, ArrayList<Player> players) {

        System.out.println("Hur många spelare ska spela?");
        int amountPlayers = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hur många tärningar ska varje spelare ha?");
        int numDice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hur många sidor ska tärningar ha?");
        int numSides = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= amountPlayers; i++) {
            System.out.println("Skriv in namnet på spelare nummer " + i);
            String playerName = scanner.nextLine();

            Player player = new Player(playerName, 0);
            players.add(player);

            for (int j = 0; j < numDice; j++) {
                player.addDie(numSides);
            }

        }
        gameStart(scanner, players);

    }

    public void gameStart(Scanner scanner, ArrayList<Player> players) {
        System.out.println("=================");
        System.out.println("Game has started");
        System.out.println("=================");

        ArrayList<RoundResult> roundWinners = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Rundan nummer " + (i + 1));

            int maxPoints = 0;
            String roundWinner = "";

            for (Player player : players) {
                System.out.println("Det är " + player.getName() + " tur nu");

                System.out.println("Gissa ett värde");
                int guess = scanner.nextInt();
                scanner.nextLine();

                player.rollDice();
                int diceSum = player.getDieValue();
                System.out.println(player.getName() + " rullade totalt " + diceSum);

                if (guess == diceSum) {
                    System.out.println("Rätt. Du får 1 poäng.");
                    player.increaseScore();
                    System.out.println("================");
                    roundWinner = player.getName();
                    maxPoints = player.getPoints();
                } else {
                    System.out.println("FEEEEL!!!");
                    System.out.println("================");
                }

            }

            if (maxPoints > 0) {
                roundWinners.add(new RoundResult(roundWinner, maxPoints));
                System.out.println("Vinnaren av denna runda : " + roundWinner);

            } else {
                System.out.println("Ingen vann denna runda.");
            }

        }

        System.out.println("Spelet har tagit slut");

        int highestPoint = 0;
        String winner = "";

        for (Player player : players) {
            if (player.getPoints() >= highestPoint) {
                highestPoint = player.getPoints();
                winner = player.getName();
            }
        }

        if (highestPoint == 0) {
            System.out.println("Usch, ingen vinnare här -_-");
        } else {
            System.out.println("Spelets vinnare är " + winner + " som fick " + highestPoint + " poäng.");
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        Main game = new Main();
        game.playersInfo(scanner, players);

        scanner.close();
    }
}
