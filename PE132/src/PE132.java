import java.math.BigInteger;

public class PE132 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		BigInteger TEN = BigInteger.valueOf(10);
		int total = 0;
		int count = 0;
		for (int i = 5; count < 40; i++) {
			if (!isPrime(i))
				continue;
			int r = TEN.modPow(BigInteger.valueOf(1000000000), BigInteger.valueOf(i)).intValue();
			if (r == 1) {
				total += i;
				count++;
			}
		}
		System.out.println("Answer: " + total);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
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
