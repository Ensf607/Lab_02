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
public void makeMove() {
	Scanner scanner =new Scanner(System.in);
	System.out.println(name+", what row should your next"+mark+" be placed in ?");
	int row=scanner.nextInt();
	System.out.println(name+", what column should your next"+mark+" be placed in ?");
	int col =scanner.nextInt();
	if (board.getMark(row, col)==' ') {
		board.addMark(row, col, mark);
	}
	else {
		System.err.println("There is a mark there, choose another location");
		makeMove();
	}
	
}
public void setOpponent (Player opponent) {
	this.opponent=opponent;
}
public void setBoard(Board theBoard) {
	this.board=theBoard;
}
}
