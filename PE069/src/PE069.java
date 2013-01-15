public class PE069 {

	private static final int LIMIT = 1000000;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int result = 0;
		double best = 0;
		// sieve of Eratosthenes
		final double[] s = new double[LIMIT + 1];

		for (int i = 2; i <= LIMIT; i += 1) {
			final double sieve = s[i];
			double r = 0;
			if (sieve == 0) {
				r = i - 1;
				final double x = 1d - (1d / (double) i);
				for (int j = (i + i); j <= LIMIT; j += i) {
					final double sj = s[j];
					s[j] = (sj == 0) ? sj + x : sj * x;
				}
			} else {
				r = sieve * i;
			}
			// s[i] = ((double)i)/r;
			r = ((double) i) / r;
			if (r > best) {
				best = r;
				result = i;
			}
			// System.out.println(i + "    " + s[i]);

		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static double getTotientRatio(int p_x) {
		double l_ratio = 1;
		int x = p_x;
		for (int i = 2; i <= x; i++) {
			if (x % i == 0) {
				l_ratio *= i / (double) (i - 1);
				while (x % i == 0) {
					x /= i;
				}
			}
		}
		return l_ratio;
	}

}
