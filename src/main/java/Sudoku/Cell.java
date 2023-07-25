package Sudoku;

import javax.swing.*;
import java.awt.*;

public class Cell extends JTextField {
    int row, column, value;
    Status status;

    public static final Color BG_GIVEN = new Color(180, 160, 140);
    public static final Color FG_GIVEN = new Color(0, 0, 0);
    public static final Color FG_NOT_GIVEN = new Color(40, 40, 40);
    public static final Color BG_TO_GUESS  = new Color(240, 180, 120);
    public static final Color BG_CORRECT_GUESS = new Color(30, 150, 30);
    public static final Color BG_WRONG_GUESS = new Color(200, 25, 25);
    public static final Color FG_WRONG_GUESS = new Color(255, 255, 255);
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void drawCell(int value, boolean isGiven) {
        this.value = value;
        this.status = isGiven ? Status.GIVEN : Status.TO_GUESS;
        this.paint();
    }

    public void paint() {
            super.setText("" + this.value);
            super.setEditable(true);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
    }
}
