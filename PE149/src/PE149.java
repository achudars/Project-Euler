public class PE149 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[] list = new int[4000001];
		int[][] table = new int[2000][2000];
		
		for (long i = 1; i <= 4000000; i++) {
			if (i <= 55)
				list[(int) i] = (int) ((100003 + 300007 * i * i * i - 200003 * i) % 1000000) - 500000;
			else
				list[(int) i] = (list[(int) i - 24] + list[(int) i - 55] + 1000000) % 1000000 - 500000;
		}
		for (int i = 0; i < 2000; i++)
			for (int j = 0; j < 2000; j++)
				table[i][j] = list[2000 * i + j + 1];
		list = null;
		
		System.out.println("Answer: " + countMaxSumSubsequence(table));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static long countMaxSumSubsequence(int[][] a) {
		long max = 0, tSum, nSum;
		for (int i = 0; i < 2000; i++) {

			tSum = nSum = 0;

			for (int j = 0; j < 2000; j++) {

				nSum += a[i][j];
				tSum += a[j][i];

				if (nSum < a[i][j]) {
					nSum = a[i][j];
				}
				if (tSum < a[j][i]) {
					tSum = a[j][i];
				}
				if (max < nSum) {
					max = nSum;
				}
				if (max < tSum) {
					max = tSum;
				}
			}
		}
		return max;
	}

}
