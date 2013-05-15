import java.util.Arrays;

public class PE179 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int Limit = 10000000 + 1;
		int[] sieb = new int[Limit];
		Arrays.fill(sieb, 1);
		sieb[0] = 0;
		for (int p = 2; p < Limit; p++) {
			if (sieb[p] == 1) {
				for (int j = 1; j * p < Limit; j++) {
					int count = 2;
					int test = j;
					while (test % p == 0) {
						count++;
						test = test / p;
					}
					sieb[j * p] = sieb[j * p] * count;
				}
			}
		}
		int result = 0;
		for (int i = 2; i < Limit - 1; i++)
			if (sieb[i] == sieb[i + 1])
				result++;
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
