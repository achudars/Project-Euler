import java.math.BigInteger;

public class PE116 {

	private static final int BLOCK_SIZE = 50;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: "
				+ findAll(2).add(findAll(3)).add(findAll(4)));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static BigInteger findAll(int length) {
		BigInteger result = new BigInteger("0");
		for (int amount = 1; amount <= (BLOCK_SIZE / length); amount++) {
			long n = BLOCK_SIZE + (1 - length) * amount;
			result = result.add(choose(n, amount));
		}
		return result;
	}

	public static BigInteger choose(long n, long r) {
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < r; i++)
			result = result.multiply(BigInteger.valueOf(n - i));
		for (int i = 0; i < r; i++)
			result = result.divide(BigInteger.valueOf(r - i));
		return result;
	}

}
