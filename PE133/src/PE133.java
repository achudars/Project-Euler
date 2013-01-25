import java.math.BigInteger;

public class PE133 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long count = 3;
		for (int i = 2; i < 100000; i++)
			if (isPrime(i) && !modPow(i))
				count += i;
		System.out.println(count);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static boolean modPow(int d) {
		if (BigInteger.TEN.modPow(BigInteger.TEN.pow(100), BigInteger.valueOf(d)).compareTo(BigInteger.ONE) == 0)
			return true;
		else
			return false;
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
