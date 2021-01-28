package assignment;

public class TableClass  implements Runnable{
	
	int a;
	public TableClass( int a) {
		// TODO Auto-generated constructor stub
		this.a=a;
	}
	
	public synchronized void printTable(int num) {

		for (int i = 1; i <= 10; i++) {
			Thread t = Thread.currentThread();
			System.out.println(t.getName() + " :" + (num * i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		printTable(a);
	}
	
	

}
