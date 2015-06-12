package pack8.TicTacToe.myProgram;


//bean class to store name of player and symbol which he uses to play game
public class Player 
{
	String name;
	Character chosenChar;

	public Player(String name, char chosenChar) {
		super();
		this.name = name;
		this.chosenChar = chosenChar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getChosenChar() {
		return chosenChar;
	}

	public void setChosenChar(char chosenChar) {
		this.chosenChar = chosenChar;
	}

	@Override
	public String toString() {
		return  name + " [symbol=" + chosenChar+"]" ;
	}






}
