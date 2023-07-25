package Sudoku;

public class Puzzle {
    int[][] numbers = new int[9][9];
    boolean[][] isGiven = new boolean[9][9];

    public Puzzle() {
        super();
    }

    public void newPuzzle() {
        int[][] currentPuzzle = {
                {1,2,6,4,3,7,9,5,8},
                {8,9,5,6,2,1,4,7,3},
                {3,7,4,9,8,5,1,2,6},
                {4,5,7,1,9,3,8,6,2},
                {9,8,3,2,4,6,5,1,7},
                {6,1,2,5,7,8,3,9,4},
                {2,6,9,3,1,4,7,8,5},
                {5,4,8,7,6,9,2,3,1},
                {7,3,1,8,5,2,6,4,9}
        };

        boolean[][] currentIsGiven = {
                {false,true,false,false,false,false,false,false,false},
                {false,false,false,true,false,false,false,false,true},
                {false,true,true,false,true,false,false,false,false},
                {false,false,false,false,false,true,false,false,true},
                {false,true,false,false,true,false,false,true,false},
                {true,false,false,true,false,false,false,false,false},
                {false,false,false,false,true,false,true,true,false},
                {true,false,false,false,false,true,false,false,false},
                {false,false,false,false,false,false,false,true,false},
        };

        for (int row = 0; row < 9; row += 1) {
            for (int column = 0; column < 9; column += 1) {
                numbers[row][column] = currentPuzzle[row][column];
                isGiven[row][column] = currentIsGiven[row][column];

            }
        }
    }
}
