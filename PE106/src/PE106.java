
public class PE106 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int result = 0;
        int n = 12;

        for (int i = 2; i <= n / 2; i++) {
            result += choose(n, i) * choose(n - i, i) / 2;
            result -= choose(n, 2 * i) * catalanNumber(i);
        }

        System.out.printf("Answer: %d ", result);

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static int catalanNumber(int n) {
        return choose(2 * n, n) / (n + 1);
    }

    public static int choose(int n, int k) {
        k = Math.min(k, n - k);

        int res = 1;
        for (int i = 1; i <= k; i++) {
            res *= n - k + i;
            res /= i;
        }

        return res;
    }

	
}
