public class PE090 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println(getAllDice());

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long getAllDice() {
		long count = 0;

		for (Integer a = 0; a <= 9; a++)
			for (Integer b = a + 1; b <= 9; b++)
				for (Integer c = b + 1; c <= 9; c++)
					for (Integer d = c + 1; d <= 9; d++)
						for (Integer e = d + 1; e <= 9; e++)
							for (Integer f = e + 1; f <= 9; f++)
								for (Integer g = 0; g <= 9; g++)
									for (Integer h = g + 1; h <= 9; h++)
										for (Integer i = h + 1; i <= 9; i++)
											for (Integer j = i + 1; j <= 9; j++)
												for (Integer k = j + 1; k <= 9; k++)
													for (Integer l = k + 1; l <= 9; l++) {
														String d1 = a
																.toString()
																+ b.toString()
																+ c.toString()
																+ d.toString()
																+ e.toString()
																+ f.toString();
														String d2 = g
																.toString()
																+ h.toString()
																+ i.toString()
																+ j.toString()
																+ k.toString()
																+ l.toString();
														if (IsValid(d1, d2)) {
															count++;
														}
													}
		// get rid of the duplicates
		return count / 2;
	}

	private static boolean IsValid(String d1, String d2) {
		if (!((d1.contains("0") && d2.contains("1")) || (d2.contains("0") && d1
				.contains("1"))))
			return false;

		if (!((d1.contains("0") && d2.contains("4")) || (d2.contains("0") && d1
				.contains("4"))))
			return false;

		if (!((d1.contains("0") && (d2.contains("6") || d2.contains("9"))) || (d2
				.contains("0") && (d1.contains("6") || d1.contains("9")))))
			return false;

		if (!((d1.contains("1") && (d2.contains("6") || d2.contains("9"))) || (d2
				.contains("1") && (d1.contains("6") || d1.contains("9")))))
			return false;

		if (!((d1.contains("2") && d2.contains("5")) || (d2.contains("2") && d1
				.contains("5"))))
			return false;

		if (!((d1.contains("3") && (d2.contains("6") || d2.contains("9"))) || (d2
				.contains("3") && (d1.contains("6") || d1.contains("9")))))
			return false;

		if (!((d1.contains("4") && (d2.contains("6") || d2.contains("9"))) || (d2
				.contains("4") && (d1.contains("6") || d1.contains("9")))))
			return false;

		if (!((d1.contains("8") && d2.contains("1")) || (d2.contains("8") && d1
				.contains("1"))))
			return false;

		return true;
	}

}
