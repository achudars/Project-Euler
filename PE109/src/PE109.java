import java.util.Arrays;

public class PE109 {

	static int[] values;
	static int count = 0;
	static int max = 99;
	static boolean first = true;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		values = new int[62];
		values[0] = 50;
		values[1] = 25;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 20; j++) {
				values[i * 20 + j + 2] = (j + 1) * (i + 1);
			}
		}

		Arrays.sort(values);

		for (int i = 2; i <= 40; i += 2) {
			solveDartsRecursively(i, 0, 1);
		}

		solveDartsRecursively(50, 0, 1);

		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static void solveDartsRecursively(int sum, int i, int nr) {
		if (sum <= max && nr <= 3) {
			count++;
			for (int j = i; j < values.length; j++) {
				solveDartsRecursively(sum + values[j], j, nr + 1);
			}
		}
	}

}
