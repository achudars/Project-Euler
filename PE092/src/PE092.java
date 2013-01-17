public class PE092 {

	static int numbers[]=new int[10000000];
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int arrived=0;
	      for (int i=1; i<10000000; i++){
	         int squareOfDigits=arrivesAt(i);
	         while (squareOfDigits!=1 && squareOfDigits!=89)
	            squareOfDigits=arrivesAt(squareOfDigits);
	         if (squareOfDigits==89) {
	            numbers[i]=89;
	            arrived++;
	         }
	         else numbers[i]=1;
	      }
	      System.out.println(arrived);
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
	private static int arrivesAt(int nr){
	      if (numbers[nr]==89) return 89;
	      if (numbers[nr]==1) return 1;
	      String string=new Integer(nr).toString();
	      int a=0;
	      for (int i=0; i<string.length(); i++){
	         int b=new Integer(string.substring(i,i+1)).intValue();
	         a+=b*b;
	      }
	      return a;
	   }

}
