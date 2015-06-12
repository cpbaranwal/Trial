package testings;
import java.io.*;

public class TestSerialization {

	/**
	    sample program to test Serialization
	 */
	public static void main(String[] args) 
	{
		Dog d1 = new Dog("vodafone");
		System.out.println();
		
		try
		{
			
			FileOutputStream fos = new FileOutputStream("C:/workspace/Trial/src/testings/serializedFile");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(d1);
			oos.close();
			System.out.println("serialization complete!!");
			
			
			FileInputStream fis = new FileInputStream("C:/workspace/Trial/src/testings/serializedFile");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Dog obj1 = (Dog)ois.readObject();
			ois.close();
			System.out.println(obj1);
			System.out.println("De - serialization complete!!");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
	
	

}
