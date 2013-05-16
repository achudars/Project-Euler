public class PE190 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int sum = 0;
		for (int m = 2; m < 16; m++) {
			double x[] = new double[m];
			double test[] = new double[m];
			double product = 1.0;
			double test_product = 1.0;
			for (int i = 0; i < m; i++) {
				x[i] = 1.0;
				test[i] = 1.0;
			}
			for (int i = 0; i < m; i++)
				product *= Math.pow(x[i], i + 1);
			boolean hit = true;
			double val = 1.0;
			while (hit || val > 0.00001) {
				if (hit)
					hit = false;
				else
					val *= 0.5;
				int add = 0;
				int sub = 0;
				double max = product;
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < m; j++) {
						if (i != j) {
							for (int k = 0; k < m; k++)
								test[k] = x[k];
							test_product = 1.0;
							test[i] += val;
							test[j] -= val;
							for (int k = 0; k < m; k++)
								test_product *= Math.pow(test[k], k + 1);
							if (test_product > max) {
								max = test_product;
								add = i;
								sub = j;
								hit = true;
							}
						}
					}
				}
				if (hit) {
					x[add] += val;
					x[sub] -= val;
					product = 1.0;
					for (int k = 0; k < m; k++)
						product *= Math.pow(x[k], k + 1);
				}
			}
			sum += (int) product;
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
