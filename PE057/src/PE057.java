import java.math.BigDecimal;

public class PE057 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int limit = 1000;
		int result = 0;

		BigDecimal den = new BigDecimal("2");
		BigDecimal num = new BigDecimal("3");

		for (int i = 2; i < limit; i++) {

			num = num.add(den.multiply(BigDecimal.valueOf(2)));
			den = num.subtract(den);

			int numberLength = (num.toString()).length();
			int denominatorLength = (den.toString()).length();

			// if number of digits in the upper number is higher than in the
			// denominator, increment the result
			if (numberLength > denominatorLength) {
				result++;
			}
		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
