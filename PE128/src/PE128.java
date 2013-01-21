public class PE128 {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + calcHexTileDifference(2000));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long calcHexTileDifference(int N) {
		for (long n = 2, p = 8, m = 6;; m += 6, p += m) {
			if (isPrime(m + 5) && isPrime(m + 7) && isPrime(2 * m + 17)
					&& (++n == N))
				return p;
			if (isPrime(m + 5) && isPrime(m + 11) && isPrime(2 * m + 5)
					&& (++n == N))
				return p + m + 5;
		}
	}

	// prime number checking function
	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}

		return true;
	};
}
