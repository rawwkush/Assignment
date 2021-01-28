package multithreading;

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
