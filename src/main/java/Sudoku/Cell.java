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
    public static final Font NUMBERS_FONT = new Font("OCR A Extended", Font.PLAIN, 28);
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(NUMBERS_FONT);
        super.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setBorderOnCell(row, column);
    }

    public void drawCell(int value, boolean isGiven) {
        this.value = value;
        this.status = isGiven ? Status.GIVEN : Status.TO_GUESS;
        this.paint();
    }

    public void paint() {
        if(this.status == Status.GIVEN) {
            super.setText("" + this.value);
            super.setEditable(false);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
        } else if (this.status == Status.TO_GUESS) {
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_TO_GUESS);
            super.setForeground(FG_NOT_GIVEN);
        } else if (this.status == Status.CORRECT_GUESS) {
            super.setBackground(BG_CORRECT_GUESS);
            super.setForeground(FG_GIVEN);
        } else if (this.status == Status.WRONG_GUESS) {
            super.setBackground(BG_WRONG_GUESS);
            super.setForeground(FG_WRONG_GUESS);
        }
    }

    public void setBorderOnCell(int row, int column) {
        if(row % 3 == 0 && row > 0) {
            super.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.BLACK));
        }
        if (column % 3 == 0 && column > 0) {
            super.setBorder(BorderFactory.createMatteBorder(1, 4, 1, 1, Color.BLACK));
        }
        if (row % 3 == 0 && column % 3 == 0 && row > 0 && column > 0) {
            super.setBorder(BorderFactory.createMatteBorder(4, 4, 1, 1, Color.BLACK));
        }
    }
}
