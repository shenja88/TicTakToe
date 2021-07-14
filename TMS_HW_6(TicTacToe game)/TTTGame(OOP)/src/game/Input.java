package game;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int checkInt(String name) {
        int a = -1;
        if (SCANNER.hasNextInt()) {
            a = SCANNER.nextInt() - 1;
            if (a >= 0 && a < 3) {
                return a;
            } else {
                System.out.println(name + ", enter number: 1-3.");
            }
        } else {
            System.out.println(name + ", enter a integer!");
            SCANNER.next();
        }
        return checkInt(name);
    }
}

