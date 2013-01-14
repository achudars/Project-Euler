import java.util.HashMap;
import java.util.TreeSet;

public class PE062 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		TreeSet entries = new TreeSet();
		HashMap map = new HashMap();
		// Start at 0 and cube each number.
		for (long i = 0;; i++) {
			long cube = i * i * i;
			Long cubedNumber = new Long(cube);
			double digitCounter = 0;
			// Count up the amount of each digit appearing in the cubed number
			// (i.e., - 41063625 would have one 0, one 1, one 2, one 3, one 4, one
			// 5, and two 6s).
			for (; cube > 0; cube /= 10)
				digitCounter += Math.pow(10, cube % 10);
			// Create a counter number with the amount of 0s in the ones place,
			// amount of 1s in the tens place, 2s in the hundreds place, etc.
			// (i.e - 41063625 would be 2111111).
			Double counter = new Double(digitCounter);
			// Plug this into a HashMap with this counter as the key and a list
			// of found permutations as the value.
			// In this way, 2111111 would map to 41063625 as well as 66430125
			// and 41063625.
			entries = (TreeSet) map.get(counter);
			if (entries == null)
				entries = new TreeSet();

			entries.add(cubedNumber);
			// Continue adding to the HashMap until one of the lists contains 5
			// permutations.
			// Break out of the loop and display the smallest permutation.
			if (entries.size() == 5)
				break;

			map.put(counter, entries);
		}
		System.out.println("Answer: " + (Long) entries.first());

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}