package Sudoku;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private static int WIDTH = 9;
    private static int HEIGHT = 9;

    Cell[][] cells;
    Puzzle puzzle = new Puzzle();
    public GameBoard(){
        super.setLayout(new GridLayout(WIDTH, HEIGHT));

        for(int row = 0; row < HEIGHT; row += 1) {
            for(int column = 0; column < WIDTH; column += 1) {
                cells[row][column] = new Cell(row, column);
                super.add(cells[row][column]);
            }
        }
    }

    public void newGame() {
        puzzle.newPuzzle();
        for(int row = 0; row < HEIGHT; row += 1) {
            for (int column = 0; column < WIDTH; column += 1) {
                cells[row][column].drawCell(
                        puzzle.numbers[row][column],
                        puzzle.isGiven[row][column]
                );
            }
        }
    }
}
