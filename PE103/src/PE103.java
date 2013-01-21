public class PE103 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int MAX = 50;
		int[] s = new int[7];
		int bestSum = Integer.MAX_VALUE;
		String bestSetString = "";

		for (int i1 = 1; i1 <= MAX; i1++)
			for (int i2 = i1 + 1; i2 <= MAX; i2++)
				for (int i3 = i2 + 1; i3 <= MAX; i3++)
					for (int i4 = i3 + 1; i4 <= MAX; i4++)
						for (int i5 = i4 + 1; i5 <= MAX; i5++)
							for (int i6 = i5 + 1; i6 <= MAX; i6++)
								for (int i7 = i6 + 1; i7 <= MAX; i7++) {
									s[0] = i1;
									s[1] = i2;
									s[2] = i3;
									s[3] = i4;
									s[4] = i5;
									s[5] = i6;
									s[6] = i7;

									if (isSpecialSumSet(s)) {
										int sum = s[0] + s[1] + s[2] + s[3]
												+ s[4] + s[5] + s[6];
										// System.out.println("Found one! {"+s[0]+","+s[1]+","+s[2]+","+s[3]+","+s[4]+","+s[5]+","+s[6]+"}");
										if (sum < bestSum) {
											bestSum = sum;
											bestSetString = "" + s[0] + s[1] + s[2] + s[3] + s[4] + s[5] + s[6];
										}
									}
								}

		System.out.println("Answer: " + bestSetString);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// determines if a seven element sorted array is a special sum set
	private static boolean isSpecialSumSet(int[] s) {

		if (s[0] + s[1] <= s[6])
			return false;
		if (s[0] + s[1] + s[2] <= s[5] + s[6])
			return false;
		if (s[0] + s[1] + s[2] + s[3] <= s[4] + s[5] + s[6])
			return false;

		for (int i1 = 0; i1 < 7; i1++)
			for (int i2 = i1 + 1; i2 < 7; i2++)
				for (int i3 = i2 + 1; i3 < 7; i3++)
					for (int i4 = i3 + 1; i4 < 7; i4++)
						if (s[i1] + s[i4] == s[i2] + s[i3])
							return false;

		for (int i1 = 0; i1 < 7; i1++)
			for (int i2 = i1 + 1; i2 < 7; i2++)
				for (int i3 = i2 + 1; i3 < 7; i3++)
					for (int i4 = i3 + 1; i4 < 7; i4++)
						for (int i5 = i4 + 1; i5 < 7; i5++)
							for (int i6 = i5 + 1; i6 < 7; i6++) {
								if (s[i1] + s[i5] + s[i6] == s[i2] + s[i3] + s[i4])
									return false;
								if (s[i1] + s[i4] + s[i6] == s[i2] + s[i3] + s[i5])
									return false;
								if (s[i1] + s[i4] + s[i5] == s[i2] + s[i3] + s[i6])
									return false;
								if (s[i1] + s[i3] + s[i6] == s[i2] + s[i4] + s[i5])
									return false;
								if (s[i1] + s[i2] + s[i6] == s[i3] + s[i4] + s[i5])
									return false;
							}

		return true;
	}
}
