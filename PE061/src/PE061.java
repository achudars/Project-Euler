import java.util.Arrays;

public class PE061 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long start = System.currentTimeMillis();

		boolean[][] triangleNumbers = new boolean[100][100];
		boolean[][] squareNumbers = new boolean[100][100];
		boolean[][] pentagonalNumbers = new boolean[100][100];
		boolean[][] hexagonalNumbers = new boolean[100][100];
		boolean[][] heptagonalNumbers = new boolean[100][100];
		boolean[][] octagonalNumbers = new boolean[100][100];

		for (int i = 0; i < 100; i++) {
			Arrays.fill(triangleNumbers[i], false);
			Arrays.fill(squareNumbers[i], false);
			Arrays.fill(pentagonalNumbers[i], false);
			Arrays.fill(hexagonalNumbers[i], false);
			Arrays.fill(heptagonalNumbers[i], false);
			Arrays.fill(octagonalNumbers[i], false);
		}
		int n = 0;
		// generating values in tables
		while (calculateTriangle(n) < 10000) {
			int value = calculateTriangle(n);
			if (value / 100 >= 10 && value % 100 >= 10 && value < 10000) {
				triangleNumbers[value / 100][value % 100] = true;
			}
			value = calculateSquare(n);
			if (value / 100 >= 10 && value % 100 >= 10 && value < 10000) {
				squareNumbers[value / 100][value % 100] = true;
			}
			value = calculatePentagon(n);
			if (value / 100 >= 10 && value % 100 >= 10 && value < 10000) {
				pentagonalNumbers[value / 100][value % 100] = true;
			}
			value = calculateHexagon(n);
			if (value / 100 >= 10 && value % 100 >= 10 && value < 10000) {
				hexagonalNumbers[value / 100][value % 100] = true;
			}
			value = calculateHeptagon(n);
			if (value / 100 >= 10 && value % 100 >= 10 && value < 10000) {
				heptagonalNumbers[value / 100][value % 100] = true;
			}
			value = calculateOctagon(n);
			if (value / 100 >= 10 && value % 100 >= 10 && value < 10000) {
				octagonalNumbers[value / 100][value % 100] = true;
			}
			n++;
		}
		// finds cycles
		boolean[][][] tables = new boolean[5][][];
		tables[0] = squareNumbers;
		tables[1] = pentagonalNumbers;
		tables[2] = hexagonalNumbers;
		tables[3] = heptagonalNumbers;
		tables[4] = octagonalNumbers;
		int total = 0;
		for (int i = 0; i < 100 && total == 0; i++) {
			for (int j = 0; j < 100 && total == 0; j++) {
				if (triangleNumbers[i][j]) {
					for (int a = 0; a < tables.length && total == 0; a++) {
						for (int k = 0; k < 100 && total == 0; k++) {
							if (tables[a][j][k]) {
								for (int b = 0; b < tables.length && total == 0; b++) {
									if (b == a) {
										continue;
									}
									for (int l = 0; l < 100 && total == 0; l++) {
										if (tables[b][k][l]) {
											for (int c = 0; c < tables.length
													&& total == 0; c++) {
												if (c == a || c == b) {
													continue;
												}
												for (int m = 0; m < 100
														&& total == 0; m++) {
													if (tables[c][l][m]) {
														for (int d = 0; d < tables.length
																&& total == 0; d++) {
															if (d == a
																	|| d == b
																	|| d == c) {
																continue;
															}
															for (int o = 0; o < 100
																	&& total == 0; o++) {
																if (tables[d][m][o]) {
																	for (int e = 0; e < tables.length
																			&& total == 0; e++) {
																		if (e == a
																				|| e == b
																				|| e == c
																				|| e == d) {
																			continue;
																		}
																		if (tables[e][o][i]) {
																			// solution
																			// found
																			total = (i
																					+ j
																					+ k
																					+ l
																					+ m + o) * 101;
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Answer: " + total);
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// pentagonal number calculation
	public static int calculateTriangle(int n) {
		return (n * (n + 1)) / 2;
	}

	// pentagonal number calculation
	public static int calculateSquare(int n) {
		return (n * n);
	}

	// pentagonal number calculation
	public static int calculatePentagon(int n) {
		return (n * (3 * n - 1)) / 2;
	}

	// hexagonal number calculation
	public static int calculateHexagon(int n) {
		return (n * (2 * n - 1));
	}

	// hexagonal number calculation
	public static int calculateHeptagon(int n) {
		return (n * (5 * n - 3)) / 2;
	}

	// hexagonal number calculation
	public static int calculateOctagon(int n) {
		return (n * (3 * n - 2));
	}
}
