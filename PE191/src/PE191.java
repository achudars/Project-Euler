public class PE191 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int days = 30;
		long array[][][][][] = new long[days][3][3][3][2];
		array[0][0][0][0][0] = 1;
		array[0][1][0][0][0] = 1;
		array[0][2][0][0][1] = 1;
		long sum = 0;
		for (int i = 1; i < days; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (j != 2) {
							array[i][j][k][l][0] = array[i - 1][k][l][0][0]
									+ array[i - 1][k][l][1][0];
							array[i][j][k][l][1] = array[i - 1][k][l][0][1]
									+ array[i - 1][k][l][1][1]
									+ array[i - 1][k][l][2][1];
						} else {
							array[i][j][k][l][1] = array[i - 1][k][l][0][0]
									+ array[i - 1][k][l][1][0];
						}
						if (j == 1 && k == 1 && l == 1) {
							array[i][j][k][l][0] = 0;
							array[i][j][k][l][1] = 0;
						}
						if (i == days - 1)
							sum += (array[i][j][k][l][0] + array[i][j][k][l][1]);
					}
				}
			}
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
