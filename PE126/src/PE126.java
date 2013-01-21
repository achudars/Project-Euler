public class PE126 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int n = 30000;
		int[] sms = new int[n + 1];
		for (int a = 1; 2 * a * a <= n; a++) {
			for (int b = a; 2 * a * b <= n; b++) {
				inner: for (int c = b;; c++) {

					for (int lyr = 1;; lyr++) {
						int cubes = 0;
						// top and bottom
						cubes += 2 * (a * b);
						int curLyrCubes = 2 * (a + b);
						for (int k = 0; k < lyr - 1; k++) {
							cubes += 2 * curLyrCubes;
							curLyrCubes += 4;
						}
						cubes += c * curLyrCubes;

						if (cubes > n) {
							if (lyr == 1)
								break inner;
							break;
						}
						sms[cubes]++;
					}
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			if (sms[i] != 0)
				//System.out.println(i + " " + sms[i]);
			if (sms[i] == 1000) {
				System.out.println("Answer: " + i);
				break;
			}
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
