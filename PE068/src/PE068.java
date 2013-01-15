import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PE068 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int max = 10;

		Map<Integer, Set<List<Integer>>> arrangements = new HashMap<Integer, Set<List<Integer>>>();
		for (int a = 1; a <= max; a++) {
			for (int b = 1; b <= max; b++) {
				if (a == b) {
					continue;
				}
				for (int c = 1; c <= max; c++) {
					if (a == c || b == c) {
						continue;
					}
					for (int d = 1; d <= max; d++) {
						if (a == d || b == d || c == d) {
							continue;
						}
						for (int e = 1; e <= max; e++) {
							if (a == e || b == e || c == e || d == e) {
								continue;
							}
							for (int f = 1; f <= max; f++) {
								if (a == f || b == f || c == f || d == f
										|| e == f) {
									continue;
								}
								for (int g = 1; g <= max; g++) {
									if (a == g || b == g || c == g || d == g
											|| e == g || f == g) {
										continue;
									}
									for (int h = 1; h <= max; h++) {
										if (a == h || b == h || c == h
												|| d == h || e == h || f == h
												|| g == h) {
											continue;
										}
										for (int i = 1; i <= max; i++) {
											if (a == i || b == i || c == i
													|| d == i || e == i
													|| f == i || g == i
													|| h == i) {
												continue;
											}
											for (int j = 1; j <= max; j++) {
												if (a == j || b == j || c == j
														|| d == j || e == j
														|| f == j || g == j
														|| h == j || i == j) {
													continue;
												}
												int sum1 = a + c + e;
												int sum2 = b + e + h;
												if (sum1 != sum2) {
													continue;
												}
												int sum3 = i + h + g;
												if (sum1 != sum3) {
													continue;
												}
												int sum4 = j + g + d;
												if (sum1 != sum4) {
													continue;
												}
												int sum5 = f + d + c;
												if (sum1 != sum5) {
													continue;
												}

												List<Integer> ar = new ArrayList<Integer>();
												ar.add(a);
												ar.add(b);
												ar.add(c);
												ar.add(d);
												ar.add(e);
												ar.add(f);
												ar.add(g);
												ar.add(h);
												ar.add(i);
												ar.add(j);

												if (!arrangements
														.containsKey(sum1)) {
													Set<List<Integer>> arrangementset = new HashSet<List<Integer>>();
													arrangements.put(sum1,
															arrangementset);
												}
												arrangements.get(sum1).add(
														ar);

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

		// Remove arrangements without the numerically lowest external node
		for (Integer key : arrangements.keySet()) {
			int lowestExternalNode = max + 1;
			for (List<Integer> existingar : arrangements.get(key)) {
				if (existingar.get(0) < lowestExternalNode) {
					lowestExternalNode = existingar.get(0);
				}
			}

			Set<List<Integer>> arrangementsToRemove = new HashSet<List<Integer>>();
			for (List<Integer> existingar : arrangements.get(key)) {
				if (existingar.get(0) > lowestExternalNode) {
					arrangementsToRemove.add(existingar);
				}
			}
			arrangements.get(key).removeAll(arrangementsToRemove);
		}

		// Generate a list of string totals
		List<String> strings = new ArrayList<String>();
		for (Integer key : arrangements.keySet()) {
			System.out.println("Number of Digits: " + key);
			for (List<Integer> ar : arrangements.get(key)) {
				int a = ar.get(0);
				int b = ar.get(1);
				int c = ar.get(2);
				int d = ar.get(3);
				int e = ar.get(4);
				int f = ar.get(5);
				int g = ar.get(6);
				int h = ar.get(7);
				int i = ar.get(8);
				int j = ar.get(9);
				System.out.println("{[" + a + "," + c + "," + e + "]" +
						            "[" + b + "," + e + "," + h + "]" +
						            "[" + i + "," + h + "," + g + "]" +
						            "[" + j + "," + g + "," + d + "]" +
						            "[" + f + "," + d + "," + c + "]}");
				String string = "" + a + c + e + b + e + h + i + h + g + j + g + d + f + d + c;

				if (string.length() <= 16) {
					strings.add(string);
				}
			}
		}
		Collections.sort(strings);
		System.out.println("Answer: " + strings.get(strings.size() - 1));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
