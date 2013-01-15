public class PE072 {

	static int size = 1000001;
	static int k = 3;
	static long sol = 0;
	static double tots[] = new double[size];

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		for (int i = 0; i < size; i++)
			tots[i] = i;
		specialSieve(2);
		while (k < size) {
			specialSieve(k);
			k = findNext(k);
		}
		for (int i = 2; i < size; i++)
			sol += tots[i];
		System.out.printf("Answer: %d\n", sol);

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

	static void specialSieve(int k) {
		for (int p = k; p < size; p += k)
			tots[p] *= (k - 1) / (double) k;
	}

	static int findNext(int m) {
		m += 2;
		while (m < size && tots[m] != m)
			m += 2;
		return m;
	}

}
