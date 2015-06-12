package testings;
import java.util.*;
public enum EnumPlanet {
	
	MERCURY(1,2),
	VENUS(3,4),
	EARTH(5,6),
	MARS(6,7),
	JUPITER(8,9);
	
	int mass;
	int radius;
	EnumPlanet(int mass, int radius)
	{
		this.mass = mass;
		this.radius = radius;
	}
	
	public static void main(String[] args)
	{
		System.out.println("in  main");
		System.out.println(EnumPlanet.EARTH+ "   EnumPlanet.EARTH.mass="+EnumPlanet.EARTH.mass);
		EnumPlanet.EARTH.mass=10;
		
		System.out.println(EnumPlanet.EARTH+ "   EnumPlanet.EARTH.mass="+EnumPlanet.EARTH.mass);
		for(EnumPlanet ep : EnumPlanet.values())
		{
			System.out.println("ep:  "+ep);
			System.out.println("ep.ordinal():  "+ep.ordinal());
		}
		System.out.println(EnumPlanet.valueOf("EARTH"));
		
		EnumMap<EnumPlanet,Integer>  enumMap = new EnumMap<EnumPlanet,Integer> (EnumPlanet.class);
		System.out.println(enumMap.size());
	}

}
