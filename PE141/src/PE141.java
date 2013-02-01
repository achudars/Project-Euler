public class PE141 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long sum = 0;
		long globalLimit = (long) 1e12;
		long localLimit = (long) 1e4;

		for (long n = 2; n < localLimit; n++) {
			for (long d = 1; d < n; d++) {
				if (n * n * n * d + d * d >= globalLimit)
					break;
				if (gcd(n, d) > 1) {
					continue;
				}

				for (long x = 1;; x++) {
					long progressivPerfectSquares = x * x * n * n * n * d + x * d * d;
					if (progressivPerfectSquares >= globalLimit)
						break;
					if (isSquare(progressivPerfectSquares)) {
						//System.out.println(progressivPerfectSquares);
						sum += progressivPerfectSquares;
					}
				}
			}
		}

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static long gcd(long a, long b) {
		long t;
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}
		while (a % b > 0) {
			t = a;
			a = b;
			b = t % a;
		}
		return b;
	}

	private static boolean isSquare(long n) {
		long root = (long) Math.sqrt(n);
		return (root * root == n);
	}
}
