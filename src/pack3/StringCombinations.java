package pack3;

public class StringCombinations {

	/**

	 write a program so that it'll find all the possible combinations of a string 
example:if the input is:"abcde"
output would be:"a","b","c","d","e","ab","ac","ad","ae","bc","bd","be","cd","ce","de","abc","abd","abe",...

but if you have already "abc",dont create"cba"

	 */
	public static void main(String[] args) {
		
		String str= "abcd";
		printCombinations(str);

	}
	
	public static void printCombinations(String str)
	{
		if(str==null)
			throw new IllegalArgumentException();
		printCombHelper(" ",str);
	}

	public static void printCombHelper(String prefix, String suffix)
	{
		if(!prefix.trim().isEmpty())
			System.out.println(prefix);
		
		for(int i=0; i<suffix.length(); i++)
		{
			char curr = suffix.charAt(i);
			printCombHelper(prefix+curr, suffix.substring(i+1,suffix.length()));
		}
	}
	
	
}
