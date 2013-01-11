import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class PE047 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int answer = 0;

		for (int i = 100000; i < 1000000; i++) {
			if (primeFactors(i).size() == 4 && primeFactors(i + 1).size() == 4
					&& primeFactors(i + 2).size() == 4
					&& primeFactors(i + 3).size() == 4) {
				System.out.println("[" + i + "," + (i + 1) + "," + (i + 2)
						+ "," + (i + 3) + "]");
				for (Integer integer : primeFactors(i)) {
					System.out.println(" " + integer);
				}
				for (Integer integer : primeFactors(i + 1)) {
					System.out.println("      " + integer);
				}
				for (Integer integer : primeFactors(i + 2)) {
					System.out.println("           " + integer);
				}
				for (Integer integer : primeFactors(i + 3)) {
					System.out.println("               " + integer);
				}
				System.out.println("-------");
				answer = i;
				break;
			}
		}

		System.out.println("Answer: " + answer);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static List<Integer> primeFactors(int number) {
		int n = number;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		// remove duplicates and sort
		SortedSet<Integer> foo = new TreeSet<Integer>(factors);
		factors = new ArrayList<Integer>(foo);
		return factors;
	};
}
