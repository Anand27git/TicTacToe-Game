package com.bridgelabz.tictactoegame;

/**************************************
 * 
 * @author ANAND 
 * purpose : Workshop of TicTacToeGame 
 * UC-1 create TicTacToeGame Board
 *
 ****************************************/
public class TicTacToe {

	// declared char array
	char[] board = new char[10];

	// method to create Board UC-1
	public void createBoard() {

		for (int position = 1; position < board.length; position++) {
			board[position] = ' ';
		}
	}

	public static void main(String args[]) {
		System.out.println("Welcome to TicTocToe Game ");
		// creating object for create board
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.createBoard();
	}
}