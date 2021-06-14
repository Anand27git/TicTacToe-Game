package com.bridgelabz.tictactoegame;

import java.util.Scanner;

/**************************************
 * 
 * @author ANAND
 * purpose : Workshop of TicTacToeGame 
 * UC-1 create TicTacToeGame Board 
 * UC-2 choose Symbol For Players 
 * UC-3 show TicTacToe Game Board
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

	// ask Player to choose either X or O UC-2
	public char chooseSymbolForPlayer(char playerLetter) {
		char computerLetter = ' ';
		if (playerLetter == 'X' || playerLetter == 'x') {
			computerLetter = 'O';
		} else if (playerLetter == 'O' || playerLetter == 'o') {
			computerLetter = 'X';
		}
		return computerLetter;
	}

	// method to show the board UC-3
	public void showBoard() {
		System.out.println("Current TicTacToe Game Board: ");
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println(" ------- ");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println(" ------- ");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	public static void main(String args[]) {
		System.out.println("Welcome to TicTocToe Game ");
		// creating object for create board
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.createBoard();
		System.out.println("Enter the symbol X or O:");
		Scanner sc = new Scanner(System.in);
		char playerLetter = sc.next().charAt(0);
		char computerSymbol = tictactoe.chooseSymbolForPlayer(playerLetter);
		System.out.println("Player Letter is : " + playerLetter);
		System.out.println("Computer Letter is : " + computerSymbol);
		tictactoe.showBoard();
	}
}
