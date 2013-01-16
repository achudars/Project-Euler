import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PE082 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// dynamic programming over matrix for finding the minimal path sum

		int[][] mat = new int[80][80];
		try {
			fillMatrix(mat);
		} catch (IOException e) {

			e.printStackTrace();
		}
		int[][] mat2 = new int[80][80];
		int min;
		int tempSum;
		for (int j = 0; j < 80; j++) {
			for (int i = 0; i < 80; i++) {
				if (j == 0) {
					mat2[i][j] = mat[i][j];
					continue;
				}
				min = Integer.MAX_VALUE;
				tempSum = 0;
				for (int k = i; k < 80; k++) {
					tempSum += mat[k][j];
					if (tempSum + mat2[k][j - 1] < min)
						min = tempSum + mat2[k][j - 1];
				}
				tempSum = 0;
				for (int k = i; k >= 0; k--) {
					tempSum += mat[k][j];
					if (tempSum + mat2[k][j - 1] < min)
						min = tempSum + mat2[k][j - 1];
				}
				mat2[i][j] = min;
			}
		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 80; i++)
			if (mat2[i][79] < min)
				min = mat2[i][79];
		System.out.println("Answer: " + min);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static void fillMatrix(int[][] mat) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader buff = new BufferedReader(new FileReader("src/matrix.txt"));
		String line;
		String[] split;
		for (int i = 0; i < 80; i++) {
			line = buff.readLine();
			split = line.split(",");
			for (int j = 0; j < 80; j++) {
				mat[i][j] = Integer.parseInt(split[j]);
			}
		}
	}

}
