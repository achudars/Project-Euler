public class PE156 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long[] sums = new long[11];
		int[] digits = new int[12];
		long[] totsums = new long[11];

		for (long n = 0; n < 99999999999L;) {
			long mindiff = Long.MAX_VALUE;

			for (int d = 1; d <= 9; d++) {
				long diff = Math.abs(sums[d] - n + 1);
				if (diff == 0) {
					totsums[d] += n - 1;
					System.out.println("d=" + d + " n=" + (n - 1));
				}
				mindiff = Math.min(diff, mindiff);
			}

			if (mindiff > 1500000L && n % 1000000 == 0)
				n = stepN(n, 1000000, 6, sums, digits);
			else if (mindiff > 1500L && n % 1000 == 0)
				n = stepN(n, 1000, 3, sums, digits);
			else
				n = stepN(n, 1, 0, sums, digits);
		}

		long s = 0;
		for (int i = 1; i <= 9; i++) {
			System.out.println("Total sum for " + i + " = " + totsums[i]);
			s += totsums[i];
		}
		System.out.println("Answer: " + s);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	private static long stepN(long n, int N, int logN, long[] sums, int[] digits) {
		for (int d = logN; d <= 11; d++)
			sums[digits[d]] += N;
		int add = logN * N / 10;
		if (add > 0)
			for (int i = 1; i <= 9; i++)
				sums[i] += add;
		n += N;
		for (int d = logN; d < 11; d++)
			if (digits[d] == 9)
				digits[d] = 0;
			else {
				digits[d]++;
				break;
			}
		return n;
	}

}
