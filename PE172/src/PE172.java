public class PE172 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + rec(0, 0));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static long cache[][] = new long[18][1 << 20];

	public static long rec(int bits, int pos) {
		if (pos == 18)
			return 1;
		if (cache[pos][bits] > 0)
			return cache[pos][bits] - 1;
		int start = pos == 0 ? 1 : 0;
		long sum = 0;
		for (int d = start; d <= 9; d++)
			if (((bits >> (d + d)) & 3) != 3)
				sum += rec(bits + (1 << (d + d)), pos + 1);

		cache[pos][bits] = sum + 1;
		return sum;
	}

}
