import java.util.TreeMap;

public class PE158 {

	private static TreeMap<Key, Long> map = new TreeMap<Key, Long>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long max = 0;

		for (int i = 1; i <= 26; i++) {
			if (p(i) > max) {
				max = p(i);
			}
		}
		System.out.println("Answer: " + max);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long p(int n) {

		long sum = 0;
		for (int i = 1; i <= 26; i++) {
			sum += numWays(i - 1, 26 - i, n - 1, true);
		}
		return sum;
	}

	public static long numWays(int numLessThanLast, int numsGreaterThanLast,
			int numsLeft, boolean canPickGreater) {

		Key k = new Key(numLessThanLast, numsGreaterThanLast, numsLeft,
				canPickGreater);
		if (map.containsKey(k))
			return map.get(k);

		if (numLessThanLast < 0 || numsGreaterThanLast < 0)
			return 0;

		if (numsLeft == 0) {
			if (canPickGreater)
				return 0;
			return 1;
		}

		long sum = 0;

		for (int i = 1; i <= numLessThanLast; i++) {
			sum += numWays(i - 1, numLessThanLast - i + numsGreaterThanLast,
					numsLeft - 1, canPickGreater);
		}

		if (canPickGreater) {
			for (int i = 1; i <= numsGreaterThanLast; i++) {
				sum += numWays(i - 1 + numLessThanLast,
						numsGreaterThanLast - i, numsLeft - 1, false);
			}
		}

		map.put(k, sum);
		return sum;
	}
}

class Key implements Comparable<Key> {
	private int less, more, left;
	private boolean canPick;

	public Key(int l, int m, int le, boolean c) {
		less = l;
		more = m;
		left = le;
		canPick = c;
	}

	public int compareTo(Key other) {
		if (less == other.less) {
			if (more == other.more) {
				if (left == other.left) {
					if (canPick == other.canPick)
						return 0;
					else if (canPick)
						return 1;
					else
						return -1;
				}
				return left - other.left;
			}
			return more - other.more;
		}
		return less - other.less;
	}

}
