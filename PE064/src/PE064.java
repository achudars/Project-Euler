public class PE064 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int continuedFractions = 0;
		int limit = 10000;

		for (int n = 2; n <= limit; n++) {
			int at = (int) Math.sqrt(n);
			if (at * at == n) {
				continue;
			}

			int oddPeriod = 0;
			int d = 1;
			int m = 0;
			int a = at;

			do {
				m = d * a - m;
				d = (n - m * m) / d;
				a = (at + m) / d;
				oddPeriod++;
			} while (a != 2 * at);

			if (oddPeriod % 2 == 1) {
				continuedFractions++;
			}

		}
		System.out.println("Answer: " + continuedFractions);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
