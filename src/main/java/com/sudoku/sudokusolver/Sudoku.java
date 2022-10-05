package com.sudoku.sudokusolver;

import java.util.Arrays;

public class Sudoku {

    private static final int NO_VALUE = 0;
    private static final int BOARD_SIZE = 9;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    public int[][] board = {
            {9,0,0,1,0,0,0,0,5},
            {0,0,5,0,9,0,2,0,1},
            {8,0,0,0,4,0,0,0,0},
            {0,0,0,0,8,0,0,0,0},
            {0,0,0,7,0,0,0,0,0},
            {0,0,0,0,2,6,0,0,9},
            {2,0,0,3,0,0,0,0,6},
            {0,0,0,2,0,0,9,0,0},
            {0,0,1,9,0,4,5,7,0}
    };

    public void printBoard() {
        System.out.println("\n" + "_".repeat(27));
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    // This is the main game where the solver is called
    public void sudokuGameSolve() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int colum = 0; colum < BOARD_SIZE; colum++) {
                if (board[row][colum] == NO_VALUE) {
                    //TODO fi this for loop
                    for(int number =1; number <= MAX_VALUE; number++){
                        if(mainChecker(row,colum,number)){
                            board[row][colum] = number;
                        }
                    }
                }
            }
        }
    }

    private boolean mainChecker(int row, int colum, int number){
        return !checkInRow(row, number) && !checkInColum(colum, number) && !checkInBox(row, colum, number);
    }

    public boolean checkInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInColum(int colum, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][colum] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInBox(int row, int colum, int number) {
        int smallRow = row - 9 % 3;
        int smallCol = colum - 9 % 3;

        for (int i = 0; i < smallRow; i++) {
            for (int j = 0; j < smallCol; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
