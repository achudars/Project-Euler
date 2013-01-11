import java.util.Arrays;

public class PE024 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int arrangement[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 1; i < 1000000; permutate(arrangement), ++i)
			;
		System.out.print("Answer: " + Arrays.toString(arrangement));

		long endTime = System.nanoTime();
		System.out.printf("\nTotal Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	static boolean permutate(int arrangement[]) {
		for (int n = arrangement.length - 1, i = n, j; i > 0;)
			if (arrangement[i--] > arrangement[i]) {
				for (j = n; arrangement[j] <= arrangement[i]; j--) {

				}
				arrangement[j] = arrangement[j] ^ arrangement[i]
						^ (arrangement[i] = arrangement[j]);
				for (j = i, i = n + i >> 1; ++j <= i; arrangement[j] = arrangement[j]
						^ arrangement[n] ^ (arrangement[n--] = arrangement[j])) {

				}
				return true;
			}
		return false;
	}
}