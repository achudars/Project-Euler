public class PE150 {

	static long t = 0;

	static int searchTriangularArrForMinSum() {
		t = (615949 * t + 797807) % 1048576;
		return (int) (t - 524288);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[][] t = new int[1000][];
		long[][] s = new long[1000][];
		for (int i = 0; i < 1000; ++i) {
			t[i] = new int[i + 1];
			s[i] = new long[i + 1];
			for (int j = 0; j <= i; ++j) {
				t[i][j] = searchTriangularArrForMinSum();
			}
		}
		long min = 0;
		for (int use = 1; use <= 1000; ++use) {
			for (int j = 0; j < use; ++j)
				s[use - 1][j] = t[use - 1][j];
			for (int i = use - 1; i >= 0; --i) {
				for (int j = 0; j <= i; ++j) {
					long k = t[i][j];
					if (i < use - 1)
						k += s[i + 1][j] + s[i + 1][j + 1];
					if (i < use - 2)
						k -= s[i + 2][j + 1];
					s[i][j] = k;
					if (k < min)
						min = k;
				}
			}
		}
		System.out.println("Answer: " + min);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
