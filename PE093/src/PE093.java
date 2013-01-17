public class PE093 {

	private final static int LIMIT = 1 + (6 * 7 * 8 * 9);

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		final boolean[] m = new boolean[LIMIT];

		int result = 0;
		int best = 0;

		final int[] digits = new int[4];

		for (int a1 = 1; a1 < 10; a1++)
			for (int b1 = a1 + 1; b1 < 10; b1++)
				for (int c1 = b1 + 1; c1 < 10; c1++)
					for (int d1 = c1 + 1; d1 < 10; d1++) {

						// reset m

						for (int i = 0; i < LIMIT; i++)
							m[i] = false;

						digits[0] = a1;
						digits[1] = b1;
						digits[2] = c1;
						digits[3] = d1;

						do {// while permutations

							double a = digits[0];
							double b = digits[1];
							double c = digits[2];
							double d = digits[3];


							for (int op1 = 0; op1 < 4; op1++)
								for (int op2 = 0; op2 < 4; op2++)
									for (int op3 = 0; op3 < 4; op3++) {

										// a + (b + (c + d)
										// a + ((b + c) + d)
										// (a + (b + c)) + d
										// (a + b) + (c + d)
										// ((a + b)+ c) + d

										double x = 0;
										x = e(a, op1, (e(b, op2, e(c, op3, d))));
										rec(x, m);
										x = e(a, op1, e(e(b, op2, c), op3, d));
										rec(x, m);
										x = e(e(a, op1, e(b, op2, c)), op3, d);
										rec(x, m);
										x = e(e(a, op1, b), op2, e(c, op3, d));
										rec(x, m);
										x = e(e(e(a, op1, b), op2, c), op3, d);
										rec(x, m);
									} // for operators

						} while (permutate(digits));

						int run = 0;
						// int count = 0;
						for (int i = 1; i < LIMIT; i++) {

							if (m[i]) {
								run++;
								// count ++;
								// System.out.println(i + "=" + m[i] + " " +
								// count + " " + run);
							} else {
								if (run > best) {
									best = run;
									result = (a1 * 1000) + (b1 * 100)
											+ (c1 * 10) + d1;
								}
								run = 0;
							}

						}

					}
		// result = { a, b, c, d }
		System.out.println("Answer: {" + result + "} with longest set of consecutive positive integers: " + best);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static boolean permutate(int[] d) {
		int k = -1;
		for (int i = 2; i >= 0; i--) {
			if (d[i] < d[i + 1]) {
				k = i;
				break;
			}
		}
		if (k == -1)
			return false; // last permutation
		int l = 0;
		for (int i = 3; k < i; i--) {
			if (d[k] < d[i]) {
				l = i;
				break;
			}
		}
		int temp = 0;
		temp = d[k];
		d[k] = d[l];
		d[l] = temp;
		for (int i = k + 1, j = 3; i < j; i++, j--) {
			temp = d[i];
			d[i] = d[j];
			d[j] = temp;
		}
		return true;
	}

	static double e(double a, int op, double b) {
		switch (op) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		case 3:
			return a / b;
		}

		System.exit(0);
		return -Integer.MAX_VALUE;
	}

	static void rec(double x, boolean[] m) {
		if (x < 0)
			return;
		double y = Math.round(x);
		if (y != x)
			return;

		// System.out.println((int)y);
		m[(int) y] = true;
	}

}
