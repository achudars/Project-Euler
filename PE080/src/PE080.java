import java.math.BigDecimal;
import java.math.BigInteger;

public class PE080 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigDecimal HUNDRED = new BigDecimal(Math.pow(10, 99) + "");

		Integer sum = 0;

		for (double i = 1; i <= 100; i++) {
			double result = Math.sqrt(i);
			boolean isSquare = result % 1 == 0;
			
			if (!isSquare) {
				sum += sumOfDecimals(HUNDRED.multiply(SUPERPRECISEsqrt(BigDecimal.valueOf((int) i), 1000)).toBigInteger());
			}
		}

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static BigDecimal SUPERPRECISEsqrt(BigDecimal x, int scale) {
		// Check that x >= 0.
		if (x.signum() < 0) {
			throw new IllegalArgumentException("x < 0");
		}

		// n = x*(10^(2*scale))
		BigInteger n = x.movePointRight(scale << 1).toBigInteger();

		// The first approximation is the upper half of n.
		int bits = (n.bitLength() + 1) >> 1;
		BigInteger ix = n.shiftRight(bits);
		BigInteger ixPrev;

		// Loop until the approximations converge
		// (two successive approximations are equal after rounding).
		do {
			ixPrev = ix;

			// x = (x + n/x)/2
			ix = ix.add(n.divide(ix)).shiftRight(1);

			Thread.yield();
		} while (ix.compareTo(ixPrev) != 0);

		return new BigDecimal(ix, scale);
	}

	public static int sumOfDecimals(BigInteger n) {
		BigInteger TEN = new BigInteger("10");
		BigInteger sum = BigInteger.ZERO;
		while (n.compareTo(BigInteger.ZERO) > 0) {

			BigInteger p = n.mod(TEN);
			sum = sum.add(p);
			n = n.divide(TEN);
		}
		return sum.intValue();
	}
}
