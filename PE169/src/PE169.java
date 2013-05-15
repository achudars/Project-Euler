import java.math.BigInteger;

public class PE169 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		BigInteger bi = new BigInteger("10000000000000000000000000");
		long a = 1;
		long b = 0;
		for (int i = bi.bitLength(); i > 0; i--) {
			if (bi.testBit(i))
				b += a;
			else
				a += b;
		}
		System.out.println("Answer: " + (a + b));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
