import java.math.BigInteger;

public class PE206 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		search(1, 1, 0);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
	
	static void search( int digIx, long pow10, long root ){
	      // get square
	      String s = Long.toString(root*root);
	      // check if all unchangeable digits of square are correct
	      for( int i=0; 2*i+1<digIx ;i++ ){
	         if( s.length()>=2*i+1 && s.charAt(s.length()-2*i-1) != '9'-i ){
	            return;
	         }
	      }

	      // Should have solution by now 
	      if( digIx>9 ){
	         if( s.length() !=17 ) return;
	         // check if all digits of square are correct
	         for( int i=0; i<9 ;i++ ){
	            if( s.charAt(i+i) != '1'+i ){
	               return;
	            }
	         }
	         System.out.println( "Answer: "+root +"0^2 = " + s + "00");
	         return;
	      }

	      // try each next digit
	      for( int v=0; v<=9; v++){ // digit of root
	         search( digIx+1, pow10*10, root + pow10 * v );
	      }
	   }

}
