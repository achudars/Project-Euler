import java.util.Arrays;

public class PE122 {

	static final int MAX = 200;
	static int[] path = new int[MAX + 1];
	static int[] min = new int[MAX + 1];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		Arrays.fill(min, 1000000000);

		// build a tree of possible powers, keeping track on the shortest found.
		populate(1, 0);

		int k = 0;
		for (int i = 1; i <= MAX; i++) {
			k += min[i];
		}

		System.out.println("Answer: " + k);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	static void populate(int start, int depth) {
		if (start >= min.length)
			return;
		if (depth < min[start]) {
			min[start] = depth;
		} else if (depth > min[start])
			return;
		path[depth] = start;
		for (int i = depth; i >= 0; i--) {
			populate(start + path[i], depth + 1);
		}
	}
}
