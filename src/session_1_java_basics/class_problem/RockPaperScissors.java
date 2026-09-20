package session_1_java_basics.class_problem;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        String p = playerMove.trim().toLowerCase();
        String c = computerMove.trim().toLowerCase();

        if (p.equals(c)) {
            return "Draw";
        }

        if ((p.equals("rock") && c.equals("scissors")) ||
            (p.equals("paper") && c.equals("rock")) ||
            (p.equals("scissors") && c.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n = 5;
        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, Scissors) or press enter for demo: ");
            String input = "";
            if (sc.hasNextLine()) {
                input = sc.nextLine().trim();
            }
            if (input.isEmpty()) {
                String[] demoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
                playerMoves[i] = demoMoves[i % demoMoves.length];
            } else {
                playerMoves[i] = input;
            }

            computerMoves[i] = moves[rand.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Round " + (i + 1) + " — Player: " + playerMoves[i] + ", Computer: " + computerMoves[i] + " -> " + results[i]);
        }

        System.out.println("\n----------------- Summary Table -----------------");
        System.out.printf("%-7s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-7d | %-12s | %-14s | %-14s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------------");

        double winPercent = (wins * 100.0) / n;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercent);

        sc.close();
    }
}
