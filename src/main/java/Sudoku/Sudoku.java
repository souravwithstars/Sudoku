package Sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Sudoku extends JFrame{
    GameBoard board = new GameBoard();
    JButton newGameButton = new JButton("New Game");
    public static final Font BUTTON_FONT = new Font("OCR A Extended", Font.PLAIN, 36);


    public Sudoku(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        newGameButton.setPreferredSize(new Dimension(250, 50));
        newGameButton.setFont(BUTTON_FONT);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.newGame();
            }
        });

        contentPane.add(board, BorderLayout.CENTER);
        contentPane.add(newGameButton, BorderLayout.SOUTH);
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