public class PE134 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int primes[] = new int[78497];

		int index = 0;
		for (int i = 5; index < 78497; i++)
			if (isPrime(i))
				primes[index++] = i;
		long total = 0;
		for (int j = 0; j < 78496; j++) {
			int size = (int) Math.round(Math.pow(10,
					Math.floor(Math.log10(primes[j])) + 1));
			total += primeMod( (extendedGCD(size % primes[j + 1], primes[j + 1])[0] * (primes[j + 1] - primes[j])),
					primes[j + 1]) * size + primes[j];
		}
		System.out.println("Answer: " + total);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long[] extendedGCD(long a, long b) {
		long r = a % b;
		if (r == 0)
			return (new long[] { 0, 1 });
		long s[] = extendedGCD(b, r);
		return (new long[] { s[1], s[0] - (a / b) * s[1] });
	}

	public static long primeMod(long a, long b) {
		if (a < 0) {
			return ((-a / b) + 1) * b + a;
		} else {
			return a % b;
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
