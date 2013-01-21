public class PE113 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int N = 100;
		long[] sums1 = new long[10];
		long[] sums2 = new long[10];

		for (int i = 0; i < 10; i++)
			sums1[i] = 1;
		sums2[0] = 0;
		for (int i = 1; i < 10; i++)
			sums2[i] = 1;
		long nonBouncyBelowGoogol = 20;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < 10; j++) {
				sums1[j] = sums1[j] + sums1[j - 1];
				sums2[j] = sums2[j] + sums2[j - 1];
			}

			long sum = 0;
			for (int j = 0; j < 10; j++)
				sum = sum + sums1[j];
			nonBouncyBelowGoogol = nonBouncyBelowGoogol + sum;

			sum = 0;
			for (int j = 0; j < 10; j++)
				sum = sum + sums2[j];
			nonBouncyBelowGoogol = nonBouncyBelowGoogol + sum;
		}

		nonBouncyBelowGoogol += -10 - (N - 1) * 10 - 1;
		System.out.println("Answer: " + nonBouncyBelowGoogol);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
