public class PE023 {

	int limit = 28123;
	int iterator = 0;
	int[] abundantNumbers = new int[limit + 1];
	int[] numbers = new int[limit + 1];
	boolean[] abundant = new boolean[limit + 1];

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println("Answer: " + (new PE023()).getAnswer());

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static int getSumOfFactors(int n) {
		int factor = 1;
		for (int k = 2; k * k <= n; ++k) {
			int p = 1;
			while (n % k == 0) {
				p = p * k + 1;
				n /= k;
			}
			factor *= p;
		}
		if (n > 1)
			factor *= 1 + n;
		return factor;
	};

	private boolean isAbundant(int n) {
		return (getSumOfFactors(n) > n + n);
	};

	public int getAnswer() {
		for (int n = 1; n <= limit; n++) {
			numbers[n] = n;
			abundant[n] = isAbundant(n);
			if (abundant[n]) {
				abundantNumbers[iterator++] = n;
			}
		}
		for (int n = 1; n <= limit; n++) {
			int i = 0;
			loop: while (i < iterator) {
				if (n - abundantNumbers[i] < 12)
					break loop;
				if (abundant[n - abundantNumbers[i]]) {
					numbers[n] = 0;
					break loop;
				}
				i++;
			}
		}
		int sum = 0;
		for (int i = 1; i <= limit; i++)
			sum += numbers[i];
		return sum;
	}
}
