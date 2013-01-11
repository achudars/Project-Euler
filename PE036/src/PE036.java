public class PE036 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i < 1000000; i++) {
			if (isPalindrome(Integer.toString(i))
					&& isPalindrome(Integer.toBinaryString(i)))
				sum += i;
		}
		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	// palindrome check for strings
	private static boolean isPalindrome(String toBePalindromed) {
		String comparedPart = new StringBuffer(toBePalindromed).reverse()
				.toString();
		if (toBePalindromed.equals(comparedPart)) {
			return true;
		} else {
			return false;
		}

	}

}
