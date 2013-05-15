import java.math.BigInteger;
import java.util.TreeSet;

public class PE171 {

	private static TreeSet<Integer> squares = new TreeSet<Integer>();
	private static int MAX_POW = 20;
	private static BigInteger numer = bigFactorial(MAX_POW - 1);
	private static BigInteger allOnes = BigInteger.ONE;
	private static BigInteger sum = BigInteger.ZERO;
	private static BigInteger mod = new BigInteger("1000000000");

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		for (int i = 1; i <= 42; i++)
			squares.add(i * i);

		for (int i = 1; i < MAX_POW; i++)
			allOnes = allOnes.multiply(new BigInteger("10"))
					.add(BigInteger.ONE);

		search(new int[MAX_POW], 0, 1, 0);

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static void search(int[] digits, int sumSoFar, int currentNum,
			int index) {
		if (index >= digits.length)
			return;

		for (int i = currentNum; i <= 9; i++) {
			digits[index] = i;
			sumSoFar += i * i;

			if (squares.contains(sumSoFar))
				sum = sum.add(sumWays(digits)).mod(mod);

			search(digits, sumSoFar, i, index + 1);

			sumSoFar -= i * i;
		}

		digits[index] = 0;
	}

	public static BigInteger sumWays(int[] digits) {
		int[] count = new int[10];

		for (int d : digits)
			count[d]++;

		BigInteger value = BigInteger.ZERO;

		for (int d = 0; d < count.length; d++) {

			if (count[d] != 0) {
				BigInteger numTimesInSpot = numer;
				for (int i = 0; i < count.length; i++) {
					if (i != d)
						numTimesInSpot = numTimesInSpot
								.divide(bigFactorial(count[i]));
					else
						numTimesInSpot = numTimesInSpot
								.divide(bigFactorial(count[i] - 1));

				}

				value = value.add(numTimesInSpot.multiply(allOnes).multiply(
						new BigInteger(d + "")));
			}
		}

		return value;

	}

	public static BigInteger bigFactorial(int n) {
		BigInteger big = BigInteger.ONE;

		for (int i = 2; i <= n; i++)
			big = big.multiply(new BigInteger(i + ""));

		return big;
	}

}
