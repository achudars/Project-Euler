public class PE108 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// 1/x + 1/y = 1/n
		// ny + nx = xy.
		// xy - ny - nx = 0
		// xy - ny - ny + n^2 = n^2
		// (n-x)(n-y)=n^2
		//
		// n-x and n-y must be factors of n^2.

		long counter = 0, product = 0;
		for (long n = 210; true; n += 210) {
			counter = 0;
			product = n * n;
			for (int a = 1; a <= n; a++) {
				if (product % a == 0)
					counter++;
			}
			if (counter >= 1000) {
				counter = n;
				break;
			}
		}

		System.out.println("Answer: " + counter);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
