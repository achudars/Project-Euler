public class PE195 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long maxr = 1053779;
		long maxr1 = (long) (maxr * 2 / Math.sqrt(3.));
		long maxr2 = (long) (maxr * 6 / Math.sqrt(3.));
		long count = 0;

		for (long q = 1; q * q <= maxr1; q++) {
			for (long p = q + 1; q * p <= maxr1; p++) {
				if ((p - q) % 3 != 0 && gcd(p, q) == 1) {
					count += maxr1 / (p * q);
				}
			}
		}

		for (long q = 1; q * q <= maxr2; q++) {
			for (long p = q + 3; p * q <= maxr2; p += 3) {
				if (gcd(p, q) == 1) {
					count += maxr2 / (p * q);
				}
			}
		}
		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static long gcd(long a, long b) {
		while (a != 0) {
			long t = a;
			a = b % a;
			b = t;
		}
		return b;
	}

}
