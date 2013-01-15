public class PE073 {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		long count = 0;
		for (int d = 5; d <= 12000; d++) {
			int bMax = d / 2;
			for (int n = d / 3 + 1; n <= bMax; n++) {
				if (gcd(n, d) == 1)
					count++;
			}
		}
		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static boolean isReducedProperFraction(int n, int d) {
		if (n < d && gcd(n, d) == 1) {
			return true;
		}
		return false;
	}

	public static int gcd(int n, int d) {
		while (d != 0) {
			int t = d;
			d = n % d;
			n = t;
		}
		return n;
	}

	public static int phi(int d) {
		int count = 0;

		for (int n = 1; n < d; n++)
			if (isReducedProperFraction(n, d))
				count++;

		return count;
	}

}
