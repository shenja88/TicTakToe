import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the TicTacToe game!");

        System.out.println("Enter name of player № 1 (X)");
        String name1 = scanner.nextLine();
        System.out.println("Enter name of player № 2 (O)");
        String name2 = scanner.nextLine();

        int win1 = 0;
        int win2 = 0;
        boolean startGame = false;
        do {
            Scanner scanner1 = new Scanner(System.in);
            int[][] gField = new int[3][3];
            for (int i = 0; i < gField.length; i++) {
                for (int j = 0; j < gField[i].length; j++) {
                    gField[i][j] = 0;
                }
            }
            for (int i = 0; i < gField.length; i++) {
                for (int j = 0; j < gField[i].length; j++) {
                    if (gField[i][j] == 0) {
                        System.out.print("  .");
                    } else if (gField[i][j] == 1) {
                        System.out.print("  X");
                    } else if (gField[i][j] == 2) {
                        System.out.print("  O");
                    }
                }
                System.out.println();
            }
            boolean wins = false;
            String pName;
            int player = 1;
            while (true) {
                if (player == 1) {
                    pName = name1;
                } else {
                    pName = name2;
                }
                //ввод 'Х или O' игроков и проверка правильности ввода до верного значения + проверка - занята ли клетка.
                System.out.println(pName + ", enter integer numbers of rows and column (1-3).");
                while (true) {
                    int x = -1;
                    if (scanner1.hasNextInt()) {
                        x = scanner1.nextInt() - 1;
                    } else {
                        System.out.println(pName + ", enter a integer.");
                        scanner1.next();
                        continue;
                    }
                    int y = -1;
                    if (scanner1.hasNextInt()) {
                        y = scanner1.nextInt() - 1;
                    } else {
                        System.out.println(pName + ", enter a integer.");
                        scanner1.next();
                        continue;
                    }
                    if ((x >= 0 && x < 3) && (y >= 0 && y < 3)) {
                        if (gField[x][y] == 0) {
                            gField[x][y] = player;
                            break;
                        } else {
                            System.out.println(pName + ", cell is occupied");
                        }
                    } else {
                        System.out.println(pName + ", enter number: 1-3.");
                    }
                }
                for (int i = 0; i < gField.length; i++) {
                    for (int j = 0; j < gField[i].length; j++) {
                        if (gField[i][j] == 0) {
                            System.out.print("  .");
                        } else if (gField[i][j] == 1) {
                            System.out.print("  X");
                        } else if (gField[i][j] == 2) {
                            System.out.print("  O");
                        }
                    }
                    System.out.println();
                }
                //Проверка выигрыша игрока, если true - выход из цикла.
                if ((gField[0][2] == player && gField[1][1] == player && gField[2][0] == player) || (gField[0][0] == player && gField[1][1] == player && gField[2][2] == player)) {
                    wins = true;
                } else {
                    for (int i = 0; i < gField.length; i++) {
                        if ((gField[i][0] == player && gField[i][1] == player && gField[i][2] == player) || (gField[0][i] == player && gField[1][i] == player && gField[2][i] == player)) {
                            wins = true;
                        }
                    }
                }
                if (wins && pName.equals(name1)) {
                    System.out.println("Congratulations! " + pName + " wins.");
                    win1++;
                    break;
                }else if(wins && pName.equals(name2)){
                    System.out.println("Congratulations! " + pName + " wins.");
                    win2++;
                    break;
                }
                //Проверка свободных клеток на поле, если на поле нет 0 (".") - завершение игры.
                int check1 = 0;
                for (int i = 0; i < gField.length; i++) {
                    for (int j = 0; j < gField[i].length; j++) {
                        if (gField[i][j] == 0) {
                            check1++;
                        }
                    }
                }
                if (check1 == 0) {
                    System.out.println("Game over.\nNo winner.");
                    break;
                }
                if (player == 1) {
                    player = 2;
                } else {
                    player = 1;
                }
            }
            System.out.println("Enter 'yes' to continue playing.");
            if (scanner.nextLine().equals("yes")) {
                startGame = true;
            } else {
                startGame = false;
                System.out.println(name1 + " wins " + win1 + " times.");
                System.out.println(name2 + " wins " + win2 + " times.");
            }
        } while (startGame);
    }
}




