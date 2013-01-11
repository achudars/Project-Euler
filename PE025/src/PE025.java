import java.math.BigInteger;
import java.util.ArrayList;

public class PE025 {

	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	static {
		fibCache.add(BigInteger.ZERO);
		fibCache.add(BigInteger.ONE);
	}
	static String fibTerm = "";

	public static BigInteger fib(int n) {
		if (n >= fibCache.size()) {
			fibCache.add(n, fib(n - 1).add(fib(n - 2)));
		}

		return fibCache.get(n);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for (int i = 0;; i++) {
			System.out.print(fib(i) + ", ");
			fibTerm = fib(i).toString();
			if (fibTerm.length() == 1000) {
				// Fibonacci term order
				System.out.println("\n Answer: " + i);
				// The value (all digits):
				// System.out.println("\n Answer: " + fibTerm);
				break;
			}
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	};
};