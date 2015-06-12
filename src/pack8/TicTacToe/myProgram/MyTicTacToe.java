package pack8.TicTacToe.myProgram;
import java.util.*;

public class MyTicTacToe 
{

	private int n ;
	private String [][] arr;
	private List<Player> playerList;
	int currPlayerIndx;
	private int markedIndxCount;
	public static final int DEFAULT_DIMENSION=3;

	//multiple constructors: depends on user whether he wants to use default players list or/and dimension 
	public MyTicTacToe(int n, List<Player> pList) {
		super();
		this.n = n;
		this.arr= new String[n][n];
		if(pList==null)
			pList=defaultPlayerList();
		this.playerList=pList;
		init();//initialisation of values
	}
	public MyTicTacToe(List<Player> pList) {
		this(DEFAULT_DIMENSION,pList);
	}
	public MyTicTacToe(int n) {
		this(n,null);
	}
	public MyTicTacToe() {
		this(DEFAULT_DIMENSION);  //default dimension: 3*3
	}

	private List<Player> defaultPlayerList()  //default playerList:  2 players, will be overriden if user gives his own playerList in constructor
	{
		List<Player> playerList=new ArrayList<Player>(2);
		playerList.add(new Player("chandan", 'x'));
		playerList.add(new Player("shekhar", 'y'));
		return playerList;
	}

	public void setPlayerList(List<Player> playerList)
	{
		this.playerList = playerList;
	}

	public void showPlayers()
	{
		System.out.println("Current players: ");
		for(Player plyr: playerList)
			System.out.println(plyr.toString());
	}

	public void updateCurrentPlayer()//get next player in list
	{
		currPlayerIndx++;
		if(currPlayerIndx >= playerList.size())
			currPlayerIndx = playerList.size()-currPlayerIndx;
	}

	public Player getCurrentPlayer()
	{
		return playerList.get(currPlayerIndx);
	}

	// init method
	private void init()
	{
		currPlayerIndx=0;
		markedIndxCount=0;
		int tmp=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				arr[i][j]= String.valueOf(tmp++);	
		}
	}

	public void printTicTacToe()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print("	 "+arr[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	// reset method
	public void resetTicTacToe()
	{
		System.out.println(" resetting TicTacToe game ......");
		init();
		showPlayers();
		printTicTacToe();
	}

	//mark the index for player
	private boolean markIndxForPlayer(Player p, int num)
	{
		int rowIndx= num/n;
		int colIndx= num%n;
		if(!(arr[rowIndx][colIndx]).equals(String.valueOf(num)))//if already marked by some other player
			return false;
		arr[rowIndx][colIndx]=String.valueOf(p.getChosenChar());
		System.out.println("successfully marked : " +num +" with "+p.getChosenChar());
		markedIndxCount++;
		printTicTacToe();
		return true;
	}



	//check if game is over: case1:: someone wins   case2::all indexes marked
	public boolean isGameOver( int num)
	{
		Player p = getCurrentPlayer();
		//case1
		if(checkForWinner(p,num))
		{
			System.out.println("Congratulations!!!   Found a Winner : "+p);
			printTicTacToe();
			return true;
		}
		else if(markedIndxCount== n*n)//case 2
		{
			System.out.println("Ooops!!!   Game over,No Winner!!");
			return true;
		}
		updateCurrentPlayer();
		return false;
	}


	//method to check whether the current player P after marking position 'num' becomes a winner
	// Optimisation::  called after player P marks position 'num' (markIndxForPlayer returns TRUE), so possibility is player p has won game,....
    //	                  check only rows,columns and diagonal of which 'num' is a part ......no need to scan through remaining rows ,columns,diagonals,etc 
	private boolean checkForWinner(Player p, int num)
	{

		int rowIndx= num/n;
		int colIndx= num%n;
		String charToLook = String.valueOf(p.getChosenChar());
		boolean isPlayerPWinner=true;
		for(int i=0;i<n;i++)//checking all coulmn values for the row value of "num" 
		{
			if(!arr[rowIndx][i].equals(charToLook))
			{
				isPlayerPWinner=false;
				break;
			}
		}
		if(isPlayerPWinner)
			return isPlayerPWinner;

		isPlayerPWinner=true;
		for(int i=0;i<n;i++)//checking all row values for the row value of "num"
		{
			if(!arr[i][colIndx].equals(charToLook))
			{
				isPlayerPWinner=false;
				break;
			}
		}
		if(isPlayerPWinner)
			return isPlayerPWinner;


		if (rowIndx==colIndx)//diagonal
		{
			isPlayerPWinner=true;
			for(int i=0;i<n;i++) 
			{
				if(!arr[i][i].equals(charToLook))
				{
					isPlayerPWinner=false;
					break;
				}
			}
		}
		return isPlayerPWinner;

	}
	public boolean validateAndMarkPosn(Player p, int num)
	{
		if(num<0 || num>=n*n)
			return false;

		return markIndxForPlayer(p,num);
	}




}
