public class PE118 {

	private static int[] lengths;

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[] arr = new int[9];
		lengths = new int[9];
		permute(0, arr, 0);
		int count = 0;
		int fact = 1;
		for (int i = 1; i < 9; i++) {
			fact *= i;
			count += lengths[i] / fact;
		}
		System.out.println("Answer: " + count);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static void permute(int n, int[] arr, int visited) {
		if (n == 9) {
			test(arr, 0, 0);
			return;
		}
		for (int i = 1; i <= 9; i++)
			if ((visited & (1 << i)) == 0) {
				arr[n] = i;
				permute(n + 1, arr, visited | 1 << i);
			}
	}

	private static void test(int[] arr, int i, int len) {
		if (i == arr.length) {
			lengths[len]++;
			return;
		}
		int num = 0;
		for (; i < arr.length; i++) {
			num = num * 10 + arr[i];
			if (isPrime(num))
				test(arr, i + 1, len + 1);
		}
	}

	private static boolean isPrime(int num) {
		if (num == 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

}
