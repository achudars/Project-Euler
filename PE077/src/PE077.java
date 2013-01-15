public class PE077 {

	public static final int MAX = 1000;
	public static int[] primes = new int[MAX];

	public static void main(String args[]) {
		long startTime = System.nanoTime();

		// this problem uses Euler Tranforms (number theory)

		generatePrimes();
		for (int n = 1;; n++)
			if (getPartitions(n, MAX - 1) > 5000) {
				System.out.println("Answer: " + n);
				break;
			}

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

	public static void generatePrimes() {
		int num = 0;
		for (int n = 1;; n++)
			if (isPrime(n)) {
				primes[num++] = n;
				if (num == MAX)
					return;
			}
	}

	// number of ways to express n as a sum of primes in the set {p[0],...,p[k]}
	private static int getPartitions(int n, int k) {
		if (n == 0)
			return 1;
		else if (k < 0)
			return 0;
		else if (n < primes[k])
			return getPartitions(n, k - 1);
		else
			return getPartitions(n - primes[k], k) + getPartitions(n, k - 1);
	}
}
