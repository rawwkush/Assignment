package filehandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String s1[] = readFile().split("");
		String s = "";
		for(String temp:s1) {
			switch(temp) {
				case "a":
					s = s+"A";
					break;
				case "e":
					s = s+"E";
					break;
				case "i":
					s = s+"I";
					break;
				case "o":
					s = s+"O";
					break;
				case "u":
					s = s+"U";
					break;
				default: 
					s = s+ temp;
			}
		}
		System.out.println(s);
		writeFile(s);
	}

	private static String readFile() throws FileNotFoundException, IOException {
		String s="";
		try(FileReader fr = new FileReader("abc.txt");){
			int i=0;
			while((i=fr.read())!=-1) {
				s = s+ (char)i;
			}
		}catch(IOException e) {
			System.out.println("Exception:"+ e);
		}
		return s;
	}
	
	private static void writeFile(String s) {
		try(FileWriter fw = new FileWriter("abc.txt");){
			fw.write(s);
		}catch(IOException e) {
			System.out.println("Exception:"+ e);
		}
	
}

}
