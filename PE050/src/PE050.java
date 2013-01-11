import java.util.Arrays;

public class PE050 {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		// Generate all primed below 1,000,000 using Sieve of Erasthophanes
		boolean[] isPrimeArray = new boolean[1000000];
		Arrays.fill(isPrimeArray, true);
		isPrimeArray[0] = false;
		isPrimeArray[1] = false;

		for (int p = 2; p < isPrimeArray.length; p++) {
			if (isPrimeArray[p] == false)
				continue;

			if (isPrime(p)) {
				int n = 2;
				while (p * n < isPrimeArray.length) {
					isPrimeArray[p * n] = false;
					n++;
				}
			}
		}

		int maxNumberOfPrimes = 0;
		int conSumPrime = 0;
		for (int i = 0; i < isPrimeArray.length; i++) {
			int sum = 0;
			int numberOfPrimes = 0;
			for (int j = i; j < isPrimeArray.length; j++) {
				if (isPrimeArray[j]) {
					sum += j;
				}
				numberOfPrimes++;
				if (sum >= 1000000)
					break;

				if (isPrimeArray[sum]) {
					if (numberOfPrimes > maxNumberOfPrimes) {
						maxNumberOfPrimes = numberOfPrimes;
						conSumPrime = sum;
					}
				}
			}
		}

		System.out.println("Answer: " + conSumPrime);

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
