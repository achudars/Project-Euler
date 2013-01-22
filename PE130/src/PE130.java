public class PE130 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int limit = 25;
		int found = 0;

		int n = 1;
		int result = 0;

		while (found < limit) {
			n++;

			if (IsPrime(n))
				continue;

			int a = A(n);

			if (a != 0 && ((n - 1) % a == 0)) {
				result += n;
				found++;
			}

		}

		System.out
				.printf("Answer: The sum of the first %d of these composite numbers is %d", limit, result);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int GCD(int a, int b) {
		return b == 0 ? a : GCD(b, a % b);
	}

	private static boolean IsPrime(int n) {
		if (n < 2)
			return false;
		if (n < 4)
			return true;
		if (n % 2 == 0)
			return false;
		if (n < 9)
			return true;
		if (n % 3 == 0)
			return false;
		if (n < 25)
			return true;

		int s = (int) Math.sqrt(n);
		for (int i = 5; i <= s; i += 6) {
			if (n % i == 0)
				return false;
			if (n % (i + 2) == 0)
				return false;
		}

		return true;
	}

	private static int A(int n) {

		if (GCD(n, 10) != 1)
			return 0;

		int x = 1;
		int k = 1;

		while (x != 0) {
			x = (x * 10 + 1) % n;
			k++;
		}

		return k;
	}

}
