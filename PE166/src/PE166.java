public class PE166 {

	final static int N = 4;
	final static int[][][] sum = new int[9 * N + 1][701][N];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long time = System.currentTimeMillis();
		int[] a = new int[N];
		for (a[0] = 0; a[0] < 10; ++a[0]) {
			for (a[1] = 0; a[1] < 10; ++a[1]) {
				for (a[2] = 0; a[2] < 10; ++a[2]) {
					for (a[3] = 0; a[3] < 10; ++a[3]) {
						int[][] s2 = sum[a[0] + a[1] + a[2] + a[3]];
						System.arraycopy(a, 0, s2[s2[700][0]++], 0, N);
					}
				}
			}
		}
		int cnt = 0;
		for (int sum1 = 0; sum1 <= 9 * N; ++sum1) {
			int LIM = sum[sum1][700][0];
			int[][] AR = sum[sum1];
			for (int i = 0; i < LIM; ++i) {
				B: for (int j = 0; j < LIM; ++j) {
					C: for (int k = 0; k < LIM; ++k) {
						a[0] = sum1 - AR[k][0] - AR[j][0] - AR[i][0];
						if (a[0] < 0
								|| a[0] > 9
								|| a[0] != sum1 - AR[i][3] - AR[j][2]
										- AR[k][1])
							continue;
						a[3] = sum1 - AR[k][3] - AR[j][3] - AR[i][3];
						if (a[3] < 0
								|| a[3] > 9
								|| a[3] != sum1 - AR[i][0] - AR[j][1]
										- AR[k][2])
							continue;
						a[1] = sum1 - AR[k][1] - AR[j][1] - AR[i][1];
						if (a[1] < 0 || a[1] > 9)
							continue;
						a[2] = sum1 - AR[k][2] - AR[j][2] - AR[i][2];
						if (a[2] < 0 || a[2] > 9)
							continue;
						if (a[0] + a[1] + a[2] + a[3] == sum1)
							++cnt;
					}
				}
			}
		}
		System.out.println("Answer: " + cnt);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
