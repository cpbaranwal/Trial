package testings;

public class TradingSystem {

    private  String category = "electronic trading system";
    
    public  TradingSystem() 
    {
    	/*
    	if(this.getClass()!=TradingSystem.class)
    		throw new RuntimeException("SubClassing not possible!!");
    	*/
    	
    }
    
    /*public static TradingSystem createObj(String str)
    {
    	TradingSystem obj=new TradingSystem(str);
    	return obj;
    }*/
    
    public static void main(String[] args) {
        //TradingSystem system = new SubTradingSystem();
        
        //System.out.println(system.category);
    }
    
    public  static  void printCategory(){
        System.out.println("inside super class static method");
    }

}