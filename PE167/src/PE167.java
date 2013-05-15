public class PE167 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long sum = 0;
		for (int n = 2; n <= 10; n++) {
			long u = calcUlam(2 * n + 1, 100000000000L);
			System.out.println("2 " + (2 * n + 1) + ": " + u);
			sum += u;
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static long calcUlam(int b, long k) {
		int len = 5000, period = 0, startPeriod = 1, startPos = 0;
		int[] v = null;
		while (period <= 0) {
			v = new int[len];
			startPos = ulam(b, v);
			period = findPeriod(v, startPos, startPeriod);
			len = len * 4;
			startPeriod = (v.length - startPos - 1) / 2;
		}
		long dist = k - startPos - 1;
		return (dist / period) * (v[startPos + period] - v[startPos])
				+ v[startPos + (int) (dist % period)];
	}

	static int ulam(int b, int[] list) {
		list[0] = 2;
		list[1] = b;
		int p = 2, testVal = b + 1, secondEven = -1, length = list.length, posAfter2ndEven = 0;
		boolean[] used = new boolean[length * 10];
		used[2] = used[b] = true;

		while (true) {
			int hits = 0;
			if (secondEven < 0) {
				for (int i = 0, x = list[0], y = testVal - x; x < y; i++, x = list[i], y = testVal
						- x)
					if (used[y])
						hits++;
			} else {
				if (used[testVal - 2])
					hits++;
				if (used[testVal - secondEven])
					hits++;
			}
			if (hits == 1) {
				list[p++] = testVal;
				used[testVal] = true;
				if ((testVal & 1) == 0 && secondEven < 0) {
					secondEven = testVal--;
					posAfter2ndEven = p;
				}
				if (p == length)
					return posAfter2ndEven;
			}
			testVal += secondEven > 0 ? 2 : 1;
		}
	}

	static int findPeriod(int[] list, int startPos, int startPeriod) {
		int[] diffs = new int[list.length - startPos - 1];
		for (int i = startPos; i < list.length - 1; i++)
			diffs[i - startPos] = list[i + 1] - list[i];
		for (int p = startPeriod; p < diffs.length / 2; p++) {
			int x;
			for (x = p; x < diffs.length; x++)
				if (diffs[x] != diffs[x % p])
					break;
			if (x == diffs.length)
				return p;
		}
		return -1;
	}

}
