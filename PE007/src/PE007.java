public class PE007 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int counter = 0;
		for (int i = 2; i < 1000000; i++) {
			if (isPrime(i)) {
				counter++;
				if (counter == 10001) {
					System.out.println("Answer: " + i);
					break;
				}

			}

		}
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	};

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

};
