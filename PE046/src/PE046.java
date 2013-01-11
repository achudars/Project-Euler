public class PE046 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int prev = 3;
		int answer = 0;
		glass: for (int odd = 5; odd < 10000; odd = odd + 2) {
			teeth: for (int prime = 2; prime <= odd; prime++) {
				if (isPrime(prime)) {
					for (int n = 0; n < 100; n++) {
						if ((prime + (2 * (n * n))) == odd) {
							// System.out.println(odd + " = " + prime + " + 2x"
							// + n + "^2");
							if (((odd - prev) > 2) && isPrime(odd)) {
								answer = prev + 2;
								break glass;
							}
							prev = odd;
							break teeth;
						}
					}
				}
			}
		}

		System.out.println("Answer: " + answer);

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
