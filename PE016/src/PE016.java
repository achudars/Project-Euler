import java.math.BigInteger;

public class PE016 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int sumOfDigits = 0;
		// get the number 2^1000
		BigInteger number = new BigInteger("2");
		number = number.pow(1000);
		// convert to string
		String theNumber = number.toString();
		// traverse every character in the string array and calculate value
		for (char a : theNumber.toCharArray()) {
			sumOfDigits = sumOfDigits + Character.getNumericValue(a);
		}

		System.out.println("Answer: " + sumOfDigits);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	};
}