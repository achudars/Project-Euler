import java.math.BigInteger;

public class PE146 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int max_index = 70;
		int index = 0;

		int[] offsets = new int[] { 1, 3, 7, 9, 13, 27 };
		int[] skipoffsets = new int[] { 5, 11, 15, 17, 19, 21, 23, 25 };
		int[][] modtable = new int[max_index][];
		int i = 2;

		while (index < max_index) {
			boolean div = false;

			for (int n = 0; n < index; n++) {
				if ((i % modtable[n][0]) == 0) {
					div = true;
					break;
				}
			}

			if (!div) {
				modtable[index] = new int[i + 3];
				modtable[index][0] = i;
				index++;
			}

			i++;
		}

		for (int n = 0; n < max_index; n++) {
			int ci = 1;
			int cmod = modtable[n][0];

			for (int j = 0; j < modtable[n][0]; j++) {
				int mod = j * j;
				boolean good = true;

				for (int oi = 0; oi < offsets.length; oi++) {
					if ((mod + offsets[oi]) % cmod == 0)
						good = false;
				}

				if (good) {
					modtable[n][ci] = j;
					ci++;
				}
			}

			for (int j = ci; j < cmod + 2; j++) {
				modtable[n][j] = -1;
			}
		}

		BigInteger sum = new BigInteger("10");

		for (int j = 10; j < 150000000; j += 10) {
			boolean bad = false;

			for (int n = 0; (n < max_index) && !bad; n++) {
				int cm = j % modtable[n][0];
				int ci = 1;
				boolean found = false;
				while (modtable[n][ci] >= 0) {
					if (cm == modtable[n][ci]) {
						found = true;
					}
					ci++;
				}
				if (!found) {
					bad = true;
					break;
				}
			}

			if (!bad) {
				boolean good = true;
				BigInteger nbig = new BigInteger("" + j);
				nbig = nbig.multiply(nbig);

				for (int oi = 0; oi < offsets.length; oi++) {
					BigInteger curTest = new BigInteger("" + offsets[oi]);
					curTest = curTest.add(nbig);
					if (!curTest.isProbablePrime(10)) {
						good = false;
					}
				}
				for (int si = 0; si < skipoffsets.length; si++) {
					BigInteger curTest = new BigInteger("" + skipoffsets[si]);
					curTest = curTest.add(nbig);
					if (curTest.isProbablePrime(10)) {
						good = false;
					}
				}

				if (good) {

					sum = sum.add(new BigInteger("" + j));
				}
			}
		}

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
