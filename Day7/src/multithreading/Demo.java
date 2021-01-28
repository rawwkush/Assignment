package multithreading;

public class Demo {
	 public static void main(String[] args) {
		 
		 /*
		  * Multithreading using inheritance of Thread class
		  */
		 MyThread ob1= new MyThread();
		 MyThread obj2= new MyThread();
		 ob1.start();
		 obj2.start();
		 
		 
		 
	}
}
