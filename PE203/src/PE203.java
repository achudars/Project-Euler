public class PE203 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long[][] arr = new long[51][51];
		long sum = 0;
		for (int a = 0; a < arr.length; ++a)
			for (int b = 0; b < arr[a].length; ++b)
				arr[a][b] = b == 0 ? 1 : 0;
		for (int a = 1; a < arr.length; ++a)
			for (int b = 1; b <= a; ++b)
				arr[a][b] = arr[a - 1][b - 1] + arr[a - 1][b];
		for (int a = 0; a < arr.length; ++a)
			for (int b = 0; b < arr[a].length; ++b) {
				for (int c = 0; c <= a; ++c)
					for (int d = 0; d <= (c == a ? b - 1 : c); ++d)
						arr[a][b] = arr[a][b] == arr[c][d] ? 0 : arr[a][b];
				for (long c = 2; c * c <= arr[a][b]; ++c)
					arr[a][b] = arr[a][b] % (c * c) == 0 ? 0 : arr[a][b];
				sum += arr[a][b];
			}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
