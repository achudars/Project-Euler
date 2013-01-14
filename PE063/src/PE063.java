import java.math.BigInteger;

public class PE063 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int counter = 0;

		// get the number 2^1000
		BigInteger number = BigInteger.ZERO;
		// number = number.pow(1000);
		// convert to string
		// String theNumber = number.toString();

		for (Integer integer = 1; integer < 100; integer++) {
			for (Integer n = 1; n < 100; n++) {
				number = number.valueOf(integer);
				if (String.valueOf(number.pow(n)).length() == n) {
					System.out.println(number.pow(n) + "=" + integer + "^" + n);
					counter++;
				}

			}
		}

		System.out.println("Answer: " + counter);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	};

}