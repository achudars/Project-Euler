import java.math.BigInteger;

public class PE097 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// create 2 BigInteger objects

		BigInteger a = new BigInteger("2");
		BigInteger mod = new BigInteger("10000000000");
		a = a.modPow(new BigInteger("7830457"), mod).multiply(new BigInteger("28433")).add(BigInteger.ONE).mod(mod);
		System.out.println("Answer: " + a);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
