import java.math.BigInteger;

public class PE053 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int counter = 0;

		// possible combinations of cards in a poker hand
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (binomialCoefficient(n, r).compareTo(new BigInteger("1000000")) == 1) {
					//System.out.println(n + "¯C_" + r + " = " + binomialCoefficient(n, r));
					counter++;
				}
			}
		}

		System.out.println("Answer: " + counter);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static BigInteger binomialCoefficient(int n, int r) {
		BigInteger coeff = BigInteger.ONE;
		for (int i = n - r + 1; i <= n; i++) {
			coeff = coeff.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= r; i++) {
			coeff = coeff.divide(BigInteger.valueOf(i));
		}
		return coeff;
	}

	
}
