package Sudoku;
import java.awt.*;
import javax.swing.*;

public class Sudoku extends JFrame{
    GameBoard board = new GameBoard();

    public Sudoku(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());


        contentPane.add(board, BorderLayout.CENTER);
        board.newGame();

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sudoku();
            }
        });
    }
}