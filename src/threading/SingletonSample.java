package threading;

public class SingletonSample {

    /**
        This program shows how to create singleton.
        two approaches:
        1.  DCL
        2.  classHolder

     */
    public static void main(String[] args)
    {
       
        Thread t1 = new Thread( new Runnable(){
            public void run()
            {
                System.out.println("thread call1 : going to call SingletonSample.getInstance()= "+SingletonSample.getInstance());
            }
        });
        Thread t2 = new Thread( new Runnable(){
            public void run()
            {
                System.out.println("thread call2 : going to call SingletonSample.getInstance()= "+SingletonSample.getInstance());
            }
        });
        Thread t3 = new Thread( new Runnable(){
            public void run()
            {
                System.out.println("thread call3 : going to call SingletonSample.getInstance()= "+SingletonSample.getInstance());
            }
        });
       
       
        t1.start();
        t2.start();
        t3.start();
       
    }
   
   
    private static  SingletonSample object;
    private SingletonSample()
    {
        System.out.println("Singleton Object created");
    }
   
   
    
    //1st appproach
    public static SingletonSample getInstance2()   //Double Checked Locking
    {
        System.out.println("in  getInstance()");
        if(object==null)
        {
            synchronized(SingletonSample.class)
            {
                 if(object==null)  //check after commenting this line, multiple objects will be created
                    object = new SingletonSample();
            }
           
        }
        return object;
    }
   
   
    //2nd approach
    private static class Holder
    {
        static SingletonSample obj =new SingletonSample();
    }
    public static SingletonSample getInstance()  //using classHolder, jvm synchronizes while loading classHolder
    {
        //imp- using classHolder; using lazy loading like DCL but without synchronization like static eager loading
        System.out.println("in  getInstance()");
        return Holder.obj;
       
    }
   

}