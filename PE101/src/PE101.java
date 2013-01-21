public class PE101 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// Generate the generator polynomial
		long[] coefficients = { 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1 };
		Polynomial poly = new Polynomial(coefficients);

		// Generate the points
		long[] y = new long[coefficients.length];
		for (long i = 0; i < y.length; i++) {
			y[(int) i] = poly.evaluate(i + 1);
		}

		long fits = 0;
		for (long n = 1; n <= coefficients.length - 1; n++) {
			long result = 0;
			for (long i = 1; i <= n; i++) {

				long temp1 = 1;
				long temp2 = 1;

				for (long j = 1; j <= n; j++) {
					if (i == j) {
						continue;
					} else {
						temp1 *= n + 1 - j;
						temp2 *= i - j;
					}
				}
				result += temp1 * y[(int) (i - 1)] / temp2;
			}

			fits += result;
		}

		System.out.printf("Answer: %d", fits);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static class Polynomial {

		private long[] coefficients;
		public long Degree;

		public Polynomial(long deg) {
			Degree = deg;
			coefficients = new long[(int) (deg + 1)];
		}

		public Polynomial(long[] coefficients) {
			Degree = coefficients.length - 1;
			this.coefficients = coefficients;
		}

		public long get(long i) {
			return coefficients[(int) i];
		}

		public void set(long i, long value) {
			coefficients[(int) i] = value;
		}

		public long evaluate(long x) {
			long result = 0;

			for (long i = this.Degree; i >= 0; i--) {
				result = result * x + get(i);
			}
			return result;
		}

	}

}
