import java.math.BigInteger;
import java.util.HashMap;

public class PE137 {

	private static HashMap<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();
	
	private static BigInteger TWO = new BigInteger("2");
	private static BigInteger ONE = BigInteger.ONE;
	private static BigInteger ZERO = BigInteger.ZERO;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		
		BigInteger  nugget = new BigInteger("1");
		
		for(Integer i=1; i<=15; i++){
			Integer a = i*2;
			Integer b = i*2+1;
			
			nugget = fibonacci(new BigInteger(a.toString())).multiply(fibonacci(new BigInteger(b.toString())));
			System.out.println(i + ". NUGGET: " + nugget);
		}
		
		System.out.println("Answer: " + nugget);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static BigInteger fibonacci(BigInteger n) {
		if (n.equals(ZERO))
			return ZERO;
		if (n.equals(ONE))
			return ONE;
		if (cache.containsKey(n))
			return cache.get(n);

		// odd
		if (n.testBit(0)) {
			BigInteger n2 = n.shiftRight(1);
			BigInteger n3 = n2.add(ONE);
			BigInteger result = fibonacci(n2).multiply(fibonacci(n2)).add(
					fibonacci(n3).multiply(fibonacci(n3)));
			cache.put(n, result);
			return result;
		}

		// even
		else {
			BigInteger n2 = n.shiftRight(1);
			BigInteger n3 = n2.subtract(ONE);
			BigInteger result = fibonacci(n2).multiply(
					fibonacci(n2).add(fibonacci(n3).add(fibonacci(n3))));
			cache.put(n, result);
			return result;
		}
	}
}
