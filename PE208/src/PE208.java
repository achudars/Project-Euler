public class PE208 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[][] choices = new int[15][15];
		choices[0][0] = 1;
		for (int i = 1; i < 15; i++)
			choices[i][0] = 1;
		for (int i = 1; i < 15; i++)
			choices[i][i] = 1;
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < i; j++)
				choices[i][j] = choices[i - 1][j - 1] + choices[i - 1][j];
		}

		int max = 14;
		long total = 0;

		long pows;
		for (int n = 0; n < max; n++) {
			total += pow(choices[max - 1][n], 5);
			if (n > 0) {
				total += pow(choices[max - 1][n], 4)
						* pow(choices[max - 1][n - 1], 1);
				total += pow(choices[max - 1][n], 3)
						* pow(choices[max - 1][n - 1], 2);
				total += pow(choices[max - 1][n], 2)
						* pow(choices[max - 1][n - 1], 3);
				total += pow(choices[max - 1][n], 1)
						* pow(choices[max - 1][n - 1], 4);
			}
		}

		System.out.println("Answer: " + (total * 2) );

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long pow(int n, int e) {
		long ret = 1;
		for (int i = 0; i < e; i++)
			ret *= n;
		return ret;
	}

}
