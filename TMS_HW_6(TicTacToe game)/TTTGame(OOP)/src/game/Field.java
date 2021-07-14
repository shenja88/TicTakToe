package game;

class Field {
    private final int[][] arrayGame = new int[3][3];

    Field() {
        for (int i = 0; i < arrayGame.length; i++) {
            for (int j = 0; j < arrayGame[i].length; j++) {
                arrayGame[i][j] = 4;
            }
        }
    }

    int[][] getArrayGame() {
        return arrayGame;
    }

    void printField() {
        for (int i = 0; i < arrayGame.length; i++) {
            for (int j = 0; j < arrayGame[i].length; j++) {
                if (this.arrayGame[i][j] == 4) {
                    System.out.print("  .");
                } else if (this.arrayGame[i][j] == 0) {
                    System.out.print("  X");
                } else if (this.arrayGame[i][j] == 1) {
                    System.out.print("  O");
                }
            }
            System.out.println();
        }
    }
}

