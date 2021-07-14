import Game.Game;

import java.util.Scanner;

public class TicTakToe {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the TicTacToe game!");
        System.out.println("Enter 'yes' to start new game.");
        boolean newGame = false;
        if (scanner.nextLine().equals("yes")) {
            newGame = true;
            while (newGame) {
                Game game = new Game();
                game.startGame();
                System.out.println("Enter 'yes' to start new game with new players");
                if (scanner.nextLine().equals("yes")) {
                    newGame = true;
                } else {
                    System.out.println("Thanks for the game!");
                    newGame = false;
                }
            }
        } else {
            System.out.println("Thanks for the game!");
        }
    }
}
