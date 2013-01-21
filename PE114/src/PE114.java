public class PE114 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int n = 50;
		long dp[] = new long[n + 2];
		dp[0] = 1;
		for (int i = 0; i <= n; i++) {
			dp[i + 1] += dp[i];
			for (int j = i + 4; j <= n + 1; j++) {
				dp[j] += dp[i];
			}
		}
		System.out.println("Answer: " + dp[n + 1]);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
