public class PE027 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// n^2 + an + b, where |a| < 1000 and |b| < 1000
		int primeCounter = 0;
		int product = 0;
		int coefficientA = 0;
		int coefficientB = 0;

		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				int counter = 0;
				for (int n = 0;; n++) {
					if (isPrime(n * n + a * n + b))
						counter++;
					else
						break;
				}
				if (counter > primeCounter) {
					primeCounter = counter;
					coefficientA = a;
					coefficientB = b;
				}
			}
		}
		product = coefficientA * coefficientB;
		System.out.println("Answer: " + product + "; made of " + coefficientA
				+ " and " + coefficientB + " having a chain of " + primeCounter
				+ " primes");

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
