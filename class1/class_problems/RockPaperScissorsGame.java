

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static Random random = new Random();

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(3)];
    }

    public static String formatMove(String move) {
        move = move.trim().toLowerCase();

        if (move.equals("rock")) {
            return "Rock";
        } else if (move.equals("paper")) {
            return "Paper";
        } else if (move.equals("scissors")) {
            return "Scissors";
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rounds: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {

            String playerMove;

            while (true) {
                System.out.print("Round " + (i + 1) +
                        " - Enter Rock, Paper, or Scissors: ");

                playerMove = formatMove(scanner.nextLine());

                if (playerMove != null) {
                    break;
                }

                System.out.println("Invalid move. Please try again.");
            }

            String computerMove = generateComputerMove();
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        double winPercentage = ((double) wins / n) * 100;

        System.out.println("==============================================");
        System.out.println("              FINAL SUMMARY");
        System.out.println("==============================================");

        System.out.printf("%-8s %-15s %-18s %-18s%n",
                "Round", "Player Move", "Computer Move", "Result");

        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-18s %-18s%n",
                    (i + 1),
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        scanner.close();
    }
}
