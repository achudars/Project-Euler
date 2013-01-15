public class PE074 {

	public static int[] digitFactorials;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		digitFactorials = new int[10];
		for (int i = 0; i < digitFactorials.length; i++) {
			digitFactorials[i] = factorial(i);
		}
		int total = 0;
		for (int i = 1; i < 1000000; i++) {
			if (chainLength(i) == 60)
				total++;
		}
		System.out.println("Answer: " + total);

		long endTime = System.nanoTime();
		System.out.printf("\n\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int chainLength(int n) {
		if (n == 145 || n == 40585 || n == 363601)
			return 1;
		if (n == 169)
			return 3;
		if (n == 871 || n == 872)
			return 2;
		int result = 1;
		while (true) {
			int m = nextInChain(n);
			if (m == 1 || m == 2 || m == 145 || m == 40585)
				return result + 1;
			if (m == 871 || m == 45361 || m == 872 || m == 45362)
				return result + 2;
			if (m == 169 || m == 363601 || m == 1454)
				return result + 3;
			result++;
			n = m;
		}
	}

	public static int nextInChain(int n) {
		int res = 0;
		while (!(n == 0)) {
			res += digitFactorials[n % 10];
			n /= 10;
		}
		return res;
	}

	public static int factorial(int n) {
		if (n < 2)
			return 1;
		return n * factorial(n - 1);
	};

}
