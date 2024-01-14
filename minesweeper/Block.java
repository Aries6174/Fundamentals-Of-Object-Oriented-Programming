//Block.java
// Has all the properties of of each blocks in the grid.
package minesweeper;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Block extends JButton {
    private static final long serialVersionUID = 1L;

    int row;
    int col;
    // three types of block
    boolean isShow, isMined, isFlag;

    // Colors and Fonts of the Block
    public static final Color bNotShow = Color.WHITE;
    public static final Color fNotShow = Color.RED;
    public static final Color bShow = Color.DARK_GRAY;
    public static final Color fShow = Color.YELLOW;
    public static final Font fontNumber = new Font("Times New Roman", Font.BOLD, 20);

    // THe new game function
    public void newGame(boolean isMined) {
        this.isShow = false;
        this.isMined = isMined;
        this.isFlag = false;

        super.setEnabled(true);
        super.setText("");
        paint();
    }

    // set that specific block to be a mine
    public void setMine(boolean isMined) {
        this.isMined = isMined;
    }

    // display the text in that block
    public void paint() {
        if (isFlag) {
            setText(">");
        } else {
            super.setForeground(isShow ? fShow : fNotShow);
            super.setBackground(isShow ? bShow : bNotShow);
        }
    }

    // Sets the amount of blocks to exist in the program
    public Block(int row, int col) {
        super();
        this.row = row;
        this.col = col;
        super.setFont(fontNumber);
    }

    // Checks if that specific block is flagged
    public boolean isFlag() {
        return isFlag;
    }

    // Flags the block to be flagged
    public void setFlag(boolean flag) {
        isFlag = flag;
        System.out.println("Block flagged: " + flag); // prints it out in the terminal if it is flagged
    }

}
