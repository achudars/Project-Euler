public class PE188 {

	final static long N = 1777;

	final static long POW = 1855;

	final static long MOD = 100000000;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long num = hexp(N, POW, MOD);
		System.out.println("Answer: " + num);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// Calculates min p > 0 such that n**p m ==1.

	static long cycleSize(long n, long m) {

		long num = n;
		long i = 1;
		for (; num != 1L; i++) {
			num = num * n;
			num = num % m;
		}

		return i;

	}

	// Caclulates hyperexponiantion with modulo arithmetic

	static long hexp(long n, long hexp, long mod) {
		if (hexp == 1)
			return n % mod;
		long mod1 = cycleSize(n, mod);
		long exp = hexp(n, hexp - 1, mod1);
		long num = 1;
		for (long i = 0; i < exp; i++) {
			num = num * n;
			num = num % mod;
		}

		return num;
	}

}
