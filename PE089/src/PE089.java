import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PE089 {

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();

//				I = 1
//				V = 5
//				X = 10
//				L = 50
//				C = 100
//				D = 500
//				M = 1000
		
		String[] romans = new String[] {
	            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	      int[] vals = new int[] {
	            1000, 900, 500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1};
	      BufferedReader buff=new BufferedReader(new FileReader("src/roman.txt"));
	      int saved = 0;
	      
	      try {
			while(buff.ready()) {
			     String s=buff.readLine();
			     int pointer=0;
			     int val=0;
			     for (int i = 0; i < romans.length; i++) {
			        while (s.startsWith(romans[i], pointer)) {
			           val += vals[i];
			           pointer += romans[i].length();
			        }
			     }
			     
			     String str="";
			     for (int i = 0; i < romans.length; i++) {
			        while (val >= vals[i]) {
			           val -= vals[i];
			           str += romans[i];
			        }
			     }
			     saved += s.length()-str.length();
			  }
		} catch (IOException e) {

			e.printStackTrace();
		}
	      System.out.println("Answer: " + saved);
		
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
}
