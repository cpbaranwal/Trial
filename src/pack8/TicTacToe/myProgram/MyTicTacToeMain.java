package pack8.TicTacToe.myProgram;

/**
 Problem Statement: (Flipkart Interview)
  Design and build tic tac toe game. The code should be up and running. 
  It should be scalable to multi-users and nXn grid.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import pack8.TicTacToe.TicTacToe;

//main class to run TicTacToe game
public class MyTicTacToeMain {

	public static void main(String[] args) throws Exception 
	{

		System.out.println(" Welcome to TicTacToe game.....please provide your Player details and dimension otherwise default will be used:");

		/**  Takin player details and dimension details are optional **/
		//Taking player details from user
		System.out.println("Do you want to enter your player names : (y/n)");//e.g. y
		String wishPlayer = reader.readLine().trim();
		if(wishPlayer.equalsIgnoreCase("y"))
		{
			System.out.println("Enter number of players  (e.g. 3):");
			Integer numPlayers = Integer.parseInt(reader.readLine());
			pList= new ArrayList<Player>(numPlayers);
			for(int i=0;i<numPlayers;i++)
			{
				System.out.println("Enter name of player"+(i+1)+" (e.g. chandan) : ");//
				String name = reader.readLine();
				System.out.println("Enter symbol for player  (e.g. x) :"+name);//
				Character symbol = reader.readLine().trim().charAt(0);  //will be considering only first char as symbol
				pList.add(new Player(name,symbol));
			}
		}

		//Taking dimension detail for TicTacToe from user
		System.out.println("Do you want to enter your dimension  for the game : (y/n)");//e.g. n
		String wishDim = reader.readLine().trim();
		if(wishDim.equalsIgnoreCase("y"))
		{
			System.out.println("Enter dimension of TicTacToe (e.g. for 3*3,enter 3:");
			dimension = Integer.parseInt(reader.readLine());
		}

		//start playing game now
		playGame();

	}

	private static final BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
	private static List<Player> pList=null; 
	private static int dimension=MyTicTacToe.DEFAULT_DIMENSION;
	private static void playGame() throws IOException,Exception
	{
		boolean keepPlaying=true;
		MyTicTacToe ticTac = new MyTicTacToe(dimension,pList);
		ticTac.printTicTacToe();//print the initial state

		while(keepPlaying)
		{
			Player p = ticTac.getCurrentPlayer();
			System.out.println(" Choose a position for player :"+p);
			Integer posn = Integer.parseInt(reader.readLine());
			while(!ticTac.validateAndMarkPosn(p,posn) )//ask user repeatedly until he chooses a valid available posn to be filled
			{
				System.out.print("please enter a valid available position :");
				posn = Integer.parseInt(reader.readLine());
				System.out.println();
			}
			if(ticTac.isGameOver(posn))
			{
				keepPlaying=false;
			}
		}
		reader.close();	
	}

}
