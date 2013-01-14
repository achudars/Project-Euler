public class PE058 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		double total = 1;
		double primes = 0;
		double ratio = 0;
		
		int side = 0;

		int lr, ll, ul, ur = 0;
		// loop through all corner sums from inner to outer
		corners: for (int n = 3;; n += 2) {
			total += 4;
			lr = (n * n);
			ll = (n * n - n + 1);
			ul = (n * n - 2 * n + 2);
			ur = (n * n - 3 * n + 3);

			// System.out.println(n+"x"+n);
			// System.out.println("lower right corner: " + (n*n));
			// System.out.println("lower left corner: " + (n*n-n+1));
			// System.out.println("upper left corner: " + (n*n-2*n+2));
			// System.out.println("upper right corner: " + (n*n-3*n+3));

			if (isPrime(lr))
				primes++;
			if (isPrime(ll))
				primes++;
			if (isPrime(ul))
				primes++;
			if (isPrime(ur))
				primes++;

			ratio = (primes / total) * 100;
			// System.out.println("Answer: " + df.format(ratio)+ "%");
			if (ratio < 10) {
				System.out.println("1st ratio below 10% is " + ratio + " for "
						+ n + " x " + n);
				side = n;
				break corners;
			}
		}
		
		System.out.println("Answer: " + side);
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// prime number checking function
	public static boolean isPrime(int n) {
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
