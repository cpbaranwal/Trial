package testings;

import java.lang.reflect.*;

public class TestReflection {

	/**
	 Sample program to test Reflection
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		String str = "chandan";
		//str.length();
		Class clz = Class.forName("java.lang.String");
		
		Method method = clz.getMethod("length", new Class[]{});
		int strLen = (Integer)method.invoke(str, new Object[]{});
		System.out.println("strLen== "+strLen);
		
		Method method2 = clz.getMethod("substring", new Class[]{Integer.TYPE,Integer.TYPE});   // Class Types of parameters (TYPE is basically Class Object) 
		String subStr = (String)method2.invoke(str, new Object[]{1,5}); // parameter values
		System.out.println("subStr== "+subStr);

	}

}
