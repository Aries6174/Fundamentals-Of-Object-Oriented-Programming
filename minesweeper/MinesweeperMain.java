//MinesweerperMain.java
//The Main File, this contains the Frame of the GUI and this is where you run the file to play the game
package minesweeper;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MinesweeperMain extends JFrame {
    private static final long serialVersionUID = 1L;

    Board board = new Board(); // gets a new board

    JButton btnewGame = new JButton("New Game"); // Button for playing a new Game

    // Minesweeper Main
    public MinesweeperMain() {
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // btnNewGame to the south to re-start the game
        btnewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.newGame();
            }
        });
        // btnNewGame to the North to re-start the game
        cp.add(btnewGame, BorderLayout.NORTH);

        // gets a new Board
        board.newGame();

        pack();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button
        setTitle("Minesweeper"); // Name of the program
        setVisible(true); // Makes it Visible atleast
    }

    // Just runs the whole thing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MinesweeperMain();
            }
        });
    }

}
