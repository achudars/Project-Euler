public class PE201 {

	static final int N = 100;
	static final int K = 50;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// initialize S
		int[] S = new int[N];
		for (int n = 1; n <= N; n++)
			S[n - 1] = n * n;

		// compute maxsum and minsum
		int maxsum = 0;
		int minsum = 0;
		for (int n = 0; n < K; n++) {
			minsum += S[n];
			maxsum += S[N - n - 1];
		}

		// initialize x and y
		int[][] x = new int[K + 1][maxsum + 1];
		int[][] y = new int[K + 1][maxsum + 1];
		y[0][0] = 1;

		// bottom-up DP over n
		for (int n = 1; n <= N; n++) {
			x[0][0] = 1;
			for (int k = 1; k <= K; k++) {
				int e = S[n - 1];
				for (int s = 0; s < e; s++)
					x[k][s] = y[k][s];
				for (int s = 0; s <= maxsum - e; s++) {
					x[k][s + e] = y[k - 1][s] + y[k][s + e];
				}
			}
			int[][] t = x;
			x = y;
			y = t;
		}

		// sum of unique K-subset sums
		int sum = 0;
		for (int s = minsum; s <= maxsum; s++) {
			if (y[K][s] == 1)
				sum += s;
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
