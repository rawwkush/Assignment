
public class MyString {

	
	private String s;

	public MyString() {
		super(); // constructor of Object class 
	}
	
	public MyString(String s) {
		super();
		this.s = s;
	}
	
	//Make First letter of a string capital without using replace()
	
	public String makeFirstWordCapital(String s) {
		//String s="hello world";
		String newString="";
		String[] ar = s.split(" ");
		for(String temp:ar) {
			newString += temp.substring(0, 1).toUpperCase() + temp.substring(1,temp.length())+" ";
		}
		return newString;
	}
	
	public String makeFirstLetterCapital(String s) {
		String newString= s.substring(0,1).toUpperCase() + s.substring(1,s.length());
		return newString;
	}
	
	public boolean findLetter(String s, String c) {
		if(s=="") {
			return false;
		}
		String[] S=s.split("");
		for(String temp:S) {
			if(temp == c) {
				return true;
			}
		}
		return false;
	}
	
	public String frequencyCount(String s) {
		String[] S = s.split("");
		String visited="";
		int[] freq=new int[100];
		int c=0;
		for(String temp:S) {
			if(findLetter(visited,temp)) {
				freq[visited.indexOf(temp)] = freq[visited.indexOf(temp)] +1;  
			}
			else {
				freq[c] = 1;
				visited += temp;
			}
			c++;
		}
		
		return "";
	}
	
	public String makeWordReverse(String s) {
		String newString="";
		String[] ar = s.split(" ");
		
		for(String temp:ar) {
			newString += reverseString(temp)+" ";
		}
		
		return newString;
	}
	
	public String reverseString(String s) {
		String rev="";
		for(int i=0;i<s.length();i++)
			rev=s.charAt(i)+rev;
		return rev;
	}
	
	
}
