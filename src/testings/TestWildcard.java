package testings;
import java.util.*;

public class TestWildcard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("in main");
		
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(12);
		
		addElement(l1,10);
		
		System.out.println("list l1:"+l1);
		System.out.println(getElement(l1,0));
	}
	
	//CONSUMER   --> super
	public static void addElement(List<? super Integer> list, int obj)
	{
		//Integer num = 10;
		//Number num = 11;
		list.add(obj);
		
		//list.add(num);
	}
	
	//PRODUCER --> extends
	public static int getElement(List<? extends Integer> list,int index)
	{
		//Integer num = 10;
		//Number num = 11;
		int num = list.get(index);
		return num;
		//list.add(num);
	}
	
	
	
	public static void method1(List<? super Object> list1, Object obj)
	//public static void method1(List<? extends Object> list1, Object obj)
	//public static void method1(List<? > list1, Object obj)
	//public static void method1(List list1, Object obj)
	{
		//Integer num = (Integer)(obj);
		list1.add(obj);
	}
	

}
