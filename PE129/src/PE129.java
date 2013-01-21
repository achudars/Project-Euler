public class PE129 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		for (int n = 1000000;; n++)
			if ((n % 5 != 0 && n % 2 != 0 && calcRepunitDivisibility(n) > 1000000)) {
				System.out.println("Answer: " + n);
				break;
			}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int calcRepunitDivisibility(int p) {
		for (int a = 1, q = 1;; a++) {
			if (q == 0)
				return a;
			q = (q * 10 + 1) % p;
		}
	}
}
