public class PE159 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + solve());

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	// mdrs(n) = max( max(mdrs(a)+mdrs(b)), drs[n])
	// for all ab=n, a&lt;b, a!=1

	public static int solve() {
		int[] X = new int[1000000];
		int sum = 0;
		for (int i = 2; i < X.length; i++)
			X[i] = (i - 1) % 9 + 1;
		for (int j = 2; j < 1000000; j++) {
			int drsj = X[j];
			for (int k = 2, n = j + j; k <= j && n < 1000000; k++, n += j)
				X[n] = Math.max(X[n], drsj + X[k]);
			sum += drsj;
		}
		return sum;
	}
}
