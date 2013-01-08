public class PE006 {

	public static void main(String[] args) {
		System.out.println("Sum Of Squares: " + sumOfSquares(100));
		System.out.println("Square Of Sum: " + squareOfSum(100));
		System.out.println("The difference: " + (squareOfSum(100) - sumOfSquares(100)));
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
