public class PE163 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long n = t(36);
		long t1 = System.currentTimeMillis();
		System.out.println(n);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	private static long t(int n) {
		long count = 0;
		for (int x = 1; x < n; x++) {
			for (int y = 1; y <= x; y++)
				count += countX2(x, y, n);
		}
		count = count * 2; // for left-right symmetry
		for (int y = 1; y <= n; y++)
			count += countX2(n, y, n); // the center triangles, x==n

		count /= 2; // back to true counts
		for (int i = 1; i <= n; i++)
			count += upwardEquilaterals(i, n);

		for (int i = 1; i <= n / 2; i++)
			count += downwardEquilaterals(i, n);

		return count;
	}

	// count triangles using vertical line at x starting in triangle (x, y)
	// and all symmetries. Count x2 to stay with integer arithmetic.
	private static long countX2(int x, int y, int n) {
		int dxr = Math.max(0, 2 * n - x - y);
		int dxl = Math.max(0, x - y);
		if ((x + y) % 2 == 0)
			return countX2UpwardTriangle(y, dxr)
					+ countX2UpwardTriangle(y, dxl);
		else
			return countX2DownwardTriangle(y, dxr)
					+ countX2DownwardTriangle(y, dxl);
	}

	private static long countX2DownwardTriangle(int y, int dx) {
		long count = 0;
		/* 120-30-30 */count += 3 * Math.min((y + 1) / 2, (dx + 3) / 4);
		/* 90-30-60 */count += 6 * Math.min((3 * y + 1) / 2, (dx + 1) / 2);
		/* 90-60-30 */count += 6 * Math.min((y + 1) / 2, (dx + 1) / 2);
		/* 60-60-60 */count += 2 * Math.min((3 * y - 1) / 2,
				(dx + 1) * 3 / 2 - 1);
		return count;
	}

	private static long countX2UpwardTriangle(int y, int dx) {
		long count = 0;
		/* 30-60-90 */count += 6 * y;
		/* 30-90-60 */count += 6 * (3 * y / 2);
		/* 30-30-120 */count += 3 * y;
		/* 30-120-30 */count += 6 * (y / 2);
		/* 120-30-30 */count += 3 * Math.min(y / 2, dx / 4);
		/* 120-30-30 */count += 3 * Math.min(y / 2, (dx + 2) / 4);
		/* 90-30-60 */count += 6 * Math.min(3 * y / 2, dx / 2);
		/* 90-60-30 */count += 6 * Math.min(y / 2, dx / 2);
		/* 60-60-60 */count += 2 * Math.min(y * 3 / 2, dx * 3 / 2);
		/* 60-60-60 */count += 2 * Math.min(y * 3 / 2 - 1, dx * 3 / 2 + 1);
		return count;
	}

	// upward equilaterals of size i
	private static long upwardEquilaterals(int i, int n) {
		return sum(n + 1 - i);
	}

	// downward equilaterals of size i
	private static long downwardEquilaterals(int i, int n) {
		return sum(n - (2 * i - 1));
	}

	public static long sum(long n) {
		if (n <= 0)
			return 0;
		return n * (n + 1) / 2;
	}

}
