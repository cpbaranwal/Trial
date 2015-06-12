package threading;

public class ThreadSample extends Thread {

	
	
	@Override
	public void run() {
		for(int i=0; i <10; i++)
		{System.out.println("hello  "+i);
		  try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}

	public static void main(String[] args) throws InterruptedException {
		
		
Thread threadSample = new ThreadSample();

threadSample.start();
Thread.sleep(2000);
System.exit(0);
	}

}
