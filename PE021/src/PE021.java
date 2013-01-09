
public class PE021 {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i < 10000; i++) {
			if (isAmicable(i)) {
				sum += i;
				//System.out.println("AMICABLE: " + i);
			}
		}
		System.out.println("Answer: " + sum);
	}

	public static boolean isAmicable(int n) {
		boolean result = false;
		if (n == getFactors(getFactors(n)) && getFactors(n) != n) {
			result = true;
		}
		return result;
	};

	public static int getFactors(int n) {

		int numberOfFactors = 0;
		int result = 0;

		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				//System.out.print(i + "  ");
				numberOfFactors++;
				result = result + i;
			}
		}
		//System.out.println("\nSum of Factors for number " + n + " : " + result);
		// System.out.println("Number of Factors: " + numberOfFactors);

		return result;
	};
}
