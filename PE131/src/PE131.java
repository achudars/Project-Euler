public class PE131 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// fill array with primes
		long[] array = new long[100000];
		for (int i = 2, x = 0; i < 1000000; i++) {
			if (isPrime(i)) {
				array[x] = i;
				// System.out.println(array[x] + "\t");
				x++;
			}
		}

		int counter = 0;

		for (int i = 1; i < 577; i++) {
			if (isPrime((i + 1) * (i + 1) * (i + 1) - i * i * i))
				counter++;
		}

		System.out.println("Answer: " + counter);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

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
