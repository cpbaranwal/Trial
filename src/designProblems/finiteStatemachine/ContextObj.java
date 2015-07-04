package designProblems.finiteStatemachine;

public class ContextObj 
{
	String input="";
	private int currIndex=0;
	public static final char END = 0;//will mark that the input has been completely traversed
	
	public ContextObj(String input) {
		this.input = input;
	}
	
	public char read()
	{
		char ch = (currIndex < input.length()) ? input.charAt(currIndex++) : END;
		return ch;
	}
	
	
}
