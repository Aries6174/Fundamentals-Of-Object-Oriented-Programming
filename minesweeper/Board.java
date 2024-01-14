// Board.java
//Contains everything that is necessary inside the board such as the Grid Layout, mixed with the mines and non mines, If the block is shown or not
// aswell as the count of how many mines surrounds the specific block
package minesweeper;

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static minesweeper.rowsAndColumns.rows;
import static minesweeper.rowsAndColumns.cols;

//Board will be the Panel
public class Board extends JPanel {
    private static final long serialVersionUID = 1L; // To avoid the warnings
    public static final int blockSize = 60; // Setting the size of the block
    public static final int canvasWidth = blockSize * cols; // Fixed Size of the Panel by Width
    public static final int canvasHeight = blockSize * rows; // Pixed Size of the Panel by Height

    Block block[][] = new Block[rows][cols]; // The number of blocks
    int numOfMines = 10; // number of mines that existin the game

    // New Game
    public void newGame() {
        // creating an instance and setting up the mines
        Map mineMap = new Map();
        mineMap.newMap(numOfMines);

        for (int blockOnRow = 0; blockOnRow < rows; blockOnRow++) {
            for (int blockOnCol = 0; blockOnCol < cols; blockOnCol++) {
                block[blockOnRow][blockOnCol].newGame(mineMap.isMined[blockOnRow][blockOnCol]);
            }
        }
    }

    public Board() {
        // set the layout of the board, including the number of Buttons in the board
        super.setLayout(new GridLayout(rows, cols, 2, 2));
        CellMouseListener listener = new CellMouseListener();
        for (int blockOnRow = 0; blockOnRow < rows; ++blockOnRow) {
            for (int blockOnCol = 0; blockOnCol < cols; ++blockOnCol) {
                block[blockOnRow][blockOnCol] = new Block(blockOnRow, blockOnCol);
                super.add(block[blockOnRow][blockOnCol]);

                block[blockOnRow][blockOnCol].addMouseListener(listener);
            }
        }
        super.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    private void revealBlock(int rsrc, int csrc) {
        // properties of the block being revealed.
        int numOfMines = getNumberAroundMines(rsrc, csrc);
        block[rsrc][csrc].setText(numOfMines + "");
        block[rsrc][csrc].isShow = true;
        block[rsrc][csrc].paint();
        if (numOfMines == 0) {
            for (int row = rsrc - 1; row <= rsrc + 1; row++) {
                for (int col = csrc - 1; col <= csrc + 1; col++) {
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        if (!block[row][col].isShow) {
                            revealBlock(row, col);
                        }
                    }
                }
            }
        }
    }

    private int getNumberAroundMines(int rsrc, int crsc) {
        // Gets the number of mines that exist near the block pressed (assuming the
        // block is not a mine)
        int numOfMines = 0;

        for (int row = rsrc - 1; row <= rsrc + 1; row++) {
            for (int col = crsc - 1; col <= crsc + 1; col++) {
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    if (block[row][col].isMined) {
                        numOfMines++;
                    }
                }
            }
        }
        return numOfMines;
    }

    private class CellMouseListener extends MouseAdapter {
        // Mouse inputs
        @Override
        public void mouseClicked(MouseEvent e) {
            Block sourceBlock = (Block) e.getSource();

            System.out.println("You clicked on (" + sourceBlock.row + "," + sourceBlock.col + ")");

            if (e.getButton() == MouseEvent.BUTTON1) { // left click
                if (sourceBlock.isMined) {
                    System.out.println("Game Over");
                    sourceBlock.setText("*");
                    showGameOverPopup();
                    // Handle game over logic as needed
                } else {
                    revealBlock(sourceBlock.row, sourceBlock.col);
                }
            } else if (e.getButton() == MouseEvent.BUTTON3) { // right click
                if (sourceBlock.isFlag()) {
                    sourceBlock.setFlag(false);
                } else {
                    sourceBlock.setFlag(true);
                }
                // Update the UI to reflect the flag status
                sourceBlock.paint();
            }

            if (hasWon()) {
                // If the player won, and all non-mine blocks are pressed
                System.out.println("Congratulations! You've won!");
                // prints in the terminal
            }
        }

        private void showGameOverPopup() {
            // if the player presses a mined Block
            JOptionPane.showMessageDialog(null, "Game Over! You clicked on a mine.", "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        public boolean hasWon() {
            // checks if all non-mine blocks are open
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (!block[row][col].isMined && !block[row][col].isShow) {
                        return false;
                    }
                }
            }

            // If all non-mined blocks are revealed, show a pop-up window
            JOptionPane.showMessageDialog(null, "Congratulations! You've won!");

            return true;
        }
    }
}
