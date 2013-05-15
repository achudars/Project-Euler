import java.math.BigInteger;

public class PE168 {

	private static final BigInteger TWO = BigInteger.valueOf(2);
	private static final BigInteger TEN = BigInteger.valueOf(10);
	private static final BigInteger HUNDRED_THOUSAND = BigInteger
			.valueOf(100000);

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		BigInteger total = BigInteger.ZERO;

		long time = -System.currentTimeMillis();
		for (int pow = 1; pow < 101; pow++) {
			for (BigInteger a = BigInteger.ONE; a.compareTo(TEN) < 0; a = a
					.add(BigInteger.ONE)) {
				for (BigInteger n = BigInteger.ONE; n.compareTo(TEN) < 0; n = n
						.add(BigInteger.ONE)) {
					final BigInteger denom = ((TEN.pow(pow)).subtract(n))
							.multiply(a);
					final BigInteger div = (TEN.multiply(n))
							.subtract(BigInteger.ONE);

					if (denom.mod(div).equals(BigInteger.ZERO)) {
						final BigInteger num = denom.divide(div);
						if (num.toString().length() == pow) {
							final BigInteger value = new BigInteger("" + num
									+ a);
							if (value.toString().length() <= 100) {
								total = total.add(value);
							}
						}
					}
				}
			}
		}

		System.out.println("Answer: " + total.mod(HUNDRED_THOUSAND));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
