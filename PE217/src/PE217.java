import java.math.BigInteger;

public class PE217 {

	public static BigInteger[][] numPerm, sumPerm, numPermNoZeroStart,
			sumPermNoZeroStart;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		final int n = 47;
		fillArrays(n);
		BigInteger tOfN = getTOfN(n);

		System.out.println("Answer: " + tOfN.mod(BigInteger.valueOf(3).pow(15)));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static void fillArrays(int n) {
		numPerm = new BigInteger[n / 2 + 1][(n / 2) * 9 + 1];
		sumPerm = new BigInteger[n / 2 + 1][(n / 2) * 9 + 1];
		numPermNoZeroStart = new BigInteger[n / 2 + 1][(n / 2) * 9 + 1];
		sumPermNoZeroStart = new BigInteger[n / 2 + 1][(n / 2) * 9 + 1];
		for (int i = 0; i < n / 2 + 1; i++) {

			for (int j = 0; j < (n / 2) * 9 + 1; j++) {
				numPerm[i][j] = BigInteger.ZERO;
				sumPerm[i][j] = BigInteger.ZERO;
				numPermNoZeroStart[i][j] = BigInteger.ZERO;
				sumPermNoZeroStart[i][j] = BigInteger.ZERO;
				if (i == 0) {
					continue;
				}
				if (j < 10) {
					if (i == 1) {
						numPerm[i][j] = BigInteger.ONE;
						sumPerm[i][j] = BigInteger.valueOf(j);

						if (j != 0) {
							numPermNoZeroStart[i][j] = BigInteger.ONE;
							sumPermNoZeroStart[i][j] = BigInteger.valueOf(j);
						}
					}
				}
				for (int k = 0; k < 10 && k <= j; k++) {
					numPerm[i][j] = numPerm[i][j].add(numPerm[i - 1][j - k]);
					sumPerm[i][j] = sumPerm[i][j].add(sumPerm[i - 1][j - k])
							.add(BigInteger.valueOf(k)
									.multiply(BigInteger.TEN.pow(i - 1))
									.multiply(numPerm[i - 1][j - k]));
					if (k != 0) {
						numPermNoZeroStart[i][j] = numPermNoZeroStart[i][j]
								.add(numPerm[i - 1][j - k]);
						sumPermNoZeroStart[i][j] = sumPermNoZeroStart[i][j]
								.add(sumPerm[i - 1][j - k])
								.add(BigInteger.valueOf(k)
										.multiply(BigInteger.TEN.pow(i - 1))
										.multiply(numPerm[i - 1][j - k]));
					}
				}
			}
		}
	}

	public static BigInteger getTOfN(int n) { // any N up to 47
		BigInteger tOfN = BigInteger.ZERO;
		BigInteger tOfi; // not cumulative, i.e. tOfi when i=5 != T(5), instead
							// it equals T(5)-T(4)
		for (int i = 0; i <= n; i++) {
			if (i == 1) {
				tOfN = BigInteger.valueOf(45);
			}
			if (i % 2 == 0) {
				for (int j = 0; j <= (i / 2) * 9; j++) {
					tOfi = sumPerm[i / 2][j]
							.multiply(numPermNoZeroStart[i / 2][j]);
					tOfi = tOfi.add(sumPermNoZeroStart[i / 2][j].multiply(
							numPerm[i / 2][j]).multiply(
							BigInteger.TEN.pow(i / 2)));
					tOfN = tOfN.add(tOfi);
				}
			} else {
				for (int j = 0; j <= ((i - 1) / 2) * 9; j++) {
					tOfi = sumPerm[(i - 1) / 2][j]
							.multiply(numPermNoZeroStart[(i - 1) / 2][j]);

					tOfi = tOfi.add(sumPermNoZeroStart[(i - 1) / 2][j]
							.multiply(numPerm[(i - 1) / 2][j]).multiply(
									BigInteger.TEN.pow((i + 1) / 2)));

					tOfi = tOfi.multiply(BigInteger.valueOf(10));

					tOfi = tOfi.add(BigInteger.valueOf(45)
							.multiply(BigInteger.TEN.pow((i - 1) / 2))
							.multiply(numPerm[(i - 1) / 2][j])
							.multiply(numPermNoZeroStart[(i - 1) / 2][j]));

					tOfN = tOfN.add(tOfi);
				}
			}
		}
		return tOfN;
	}

}
