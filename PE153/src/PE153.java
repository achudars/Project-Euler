public class PE153 {

	static int gcd(int a, int b) {
		while (a != 0) {
			b %= a;
			int t = a;
			a = b;
			b = t;
		}
		return b;
	}

	static long f(int M) {
		long f = 0;
		for (int i = 1; i <= M; ++i)
			f += (M / i) * i; // yes!
		return f;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int L = 100000000;
		long sum = f(L) + 2 * f(L / 2);
		for (int a = 1; a * a <= L; ++a)
			for (int b = a + 1; b * b <= L - a * a; ++b)
				if (gcd(a, b) == 1)
					sum += 2 * (a + b) * f(L / (a * a + b * b));
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
