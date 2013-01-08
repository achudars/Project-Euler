public class PE014 {

	public static void main(String[] args) {
		
		int longestChain = 0;
		int startingNumber = 0;
		
		long number;
		int chainLength;
		
		
		for(int i = 1; i < 1000000; i++) {
			number = i;
			chainLength = 1;
			
			while( number != 1 ) {
				// n -> n/2 (n is even)
				// n -> 3n + 1 (n is odd)
				// if number is odd [===number & 1] then then [(3n+1)===(3*number+1)] else [(n/2)===(number>>1)]
				number = ((number & 1) == 1) ? (3 * number + 1) : (number >> 1);
				
				chainLength++;
			}
			if(chainLength > longestChain) {
				longestChain = chainLength;
				startingNumber = i;
			}
		}
		System.out.println(startingNumber);
		
	}
}
