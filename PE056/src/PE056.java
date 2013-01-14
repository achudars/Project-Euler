import java.math.BigInteger;

public class PE056 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		BigInteger sumOfDigits = BigInteger.ZERO;
		BigInteger number = BigInteger.ONE;
		BigInteger maxDigitSum = BigInteger.ZERO;
		BigInteger A = BigInteger.ZERO;
		BigInteger B = BigInteger.ZERO;

		for (int a = 2; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				sumOfDigits = BigInteger.ZERO;
				number = (BigInteger.valueOf(a)).pow(b);
				// convert to string
				String numberAsString = number.toString();
				// traverse every character in the string array and calculate
				// value
				for (char c : numberAsString.toCharArray()) {
					sumOfDigits = sumOfDigits.add(BigInteger.valueOf(Character
							.getNumericValue(c)));
				}
				// if the new digit sum is larger than the largest so far found
				if (sumOfDigits.compareTo(maxDigitSum) == 1) {
					maxDigitSum = sumOfDigits.add(BigInteger.ZERO);
					A = BigInteger.valueOf(a);
					B = BigInteger.valueOf(b);
					// System.out.println("maxDigitSum: " + maxDigitSum
					// +" sumOfDigits: " + sumOfDigits + " for " + A + "^"+ B+
					// "="+ ((BigInteger.valueOf(a)).pow(b)));
				}
			}
		}

		System.out.println("Answer: " + maxDigitSum + " for a=" + A + ", b="
				+ B);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
