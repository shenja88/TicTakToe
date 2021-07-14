package game;

import java.util.Scanner;

public class Game {
    private int winOP = 0;
    private int winTP = 0;
    private Field field;
    private Player oneP;
    private Player twoP;

    Scanner scanner = new Scanner(System.in);

    private void winRate() {
        System.out.println("X wins " + winOP + " times.");
        System.out.println("O wins " + winTP + " times.");
    }

    public void startGame() {
        System.out.println("Enter 'yes' to start new game.");
        boolean newGame;
        if (scanner.nextLine().equals("yes")) {
            newGame = true;
            while (newGame) {
                gameLogic();
                System.out.println("Enter 'yes' to start new game with new players");
                if (scanner.next().equals("yes")) {
                    newGame = true;
                    winOP = 0;
                    winTP = 0;
                } else {
                    System.out.println("Thanks for the game!");
                    newGame = false;
                }
            }
        } else {
            System.out.println("Thanks for the game!");
        }
    }

    private void gameLogic() {
        System.out.println("Enter name of player № 1 (X)");
        oneP = new Player(scanner.next(), 0);
        System.out.println("Enter name of player № 2 (O)");
        twoP = new Player(scanner.next(), 1);
        while (true) {
            field = new Field();
            field.printField();
            while (true) {
                if (stepPlayer(oneP)) {
                    break;
                }
                if (!checkField(field.getArrayGame())) {
                    break;
                }
                if (stepPlayer(twoP)) {
                    break;
                }
            }
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter 'yes' to continue playing.");
            if (!scanner1.nextLine().equals("yes")) {
                winRate();
                break;
            }
        }
    }

    private boolean stepPlayer(Player player) {
        input(player.getName(), player.getPlayer(), field.getArrayGame());
        field.printField();
        if (checkWinner(player.getName(), field.getArrayGame(), player.getPlayer())) {
            if (player.equals(oneP)) {
                winOP++;
            } else if (player.equals(twoP)) {
                winTP++;
            }
            return true;
        }
        return false;
    }

    private void input(String name, int pl, int[][] arrayGame) {
        System.out.println(name + ", enter integer numbers of rows and column (1-3).");
        int a = -1;
        int b = -1;
        do {
            a = Input.checkInt(name);
            b = Input.checkInt(name);
        } while (!checkCells(arrayGame, a, b, name));
        arrayGame[a][b] = pl;
    }

    private boolean checkWinner(String name, int[][] arrayGame, int pl) {
        if ((arrayGame[0][2] == pl && arrayGame[1][1] == pl && arrayGame[2][0] == pl) ||
                (arrayGame[0][0] == pl && arrayGame[1][1] == pl && arrayGame[2][2] == pl)) {
            System.out.println("Congratulations! " + name + " wins.");
            return true;
        } else {
            for (int i = 0; i < arrayGame.length; i++) {
                if ((arrayGame[i][0] == pl && arrayGame[i][1] == pl && arrayGame[i][2] == pl) ||
                        (arrayGame[0][i] == pl && arrayGame[1][i] == pl && arrayGame[2][i] == pl)) {
                    System.out.println("Congratulations! " + name + " wins.");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkField(int[][] arrayGame) {
        int check1 = 0;
        for (int[] ints : arrayGame) {
            for (int anInt : ints) {
                if (anInt == 4) {
                    check1++;
                }
            }
        }
        if (check1 == 0) {
            System.out.println("Game over.\nNo winner.");
            return false;
        }
        return true;
    }

    private boolean checkCells(int[][] field, int a, int b, String name) {
        if (field[a][b] == 4) {
            return true;
        } else {
            System.out.println(name + ", cell is occupied");
            return false;
        }
    }
}

