package exercise4;

import java.io.*;



/**
 *  This is the main class where the tic tac toe game starts.
 *  The overall purpose of this exercise is to be able to code classes from reading UML diagram.
 * @author zchem
 *
 */
public class Game implements Constants {
	
	private Board theBoard;
	private Referee theRef;
	/**
	 * Constructor for the class where class object of type Board is created
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    /**
     * This method assigns the local variable {@link #theRef} to the passed @param then invokes
     *  {@link Referee#runTheGame()}
     * @param r its an object of type Referee
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	/**
	 * This is the main function.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// creating local class objects 
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));//prompting user for name
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		//checking validity
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		//initializing Player object and sets the board in player to theBoard
		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");//prompting user for name
		name = stdin.readLine();
		//checking validity
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		//initializing Player object and sets the board in player to theBoard
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		//initializing referee and setting theBoard, oPlayer, and xPlayer in Referee
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
		//start the game
        theGame.appointReferee(theRef);
	}
	

}
