public class PE115 {

	private static long sum = 0;
	private static int blocklength = 50;
	private static long[] sumval = new long[250];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		for (int n = 0; n < 250; n++) {
			sum = 0;
			block(n);
			sumval[n] = sum;
			if (sum > 1000000) {
				System.out.println("Answer: " + n);
				break;
			}
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static void block(int remaining) {
		for (int i = blocklength; remaining >= i; i++) {
			for (int h = 0; h <= (remaining - i); h++) {
				sum++;
				if ((remaining - (i + h + 1)) >= blocklength) {
					sum += sumval[(remaining - (i + 1 + h))];
				}
			}
		}
	}
}
