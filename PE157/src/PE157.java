public class PE157 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long time = System.nanoTime();

		int LIMIT = 9 + 1;
		int result = 0;

		int[] sols2 = new int[LIMIT];
		sols2[0] = 1;
		for (int n = 1; n < LIMIT; n++)
			sols2[n] = sols2[n - 1] << 1;

		int[] sols5 = new int[LIMIT];
		sols5[0] = 1;
		for (int n = 1; n < LIMIT; n++)
			sols5[n] = sols5[n - 1] * 5;

		for (int n = 1; n < LIMIT; n++) {
			int ten = getUpper(10, n);
			for (int ai = 0; ai <= n; ai++) {
				for (int bi = 0; bi <= n; bi++) {
					result += solveDiophantine(sols2[ai], sols5[bi], ten);
				}
			}
			for (int ai = 1; ai <= n; ai++) {
				for (int bi = 1; bi <= n; bi++) {
					result += solveDiophantine(1, sols2[ai] * sols5[bi], ten);
				}
			}
		}

		System.out.println("Answer (1-" + (LIMIT - 1) + "): " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int solveDiophantine(int a, int b, int zehn) {
		long sumOfTen = (long) zehn * (a + b);
		if (sumOfTen % b != 0 || sumOfTen % a != 0)
			return 0;
		return getPrime((int) (sumOfTen / (a * b)));
	}

	public static int getPrime(int number) {
		int result = 1;
		for (int k = 2; k * k <= number; k++) {
			int count = 1;
			while (number % k == 0) {
				number = number / k;
				count++;
			}
			result = result * count;
		}
		if (number != 1)
			result = result << 1;
		return result;
	}

	public static int getUpper(int b, int e) {
		int result = 1;
		while (e > 0) {
			if ((e & 1) == 1)
				result = result * b;
			e >>= 1;
			b = b * b;
		}
		return result;
	}

}
