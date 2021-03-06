public class PE037 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int primeCounter = 0;
		int truncatableRL, truncatableLR = 0;
		int sum = 0;
		for (Integer i = 23; i < 1000000; i++) {
			if (isPrime(i)) {
				truncatableRL = i;
				truncatableLR = i;

				do {
					truncatableLR = (int) (truncatableLR % (Math.pow(10,
							(String.valueOf(truncatableRL).length() - 1))));
					truncatableRL = (truncatableRL / 10);

					if (isPrime(truncatableRL) && isPrime(truncatableLR)) {
						if (String.valueOf(truncatableRL).length() == 1) {
							primeCounter++;
							sum += i;
							//System.out.println("> " + i);
						}
					} else {
						break;
					}
				} while (String.valueOf(truncatableRL).length() >= 0);
			}
		}
		System.out.println("Answer: " + sum);
		//System.out.println("prime counter: " + primeCounter);

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
