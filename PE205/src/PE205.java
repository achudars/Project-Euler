public class PE205 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[] pet = new int[] { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] col = new int[] { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int a = 2; a <= 9; ++a) {
			int[] x = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0 };
			for (int b = 1; b < x.length; ++b)
				for (int c = Math.max(0, b - 4); c < b; ++c)
					x[b] += pet[c];
			pet = x;
		}
		for (int a = 2; a <= 6; ++a) {
			int[] x = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0 };
			for (int b = 1; b < x.length; ++b)
				for (int c = Math.max(0, b - 6); c < b; ++c)
					x[b] += col[c];
			col = x;
		}
		long count = 0;
		for (int p = 0; p < pet.length; ++p)
			for (int c = 0; c < p; ++c)
				count += pet[p] * col[c];
		long total = 0;
		for (int p = 0; p < pet.length; ++p)
			for (int c = 0; c < col.length; ++c)
				total += pet[p] * col[c];

		double result = ((double) Math
				.round(((double) count / total) * 10000000) / 10000000);

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
