package com.sudoku.sudokusolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SudokusolverApplication {

	// Testing ssh
	public static void main(String[] args) {
		SpringApplication.run(SudokusolverApplication.class, args);
		Sudoku sudo = new Sudoku();
		sudo.printBoard();
		sudo.sudokuGameSolve();
		sudo.printBoard();
	}

}
