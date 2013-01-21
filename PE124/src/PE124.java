import java.util.Arrays;

public class PE124 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int limit = 100000 + 1;
		int[] order = new int[limit];
		Arrays.fill(order, 1);
		order[0] = 0;
		for (int p = 2; p < limit; p++) {
			if (order[p] == 1) // additional primes found
			{
				for (int j = p; j < limit; j = j + p) {
					order[j] = order[j] * p;
				}
			}
		}

		int[] sorted = order.clone();
		Arrays.sort(sorted);

		int index = 10000;
		int radical = sorted[index];
		int count = 0;
		while (sorted[index - 1 - count] == radical)
			count++;

		int n = radical;
		while (count != 0) {
			n += radical;
			if (order[n] == radical)
				count--;
		}

		int result = n;
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
