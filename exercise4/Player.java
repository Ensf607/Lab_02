package exercise4;

import java.util.Scanner;

public class Player {
private String name;
private Board board;
private Player opponent;
private char mark;
public Player(String name, char mark) {
this.mark=mark;
this.name=name;

}
public void play() {
	while( !board.xWins() && !board.oWins() && !board.isFull()) {
		makeMove();
		board.display();
		if(board.xWins()) {
			System.out.println("X player wins");
			break;
		}
		else if (board.oWins()) {
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
public void makeMove() {
	Scanner scanner =new Scanner(System.in);
	System.out.println(name+", what row should your next"+mark+" be placed in ?");
	int row=scanner.nextInt();
	System.out.println(name+", what column should your next"+mark+" be placed in ?");
	int col =scanner.nextInt();
	board.addMark(row, col, mark);
}
public void setOpponent (Player opponent) {
	this.opponent=opponent;
}
public void setBoard(Board theBoard) {
	this.board=theBoard;
}
}
