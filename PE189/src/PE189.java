import static java.lang.Math.min;

public class PE189 {

	static long[][] count = new long[9][];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int limit = 8;
		if (args.length > 0) {
			limit = Integer.parseInt(args[0]);
		}

		long result = solve("", limit);

		System.out.println("Answer: " + result + " (limit = " + limit + ")");

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long solve(String in, int limit) // in = AAA
	{
		long result = 0;
		int len = in.length();
		if (count[len] == null)
			count[len] = new long[upper(3, len)];
		if (len == 0) {
			result += solve("0", limit);
			result += solve("1", limit);
			result += solve("2", limit);
		} else if (len < limit) {
			char[] above = in.toCharArray(); // above = AAA
			int z = 0;
			int inverted = 0;
			for (int i = 0; i < len; i++) {
				z = z * 3;
				z = z + ((3 - (above[0]) + (above[i])) % 3);
				inverted = inverted * 3;
				inverted = inverted
						+ ((3 - (above[len - 1]) + (above[len - 1 - i])) % 3);
			}
			z = min(z, inverted);
			if (count[len][z] == 0) {
				for (int i = 0; i < upper(2, len); i++) {
					char[] below = new char[len]; // below = VVV
					int k = i;
					for (int j = 0; j < len; j++) {
						int add = k % 2;
						k = k >> 1;
						below[j] = (char) ((above[j] + 1 + add) % 3 + '0');
					}
					result += solveB("", below, limit);
				}
				count[len][z] = result;
			} else
				result = count[len][z];
		} else {
			result += 1L;
		}
		return result;
	}

	public static long solveB(String in, char[] below, int limit) {
		long result = 0;
		int len = in.length();
		if (len == below.length) {
			result += solve(in + (char) (((int) below[len - 1] + 1) % 3 + '0'),
					limit);
			result += solve(in + (char) (((int) below[len - 1] + 2) % 3 + '0'),
					limit);
		} else if (len == 0 || below[len - 1] == below[len]) {
			result += solveB(in + (char) (((int) below[len] + 1) % 3 + '0'),
					below, limit);
			result += solveB(in + (char) (((int) below[len] + 2) % 3 + '0'),
					below, limit);
		} else {
			// 0, 1 -> 2
			// 0, 2 -> 1
			// 1, 2 -> 0
			result += solveB(
					in
							+ (char) ((99 - (int) (below[len - 1] + below[len])) % 3 + '0'),
					below, limit);
		}
		return result;
	}

	public static int upper(int i, int j) {
		if (j == 0)
			return 1;
		int result = 1;
		for (int k = 0; k < j; k++)
			result = result * i;
		return result;
	}

}
