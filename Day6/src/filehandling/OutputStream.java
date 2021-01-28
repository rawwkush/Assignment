package filehandling;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {

	public static void main(String[] args) {
		writeFile();
		try {
			readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("fiel not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("io problem");
			e.printStackTrace();
		}
		
	}
	
	private static String readFile() throws FileNotFoundException, IOException {
		String s="";
		
		
		
		/*
		 * 
		 *  try block with resources as argument 
		 *  ensures that each resource is closed at the end
		 *  it implicitly creates a finally block and closes resources there
		 * 
		 * 
		 */
		
		try(FileInputStream fr = new FileInputStream("test.txt");){
			int i=0;
			while((i=fr.read())!=-1) {
				s = s+ (char)i;
			}
		}catch(IOException e) {
			System.err.println("Exception:"+ e);
		}
		return s;
	}
	
	private static void writeFile() {
		try(FileOutputStream fw = new FileOutputStream("test.txt");){
			String s3 = "This is sample data";
			fw.write(s3.getBytes());
		}catch(IOException e) {
			System.err.println("Exception:"+ e);
		}
	}
}
