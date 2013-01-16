public class PE088 {

	// static int maxk = 12000, maxproduct = 2 * maxk;
	// static int[] minps = new int[maxk + 1];
	// static boolean[] have = new boolean[maxproduct + 1];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int max = 12000;
		int[] psums = new int[max + 1];
		for (int k = 2; k <= max; k++) {
			psums[k] = 2 * k;
		}
		double l2 = Math.log(2.0);
		int maxd = (int) (Math.log(2 * max) / l2);

		int[] digits = new int[maxd + 1];
		for (int d = 2; d <= maxd; d++) {
			for (int i = 0; i < d; i++) {
				digits[i] = 2;
			}

			double maxleft = 1.0 + Math.pow(max, 1.0 / (double) d);
			while (digits[d - 1] < maxleft) {
				int product = 1, sum = 0;
				for (int i = 0; i < d; i++) {
					product *= digits[i];
					sum += digits[i];
				}
				int k = product - sum + d;
				if (product <= 2 * max) {
					if (k <= max && product < psums[k]) {
						psums[k] = product;
					}

				}
				digits[0]++;
				for (int j = 1; j < d; j++) {
					product = 1;
					for (int i = 0; i < d; i++) {
						product *= digits[i];
					}

					if (product > 2 * max || k >= max) {
						k = 0;
						digits[j]++;
						for (int j2 = 0; j2 < j; j2++) {
							digits[j2] = digits[j];
						}

					} else {
						break;
					}
				}
			}
		}

		int[] mps = new int[2 * max + 4];
		for (int k = 2; k <= max; k++) {
			mps[psums[k]] = 1;
		}
		int minimalProductSum = 0;
		for (int i = 2; i < (2 * max + 2); i++) {
			minimalProductSum += i * mps[i];
		}
		System.out.println("Answer: " + minimalProductSum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
