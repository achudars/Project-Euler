public class PE170 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + solve(9, 0, 0, 0));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	private static long solve(long c, long s0, long s1, long s2) {
		long max = 0;
		if (c == 0) {
			for (int i = 1; i <= (s0 == 0 ? 0 : (long) Math.log10(s0)); i++) {
				max = Math
						.max(max,
								checkPandigital(s0 == 0 ? c : insert(s0, c, i),
										s1, s2));
			}
			for (int i = 1; i <= (s1 == 0 ? 0 : (long) Math.log10(s1)); i++) {
				max = Math
						.max(max,
								checkPandigital(s0,
										s1 == 0 ? c : insert(s1, c, i), s2));
			}
			for (int i = 1; i <= (s2 == 0 ? 0 : (long) Math.log10(s2)); i++) {
				max = Math
						.max(max,
								checkPandigital(s0, s1,
										s2 == 0 ? c : insert(s2, c, i)));
			}
		} else {
			for (int i = 0; i <= (s0 == 0 ? 0 : (long) Math.log10(s0)); i++) {
				max = Math.max(
						max,
						solve((char) (c - 1), s0 == 0 ? c : insert(s0, c, i),
								s1, s2));
			}
			for (int i = 0; i <= (s1 == 0 ? 0 : (long) Math.log10(s1)); i++) {
				max = Math.max(
						max,
						solve((char) (c - 1), s0, s1 == 0 ? c
								: insert(s1, c, i), s2));
			}
			for (int i = 0; i <= (s2 == 0 ? 0 : (long) Math.log10(s2)); i++) {
				max = Math.max(
						max,
						solve((char) (c - 1), s0, s1,
								s2 == 0 ? c : insert(s2, c, i)));
			}
		}
		return max;
	}

	private static long checkPandigital(long s0, long s1, long s2) {
		if (s0 == 0 || s1 == 0 || s2 == 0) {
			return 0;
		}
		long p0 = s0 * s1;
		long p1 = s0 * s2;
		if ((long) Math.log10(p0) + (long) Math.log10(p1) != 8) {
			return 0;
		}
		boolean[] digits = new boolean[10];
		for (long tmp = p0; tmp > 0; tmp /= 10) {
			digits[(int) (tmp % 10)] = true;
		}
		for (long tmp = p1; tmp > 0; tmp /= 10) {
			digits[(int) (tmp % 10)] = true;
		}
		for (boolean b : digits) {
			if (!b) {
				return 0;
			}
		}
		return p0 * (long) Math.pow(10, (long) Math.log10(p1) + 1) + p1;
	}

	private static long insert(long target, long source, long insertIndex) {
		long pow = (long) Math
				.pow(10, (target == 0 ? 0 : (long) Math.log10(target)) + 1
						- insertIndex);
		return target % pow + source * pow + target / pow * pow * 10;
	}

}
