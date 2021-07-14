package Game;

import java.util.Scanner;

public class Game {
    private int winOP = 0;
    private int winTP = 0;
    Scanner scanner = new Scanner(System.in);

    private void winRate() {
        System.out.println("X wins " + winOP + " times.");
        System.out.println("O wins " + winTP + " times.");

    }

    public void startGame() {
        System.out.println("Enter name of player № 1 (X)");
        Player oneP = new Player(scanner.nextLine());
        System.out.println("Enter name of player № 2 (O)");
        Player twoP = new Player(scanner.nextLine());
        gameLogic(oneP.getName(), twoP.getName());
    }

    private void gameLogic(String p1, String p2) {
        while (true) {
            Field field = new Field();
            field.printField();
            while (!field.checkField()) {
                field.stepPl1(p1);
                field.printField();
                if (field.checkWinner(p1)) {
                    winOP++;
                    break;
                }

                field.stepPl2(p2);
                field.printField();
                if (field.checkWinner(p2)) {
                    winTP++;
                    break;
                }
            }
            System.out.println("Enter 'yes' to continue playing.");
            if (!scanner.nextLine().equals("yes")) {
                winRate();
                break;
            }
        }
    }
}

