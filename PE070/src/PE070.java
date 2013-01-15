import java.util.Arrays;

public class PE070 {

	private static final int LIMIT = byThePower(10, 7);

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[] totients = listTotients(LIMIT);

		int minNumerator = 1; // Dummy initial values
		int minDenominator = 0;
		for (int i = 2; i < LIMIT; i++) {
			int totient = totients[i];
			if ((long) i * minDenominator < (long) minNumerator * totient
					&& hasSameDigits(i, totient)) {
				minNumerator = i;
				minDenominator = totient;
			}
		}
		System.out.println("Answer: " + Integer.toString(minNumerator));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static boolean hasSameDigits(int x, int y) {
		char[] xdigits = Integer.toString(x).toCharArray();
		char[] ydigits = Integer.toString(y).toCharArray();
		Arrays.sort(xdigits);
		Arrays.sort(ydigits);
		return Arrays.equals(xdigits, ydigits);
	}
	
	public static int[] listTotients(int n) {
		int[] totients = new int[n + 1];
		for (int i = 0; i <= n; i++)
			totients[i] = i;

		for (int i = 2; i <= n; i++) {
			if (totients[i] == i) {  // i is prime
				for (int j = i; j <= n; j += i)
					totients[j] = totients[j] / i * (i - 1);
			}
		}
		return totients;
	}

	
	public static int byThePower(int x, int y) {
		if (y < 0)
			throw new IllegalArgumentException("Negative exponent");
		int z = 1;
		for (int i = 0; i < y; i++)
			z *= x;
		return z;
	}
}
