import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Nim!");

        boolean playAgain;
        do {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    private static void playGame() {
        System.out.print("Enter Player 1's name: ");
        String player1 = scanner.nextLine();

        System.out.print("Enter Player 2's name: ");
        String player2 = scanner.nextLine();

        int pileSize = random.nextInt(41) + 10; // Random pile size between 10 and 50
        System.out.println("Initial pile size: " + pileSize + " pieces");

        boolean player1Turn = random.nextBoolean(); // Randomly choose the starting player

        while (pileSize > 0) {
            String currentPlayer = (player1Turn) ? player1 : player2;
            int min = 1;
            int max = Math.min(pileSize / 2, pileSize - 1);

            System.out.println(currentPlayer + "'s turn. The pile size is: " + pileSize + " pieces.");
            int chosenPieces;
            do {
                System.out.print("Choose between " + min + " and " + max + " pieces to take: ");
                chosenPieces = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (chosenPieces < min || chosenPieces > max) {
                    System.out.println("Invalid number of pieces. Please choose again.");
                }
            } while (chosenPieces < min || chosenPieces > max);

            pileSize -= chosenPieces;

            if (pileSize == 0) {
                System.out.println(currentPlayer + " took the last piece. " + currentPlayer + " wins!");
            } else {
                player1Turn = !player1Turn;
            }
        }
    }
}
