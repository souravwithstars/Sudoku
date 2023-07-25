package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel {
    private static final int WIDTH = 9;
    private static final int HEIGHT = 9;
    private static final int CELL_SIZE = 75;
    private static final int BOARD_SIZE = CELL_SIZE * WIDTH;

    private Cell[][] cells = new Cell[WIDTH][HEIGHT];
    private Puzzle puzzle = new Puzzle();
    public GameBoard(){
        CellInputListener listener = new CellInputListener();
        super.setLayout(new GridLayout(WIDTH, HEIGHT));

        for(int row = 0; row < HEIGHT; row += 1) {
            for(int column = 0; column < WIDTH; column += 1) {
                cells[row][column] = new Cell(row, column);
                super.add(cells[row][column]);
                if(cells[row][column].isEditable()){
                    cells[row][column].addActionListener(listener);
                }
            }
        }

        super.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
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

    static class CellInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            Cell sourceCell = (Cell)event.getSource();
            int inputNumber = Integer.parseInt(sourceCell.getText());
            System.out.println("Last Entered : " + inputNumber);

            if(inputNumber == sourceCell.value) {
                sourceCell.status = Status.CORRECT_GUESS;
            } else {
                sourceCell.status = Status.WRONG_GUESS;
            }

            sourceCell.paint();
        }
    }
}
