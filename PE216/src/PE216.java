/* make sure to increase the heap size -Xms512m -Xmx1280m */

import java.util.ArrayList;
import java.util.List;

public class PE216 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		final int maxN = 50000000;
		List<Long> candidates = new ArrayList<Long>(maxN + 1);

		for (long n = 0; n <= maxN; n++) {
			candidates.add(2L * n * n - 1L);
		}

		for (int n = 2, size = candidates.size(); n < size; n++) {
			long p = candidates.get(n);

			if (p < 2L || p > size * 2) {
				continue;
			}

			for (int m = n + (int) p; m < size; m += (int) p) {
				long candidate = candidates.get(m);
				while (candidate % p == 0) {
					candidate /= p;
				}
				candidates.set(m, candidate);
			}

			for (int m = (int) p - n; m < size; m += (int) p) {
				long candidate = candidates.get(m);
				while (candidate % p == 0) {
					candidate /= p;
				}
				candidates.set(m, candidate);
			}
		}

		int result = 0;

		for (int n = 2, size = candidates.size(); n < size; n++) {
			if (candidates.get(n) == 2L * n * n - 1L) {
				result += 1;
			}
		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
