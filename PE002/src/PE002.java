import java.math.BigInteger;
import java.util.ArrayList;

public class PE002 {

	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	static {
		fibCache.add(BigInteger.ZERO);
		fibCache.add(BigInteger.ONE);
	}

	public static BigInteger fib(int n) {
		if (n >= fibCache.size()) {
			fibCache.add(n, fib(n - 1).add(fib(n - 2)));
		}
		return fibCache.get(n);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigInteger fourMillion = new BigInteger("4000000");
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i <= 46; i++) {
			// compares if the Fibonacci value is smaller/greater or equal to 4'000'000
			switch (fib(i).compareTo(fourMillion)) {
			case -1:
				//System.out.println(fib(i) + " is less than " + fourMillion);
				// checks if the Fibonacci value is EVEN
				if (fib(i).getLowestSetBit() != 0){
					sum = sum.add(fib(i));
				}
				break;
			case 0:
				//System.out.println(fib(i) + " is equal to " + fourMillion);
				break;
			case 1:
				//System.out.println(fib(i) + " is greater than " + fourMillion);
				break;
			}
		}
		// print sum of all Fibonacci values that are less than 4'000'000 and are even
		System.out.println("Answer: " + sum);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	};
};