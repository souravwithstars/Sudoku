package Sudoku;
import java.awt.*;
import javax.swing.*;

public class Sudoku extends JFrame{

    public Sudoku(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
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