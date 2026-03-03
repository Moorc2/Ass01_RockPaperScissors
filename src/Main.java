import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerAMove = "";
        String playerBMove = "";
        String nameA = "";
        String nameB = "";
        String playAgain = "";
        String trash = "";
        boolean validMove = false; // sets validMove to false during initial move
        boolean validPlayAgain = false; // defaults play again to false
        int valueA = 0;
        int valueB = 0;
        int crossProduct = 0;

        do {
            validMove = false;
            validPlayAgain = false; // got stuck in a play again loop when the user chose Yes without this line
            // Player A move selection loop
            while (!validMove) {
                System.out.print("Player A, enter your move ( [R]ock, [P]aper, or [S]cissor ): ");
                playerAMove = in.nextLine();
                if (playerAMove.equalsIgnoreCase("R") || playerAMove.equalsIgnoreCase("P") || playerAMove.equalsIgnoreCase("S")) {
                    validMove = true;
                } else {
                    trash = playerAMove;
                    System.out.println("Invalid input: " + trash + ". Please enter ( [R]ock, [P]aper, or [S]cissor )");
                }
            }

            // Player B move selection loop
            validMove = false;
            while (!validMove) {
                System.out.print("Player B, enter your move ( [R]ock, [P]aper, or [S]cissor ): ");
                playerBMove = in.nextLine();
                if (playerBMove.equalsIgnoreCase("R") || playerBMove.equalsIgnoreCase("P") || playerBMove.equalsIgnoreCase("S")) {
                    validMove = true;
                } else {
                    trash = playerBMove;
                    System.out.println("Invalid input: " + trash + ". Please enter ( [R]ock, [P]aper, or [S]cissor )");
                }
            }

            // assign values to moves
            if (playerAMove.equalsIgnoreCase("R")) {
                valueA = 0; nameA = "Rock";
            } else if (playerAMove.equalsIgnoreCase("P")) {
                valueA = 1; nameA = "Paper";
            } else {
                valueA = 2; nameA = "Scissors";
            }

            if (playerBMove.equalsIgnoreCase("R")) {
                valueB = 0; nameB = "Rock";
            } else if (playerBMove.equalsIgnoreCase("P")) {
                valueB = 1; nameB = "Paper";
            } else {
                valueB = 2; nameB = "Scissors";
            }

            // Determine winner
            crossProduct = valueA - valueB;

            if (crossProduct == 0) {
                System.out.println(nameA + " vs " + nameB + " it is a Tie!");
            } else if (crossProduct == 1 || crossProduct == -2) {
                if (playerAMove.equalsIgnoreCase("R")) System.out.println("Rock breaks Scissors");
                else if (playerAMove.equalsIgnoreCase("P")) System.out.println("Paper covers Rock");
                else System.out.println("Scissors cuts Paper");
                System.out.println("Player A wins!");
            } else {
                if (playerBMove.equalsIgnoreCase("R")) System.out.println("Rock breaks Scissors");
                else if (playerBMove.equalsIgnoreCase("P")) System.out.println("Paper covers Rock");
                else System.out.println("Scissors cuts Paper");
                System.out.println("Player B wins!");
            }

            // Ask player if they want to play again, catch invalid input
            while (!validPlayAgain) {
                System.out.print("Do you want to play again? ( [Y]es / [N]no ): ");
                playAgain = in.nextLine();

                if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("N")) {
                    validPlayAgain = true;
                } else {
                    trash = playAgain;
                    System.out.println("Invalid input: " + trash + ". Please enter ( [Y]es or [N]o ).");
                }
            }
            // Loops until player answers Y to play again or N to quit
        } while (playAgain.equalsIgnoreCase("Y"));
    }
}