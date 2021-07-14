package Game;

import java.util.Scanner;

public class Field {
    private int[][] arrayGame = new int[3][3];

    Field() {
        for (int i = 0; i < arrayGame.length; i++) {
            for (int j = 0; j < arrayGame[i].length; j++) {
                arrayGame[i][j] = 0;
            }
        }
    }

    public void printField() {
        for (int i = 0; i < arrayGame.length; i++) {
            for (int j = 0; j < arrayGame[i].length; j++) {
                if (this.arrayGame[i][j] == 0) {
                    System.out.print("  .");
                } else if (this.arrayGame[i][j] == 1) {
                    System.out.print("  X");
                } else if (this.arrayGame[i][j] == 2) {
                    System.out.print("  O");
                }
            }
            System.out.println();
        }
    }

    Scanner scanner = new Scanner(System.in);


    public void stepPl1(String name) {
        step1(name);
    }

    private int step1(String name) {
        System.out.println(name + ", enter integer numbers of rows and column (1-3).");
        int a = -1;
        int b = -1;
        do {

            if (scanner.hasNextInt()) {
                a = scanner.nextInt() - 1;
            } else {
                System.out.println(name + ", enter a integer.");
                scanner.next();
                continue;
            }
            if (scanner.hasNextInt()) {
                b = scanner.nextInt() - 1;
            } else {
                System.out.println(name + ", enter a integer.");
                scanner.next();
                continue;
            }
        } while (!checkCells(this.arrayGame, a, b, name));
        return this.arrayGame[a][b] = 1;
    }

    public void stepPl2(String name) {
        step2(name);
    }

    public int step2(String name) {
        System.out.println(name + ", enter integer numbers of rows and column (1-3).");
        int a = -1;
        int b = -1;
        do {

            if (scanner.hasNextInt()) {
                a = scanner.nextInt() - 1;
            } else {
                System.out.println(name + ", enter a integer.");
                scanner.next();
                continue;
            }
            if (scanner.hasNextInt()) {
                b = scanner.nextInt() - 1;
            } else {
                System.out.println(name + ", enter a integer.");
                scanner.next();
                continue;
            }
        } while (!checkCells(this.arrayGame, a, b, name));
        return this.arrayGame[a][b] = 2;
    }

    private boolean checkCells(int[][] array, int x, int y, String name) {
        if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
            if (array[x][y] == 0) {
                array[x][y] = 1;
                return true;
            } else {
                System.out.println(name + ", cell is occupied");
                return false;
            }
        } else {
            System.out.println(name + ", enter number: 1-3.");
            return false;
        }
    }


    public boolean checkWinner(String name) {
        if ((this.arrayGame[0][2] == 1 && this.arrayGame[1][1] == 1 && this.arrayGame[2][0] == 1) || (this.arrayGame[0][0] == 1 && this.arrayGame[1][1] == 1 && this.arrayGame[2][2] == 1)) {
            System.out.println("Congratulations! " + name + " wins.");
            return true;
        } else {
            for (int i = 0; i < this.arrayGame.length; i++) {
                if ((this.arrayGame[i][0] == 1 && this.arrayGame[i][1] == 1 && this.arrayGame[i][2] == 1) || (this.arrayGame[0][i] == 1 && this.arrayGame[1][i] == 1 && this.arrayGame[2][i] == 1)) {
                    System.out.println("Congratulations! " + name + " wins.");
                    return true;
                }
            }
        }
        if ((this.arrayGame[0][2] == 2 && this.arrayGame[1][1] == 2 && this.arrayGame[2][0] == 2) || (this.arrayGame[0][0] == 2 && this.arrayGame[1][1] == 2 && this.arrayGame[2][2] == 2)) {
            System.out.println("Congratulations! " + name + " wins.");

            return true;
        } else {
            for (int i = 0; i < this.arrayGame.length; i++) {
                if ((this.arrayGame[i][0] == 2 && this.arrayGame[i][1] == 2 && this.arrayGame[i][2] == 2) || (this.arrayGame[0][i] == 2 && this.arrayGame[1][i] == 2 && this.arrayGame[2][i] == 2)) {
                    System.out.println("Congratulations! " + name + " wins.");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkField() {
        int check1 = 0;
        for (int i = 0; i < this.arrayGame.length; i++) {
            for (int j = 0; j < this.arrayGame[i].length; j++) {
                if (this.arrayGame[i][j] == 0) {
                    check1++;
                }
            }
        }
        if (check1 == 0) {
            System.out.println("Game.Game over.\nNo winner.");
            return true;
        }
        return false;
    }
}

