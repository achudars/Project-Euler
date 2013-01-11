import java.util.SortedSet;
import java.util.TreeSet;

public class PE044 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// set maximum to test the results against
		int result = Integer.MAX_VALUE;
		int i = 1;
		SortedSet<Integer> elements = new TreeSet<Integer>();
		// fill the elements with the first 10 million numbers
		int number = calculatePentagon(i);
		while (number < 10000000) {
			elements.add(number);
			++i;
			number = calculatePentagon(i);
		}

		// for better traversal
		Integer[] array = new Integer[elements.size()];
		array = elements.toArray(array);

		// check every pentagonal number against each other
		for (int j = 0; j < array.length; ++j) {
			for (int k = j; k < array.length; ++k) {
				// check if |P(j) - P(k)| and P(j) + P(k) are also pentagonal
				int sub = Math.abs(array[k] - array[j]);
				int add = array[j] + array[k];

				if (elements.contains(sub) && elements.contains(add)) {
					if (result > Math.abs(array[j] + array[k]))
						result = Math.abs(array[j] - array[k]);
				}
			}
		}

		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static int calculatePentagon(int n) {
		return (n * (3 * n - 1)) / 2;
	}

	public static boolean isPentagonal(int value) {
		int i = 0;
		while (value >= i) {
			i = i + 1;
			if (value == calculatePentagon(i)) {
				return true;
			}
		}
		return false;
	}
}
