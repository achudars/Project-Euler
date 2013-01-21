import java.math.BigInteger;

public class PE121 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int turns = 15;
		BigInteger array[] = new BigInteger[turns + 1];
		for (int i = 0; i <= turns; i++) {
			if (i > turns - i)
				array[i] = BigInteger.ONE;
			else
				array[i] = BigInteger.ZERO;
		}
		for (int i = turns - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--)
				array[i - j] = array[i - j + 1].add(BigInteger.valueOf(i + 1)
						.multiply(array[i - j]));
		}
		BigInteger div = BigInteger.ONE;
		for (int i = 2; i <= turns + 1; i++)
			div = div.multiply(BigInteger.valueOf(i));
		System.out.println("Answer: " + div.divide(array[0]));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
