// Map.java
// This contains the number of Mines that will be placed in the grid, these maps are randomly placed.
package minesweeper;

import static minesweeper.rowsAndColumns.rows;
import static minesweeper.rowsAndColumns.cols;

import java.util.Random;

public class Map {
    boolean[][] isMined = new boolean[rows][cols];
    int numOfMines;

    // Method that creates a new map
    public void newMap(int numOfMines) {
        this.numOfMines = numOfMines;
        placeMines();
    }

    // Places the mines randomly in the grid
    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < numOfMines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (!isMined[row][col]) {
                isMined[row][col] = true;
                minesPlaced++;
            }
        }
    }
}
