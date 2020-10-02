package exercise4;

import java.util.Scanner;
/**
 * This class sets the player x and o, prompts the user of each player to enter a place 
 * on the grid to place their mark, then checks if there is any wiinners 
 * @author zchem
 *
 */
public class Player {
private String name;
private Board board;
private Player opponent;
private char mark;
/**
 * Constructor that sets the mark and name of the player
 * @param name
 * @param mark
 */
public Player(String name, char mark) {
this.mark=mark;
this.name=name;

}
/**
 * This method invokes {@link #makeMove()} for current player as long
 * as the board is not full nor there is any winners, otherwise stop announce winner
 * if there is any.
 */
public void play() {
	while( !board.xWins() && !board.oWins() && !board.isFull()) {
		makeMove();
		board.display();
		if(board.xWins()) {
			if(mark=='X')
				System.out.println("Game over!! "+name+" wins");
			else
				System.out.println("Game over!! "+opponent.name+" wins");
				
			break;
		}
		else if (board.oWins()) {
			if(mark=='O')
				System.out.println("Game over!! "+name+" wins");
			else
				System.out.println("Game over!! "+opponent.name+" wins");
			System.out.println("O player wins");
			break;
			
		}
		else if(board.isFull()) {
			System.out.println("It is a tie");
			break;
		}
		opponent.play();
		
	}
	
	
}
/**
 * This method is used to prompt user to where he/she wants to place the mark.
 * Also, checks if a mark already exists, and if the users col,row location is out of bounds
 */
public void makeMove() {
	Scanner scanner =new Scanner(System.in);
	System.out.println(name+", what row should your next "+mark+" be placed in ?");
	int row=scanner.nextInt();
	System.out.println(name+", what column should your next "+mark+" be placed in ?");
	int col =scanner.nextInt();
	if((row>=0 && row<=2)&&((col>=0 && col<=2))) {
	if (board.getMark(row, col)==' ' ) {
		 {
			board.addMark(row, col, mark);	
		}
		
	
	}
	else {
		System.err.println("There is a mark there, choose another location");
		makeMove();
	}
	}
	else {
		System.err.println("Out of bounds please try again!!");
		makeMove();
	}
}
/**
 * Setter for {@link #opponent}
 * @param opponent
 */
public void setOpponent (Player opponent) {
	this.opponent=opponent;
}
/**
 * Setter for {@link #board}
 * @param theBoard
 */
public void setBoard(Board theBoard) {
	this.board=theBoard;
}
}
