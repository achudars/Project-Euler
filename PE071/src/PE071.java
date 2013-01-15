public class PE071 {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		double f37 = 3.0 / 7;
		double minDifference = 1;
		double tempFraction = 0;
		double tempDifference = 0;
		int numerator = 0, denominator = 0;

		// find the closest fraction to 3/7 to the left
		for (int i = 8, j = 1; i < 1000000; ++i, ++j) {
			if (j == 7) {
				j = 0;
				continue;
			}

			tempFraction = ((double) (i * 3 / 7)) / i;
			tempDifference = f37 - tempFraction;

			if (tempDifference < minDifference) {
				minDifference = tempDifference;
				denominator = i;
			}
		}

		// calculate numerator from denominator
		numerator = denominator * 3 / 7;

		System.out.println("Fraction: " + numerator + "/" + denominator);
		System.out.println("Answer: " + numerator);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static boolean isReducedProperFraction(int n, int d) {
		if (n < d && gcd(n, d) == 1) {
			return true;
		}
		return false;
	}

	public static int gcd(int n, int d) {
		while (d != 0) {
			int t = d;
			d = n % d;
			n = t;
		}
		return n;
	}

}
