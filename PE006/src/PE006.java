public class PE006 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		System.out.println("Sum Of Squares: " + sumOfSquares(100));
		System.out.println("Square Of Sum: " + squareOfSum(100));
		System.out.println("Answer (difference): " + (squareOfSum(100) - sumOfSquares(100)));
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	};

	// The sum of the squares of the first n natural numbers
	public static int sumOfSquares(int number) {
		int sum = 0;
		for(; number > 0 ; number-- ){
			sum +=(number*number);
		}
		return sum;
	};

	// The square of the sum of the first n natural numbers
	public static int squareOfSum(int number) {
		int sum = 0;
		for(; number > 0 ; number-- ){
			sum +=number;
		}
		return sum*sum;
	};

}
