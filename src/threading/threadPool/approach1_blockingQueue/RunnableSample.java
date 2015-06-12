package threading.threadPool.approach1_blockingQueue;



public class RunnableSample implements Runnable {

	String str;
	
	
	
	public RunnableSample(String str) {
		super();
		this.str = str;
	}



	@Override
	public void run() {
		for(int i=0; i <10; i++)
			{System.out.println("executing: "+str);
			 for(int j=0;j<500000;j++);//doing some processing
			}
			}
		
	}


