import java.util.Arrays;

public class PE155 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		double[][] mem = new double[19][];
		mem[1] = new double[1];
		mem[1][0] = 1;
		double[] temp = new double[5200009];
		int numTemp = 0;
		for (int i = 2; i <= 18; i++) {
			numTemp = 0;
			for (int j = 1; j <= i / 2; j++) {
				int k = i - j;
				for (double d1 : mem[j]) {
					for (double d2 : mem[k]) {
						temp[numTemp++] = d1 + d2;
						temp[numTemp++] = 1 / (1 / d1 + 1 / d2);
						if (numTemp > 5200000) {
							numTemp = trim(temp, 0, numTemp);
						}
					}
				}
			}
			numTemp = trim(temp, 0, numTemp);
			if (i < 18) {
				mem[i] = new double[numTemp];
				for (int j = 0; j < numTemp; j++) {
					mem[i][j] = temp[j];
				}
			}
			System.out.println("i=" + i + "; size=" + numTemp);
		}
		for (int i = 1; i <= 17; i++) {
			for (double d : mem[i]) {
				temp[numTemp++] = d;
				if (numTemp > 5200000) {
					numTemp = trim(temp, 0, numTemp);
				}
			}
		}
		numTemp = trim(temp, 0, numTemp);
		System.out.println("Answer: " + numTemp);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int trim(double[] array, int fromIndex, int toIndex) {
		Arrays.sort(array, fromIndex, toIndex);
		int lastIndex = fromIndex - 1;
		double last = 0;
		for (int j = fromIndex; j < toIndex; j++) {
			if (Math.abs((array[j] - last) / array[j]) > 0.00000001) {
				array[++lastIndex] = array[j];
				last = array[j];
			}
		}
		return lastIndex + 1;
	}

}
