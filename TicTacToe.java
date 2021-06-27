package com.bridgelabz.tictactoegame;

import java.util.Scanner;

/**************************************
 * 
 * @author ANAND 
 * purpose : Workshop of TicTacToeGame 
 * UC-1 create TicTacToeGame Board 
 * UC-2 choose Symbol For Players 
 * UC-3 show TicTacToe Game Board
 * UC-4 Make Player Move to Position
 * UC-5 Check free space before  move
 * UC-6 TOSS TO Check who is playing first
 * UC-7 Check player won the game
 * 
 ****************************************/
public class TicTacToe {

	// declared char array
	static char[] board = new char[10];
	private final static int HEAD = 0;
	private final static int TAIL = 1;

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

	// method to make player to move the position UC-4
	public void playerMakeMove(Scanner input, char playerLetter) {
		boolean isPositionFree;
		int boardLocation;
		do {
			System.out.println("Enter the location (1-9) to put symbol: ");
			boardLocation = input.nextInt();
			isPositionFree = false;
			if (boardLocation >= 1 && boardLocation <= 9) {
				isPositionFree = checkIfPositionFree(boardLocation);
			} else {
				System.out.println("Invalid position entered.");
			}
		} while (!isPositionFree);
		board[boardLocation] = playerLetter;
		showBoard();
	}

	// method checking the place is free or already filled UC-5
	public boolean checkIfPositionFree(int boardLocation) {
		if (board[boardLocation] == ' ') {
			return true;
		} else {
			System.out.println("Already filled");
			return false;
		}
	}

	// method to check which player is first using random number UC-6
	public String checkWhoPlaysFirst() {
		int toss = (int) (Math.random() * 10) % 2;
		if (toss == HEAD) {
			return "Player is first";
		} else if (toss == TAIL) {
			return "Computer is first";
		}
		return null;
	}

	// method to check player wines or change turn UC-7
	public boolean getWinner(char playerSymbol) {
		if ((board[1] == playerSymbol && board[2] == playerSymbol && board[3] == playerSymbol)
				|| (board[4] == playerSymbol && board[5] == playerSymbol && board[6] == playerSymbol)
				|| (board[7] == playerSymbol && board[8] == playerSymbol && board[9] == playerSymbol)
				|| (board[1] == playerSymbol && board[5] == playerSymbol && board[9] == playerSymbol)
				|| (board[3] == playerSymbol && board[5] == playerSymbol && board[7] == playerSymbol)
				|| (board[1] == playerSymbol && board[4] == playerSymbol && board[7] == playerSymbol)
				|| (board[2] == playerSymbol && board[5] == playerSymbol && board[8] == playerSymbol)
				|| (board[3] == playerSymbol && board[6] == playerSymbol && board[9] == playerSymbol))
			return true;

		return false;
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
		String first = tictactoe.checkWhoPlaysFirst();
		System.out.println("here who Plays first: " + first);
		System.out.println("Player Letter is : " + playerLetter);
		System.out.println("Computer Letter is : " + computerSymbol);
		tictactoe.playerMakeMove(sc, playerLetter);
		tictactoe.playerMakeMove(sc, computerSymbol);
		tictactoe.showBoard();
		boolean winner = tictactoe.getWinner(playerLetter);
		while (!winner) {
			tictactoe.playerMakeMove(sc, playerLetter);
			winner= tictactoe.getWinner(playerLetter);
		}
		System.out.println("Congulations Player won ");

	}
}
