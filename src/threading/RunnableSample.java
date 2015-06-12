package threading;

public class RunnableSample implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t1 = new ThreadSample();
		Thread t2 = new Thread(new RunnableSample());
		
		t1.start();
		t2.start();

	}

	@Override
	public void run() {
		for(int i=0; i <10; i++)
			{System.out.println("chandan  "+i);
			  try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}
		
	}


