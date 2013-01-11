import java.util.SortedSet;
import java.util.TreeSet;

public class PE043 {

	// I'm using sorted set because I like it
	static SortedSet<String> elements = new TreeSet<String>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Long sum = 0L;

		permutation("0123456789");

		for (String item : elements) {
			sum += Long.parseLong(item);
		}

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			// System.out.println(prefix);
			String by2, by3, by5, by7, by11, by13, by17 = "";
			by2 = prefix.substring(1, 4);
			by3 = prefix.substring(2, 5);
			by5 = prefix.substring(3, 6);
			by7 = prefix.substring(4, 7);
			by11 = prefix.substring(5, 8);
			by13 = prefix.substring(6, 9);
			by17 = prefix.substring(7, 10);

			if (Integer.parseInt(by17) % 17 == 0) {
				if (Integer.parseInt(by13) % 13 == 0) {
					if (Integer.parseInt(by11) % 11 == 0) {
						if (Integer.parseInt(by7) % 7 == 0) {
							if (Integer.parseInt(by5) % 5 == 0) {
								if (Integer.parseInt(by3) % 3 == 0) {
									if (Integer.parseInt(by2) % 2 == 0) {
										elements.add(prefix);
									}
								}
							}
						}
					}
				}
			}

			// }
		} else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}

}
