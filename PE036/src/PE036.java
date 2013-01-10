public class PE036 {

	public static void main(String[] args) {
		long sum = 0;
		for (int i = 0; i < 1000000; i++) {
			if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i)))
				sum += i;
		}
		System.out.println("Answer: " + sum);
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
