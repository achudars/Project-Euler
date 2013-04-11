public class PE151 {

	static double expected = 0;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		findExpectedNumber(1.0, 1, 1, 1, 1);
		System.out.printf("Answer: %.6f ", expected);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static void findExpectedNumber(double p, int a2, int a3, int a4, int a5) {
		int sum = a2 + a3 + a4 + a5;

		if (sum == 1 && a5 == 0)
			expected += p;
		if (sum == 0)
			return;
		if (a2 > 0) {
			findExpectedNumber((p * a2) / sum, a2 - 1, a3 + 1, a4 + 1, a5 + 1);
		}
		if (a3 > 0) {
			findExpectedNumber((p * a3) / sum, a2, a3 - 1, a4 + 1, a5 + 1);
		}
		if (a4 > 0) {
			findExpectedNumber((p * a4) / sum, a2, a3, a4 - 1, a5 + 1);
		}
		if (a5 > 0) {
			findExpectedNumber((p * a5) / sum, a2, a3, a4, a5 - 1);
		}
	}

}
