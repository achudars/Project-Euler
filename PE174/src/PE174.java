public class PE174 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int laminae[] = new int[1000001];
		int i = 1;
		int counter = 0;
		while (i * i - (i - 2) * (i - 2) <= 1000000) {
			int j = i - 2;
			while (i * i - j * j <= 1000000 && j > 0) {
				laminae[i * i - j * j]++;
				j = j - 2;
			}
			i++;
		}
		for (int k = 1; k <= 1000000; k++) {
			if (laminae[k] >= 1 && laminae[k] <= 10)
				counter++;
		}
		System.out.println("Answer: " + counter);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
