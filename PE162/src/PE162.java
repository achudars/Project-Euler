public class PE162 {

	private static final int _NIL = 0;
	private static final int _0 = 1;
	private static final int _1 = 2;
	private static final int _A = 4;
	private static final long _powers[] = new long[15];

	static {
		_powers[0] = 16L;
		for (int k = 1; k < _powers.length; k++) {
			_powers[k] = 16 * _powers[k - 1];
		}
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out
				.println("Answer: " + Long.toHexString(count(_NIL, false, 16)).toUpperCase());

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static long count(int flags, boolean allowLeadingZero, int digits) {
		if (digits == 0) {
			if (flags == _0 + _1 + _A) {
				return 1;
			}
			return 0;
		}
		int k = digits - 1;
		switch (flags) {
		case _NIL:
			return (13 * count(_NIL, true, k))
					+ count(allowLeadingZero ? _0 : _NIL, allowLeadingZero, k)
					+ count(_1, true, k) + count(_A, true, k);
		case _0:
			return (14 * count(_0, true, k)) + count(_0 + _1, true, k)
					+ count(_0 + _A, true, k);
		case _1:
			return (14 * count(_1, true, k)) + count(_1 + _0, true, k)
					+ count(_1 + _A, true, k);
		case _0 + _1:
			return (15 * count(_0 + _1, true, k))
					+ count(_0 + _1 + _A, true, k);
		case _A:
			return (14 * count(_A, true, k)) + count(_A + _0, true, k)
					+ count(_A + _1, true, k);
		case _0 + _A:
			return (15 * count(_0 + _A, true, k))
					+ count(_0 + _1 + _A, true, k);
		case _1 + _A:
			return (15 * count(_1 + _A, true, k))
					+ count(_0 + _1 + _A, true, k);
		case _0 + _1 + _A:
			return _powers[k];
		}
		return 0L;
	}

}
