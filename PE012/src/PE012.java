public class PE012 {

	public static void main(String[] args) {
		for (int i = 1; i < 100000; i++) {
			if (countFactors(calculateTriangle(i)) > 500) {
				System.out.println(i + " : " + calculateTriangle(i)
						+ " | Number of factors: "
						+ countFactors(calculateTriangle(i)));
				break;
			}
		}
	};

	// prime number checking function
	public static int calculateTriangle(int naturalNumber) {
		int triangle = 0;

		for (int i = 1; i <= naturalNumber; i++) {
			triangle += i;
		}
		return triangle;
	};

	// function that counts factors
	public static int countFactors(int number) {
		int factors = 0;

		for (int i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				factors += 2;
		}

		return factors;
	};

}
