public class PE164 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long[][][] v = new long[20][10][10];
		for (int i = 1; i < 10; i++)
			v[0][0][i] = 1;
		for (int i = 1; i < 20; i++)
			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 10; k++)
					for (int d = 0; d + j + k < 10; d++)
						v[i][k][d] += v[i - 1][j][k];
		long ret = 0;
		for (int j = 0; j < 10; j++)
			for (int k = 0; k < 10; k++)
				ret += v[19][j][k];
		System.out.println("Answer: " + ret);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
