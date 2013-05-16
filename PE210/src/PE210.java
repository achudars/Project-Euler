public class PE210 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		final long r = 1000000000;
		long sum = 0;

		// whole square
		sum += 2 * r * (r + 1) + 1;
		// remove band between 0 <= x+y <=r/2
		sum -= (2 * r + 1) * r / 4 + r + 1;
		// remove points on line x=y, not in previous band
		sum -= r / 2 + r / 4;
		// add all points strictly interior to circle around r/8,r/8, radius r/8
		// sqrt2
		sum += countCircle(r * r / 32);
		// remove points on line x=y, interior to circle
		sum -= r / 4 - 1;

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	// count all points strictly interior to circle with squared radius r2.
	static long countCircle(long r2) {
		long x = 0;
		long x2 = 1;
		while (x2 < r2) {
			x2 += x + x + 1;
			x++;
		}

		long total = 0;
		long y = 0;
		long y2next = 1;
		while (true) {
			x--;
			x2 -= x + x + 1;
			// find top point of this column
			while (x2 + y2next < r2) {
				y++;
				y2next += y + y + 1;
			}
			if (x < y)
				break;
			total += 8 * y + 4;
		}
		total += (2 * x + 1) * (2 * x + 1);
		return total;
	}

}
