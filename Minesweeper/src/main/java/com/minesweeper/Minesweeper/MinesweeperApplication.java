package com.minesweeper.Minesweeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinesweeperApplication {

	public static void main(String[] args) {
		Game newGame = new Game();
		Board gameBoard = newGame.start();
		newGame.otherRounds(gameBoard);
	}

}
