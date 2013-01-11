import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

public class PE029 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigInteger value = BigInteger.ZERO;
		long distinctTerms = 0;
		SortedSet<BigInteger> elements = new TreeSet<BigInteger>();

		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				value = BigInteger.valueOf(a).pow(b);
				elements.add(value);
			}
			distinctTerms += elements.size();
		}

		System.out.println("Answer: " + elements.size());
		System.out.println("distinctTerms: " + distinctTerms);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
