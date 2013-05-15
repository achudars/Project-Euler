public class PE154 {

	static final int max = 200000;
	static int[] f5 = new int[max + 1];
	static int[] f2 = new int[max + 1];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long answer = 0;

		for (int n = 1; n <= max; n++) {
			f5[n] = f5[n - 1] + repDiv(n, 5);
			f2[n] = f2[n - 1] + repDiv(n, 2);
		}

		int fives = f5[max] - 11;
		int twos = f2[max] - 11;

		for (int a = 0; 3 * a <= max; a++) {
			for (int b = a; a + 2 * b <= max; b++) {
				int c = max - a - b;

				int factors5 = f5[a] + f5[b] + f5[c];
				int factors2 = f2[a] + f2[b] + f2[c];

				if (factors5 < fives && factors2 < twos) {
					if (a == c)
						answer++;
					else if (a < b && b < c)
						answer += 6;
					else
						answer += 3;
				}
			}
		}
		System.out.println("Answer: " + answer);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int repDiv(int n, int i) {
		int s = 0;
		while (n % i == 0) {
			s++;
			n /= i;
		}
		return s;
	}

}
