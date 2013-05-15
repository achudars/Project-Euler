import java.math.BigInteger;

public class PE160 {

	private static final long N = 1000000000000L;
	private static final int MOD = 100000;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long[] ds = new long[MOD];
		long toCancel = 0;
		for (long i = N / 5; i > 0; i /= 5)
			toCancel += i;

		for (long k = 1; k < N; k *= 5) {
			for (int i = 0; i < ds.length; ++i)
				if (i % 5 != 0)
					ds[i] += N / MOD / k;
			for (int i = 0; i <= (N / k) % MOD; ++i)
				if (i % 5 != 0)
					ds[i]++;
		}

		for (int i = ds.length - 1; i > 0 && toCancel != 0; --i) {
			if (i % 2 == 0) {
				long c2 = Math.min(toCancel, ds[i]);
				ds[i / 2] += c2;
				ds[i] -= c2;
				toCancel -= c2;
			}
		}

		BigInteger res = new BigInteger("1");
		for (int i = 0; i < ds.length; ++i) {
			BigInteger temp = BigInteger.valueOf(i).modPow(
					BigInteger.valueOf(ds[i]), BigInteger.valueOf(MOD));
			res = res.multiply(temp).mod(BigInteger.valueOf(MOD));
		}

		System.out.println("Answer: " + res);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
