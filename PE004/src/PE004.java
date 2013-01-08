public class PE004 {

	public static void main(String[] args) {
		// The largest number that can be made out of two 3-digit numbers is
		// 999 * 999 = 998001
		// That is the starting point because it will be faster to begin with.
		// There's no need to get lower than 100000 because
		// the smallest 6-digit number palidrome is 100001
		palidromeLoop:
		for (int i = 998001; i > 100000; i--) {
			// find the palindrome
			if(isPalindrome(i)){
				// search for factors
				for (int j = 999; j > 100; j--){
					// find the first number
					if (i % j == 0){
						for (int k = 999; k > 100; k--){
							// find the second number
							if(i / j == k){
								System.out.println("Answer: " + i + " consisting of " + j + " and " + k + " !");
								break palidromeLoop;
							};
						};
					};
				};
			};
		};
	};
	
	// the Palindrome function that I intend to misuse
	public static boolean isPalindrome(int number) {
	    int original = number;
	    int reverse = 0;
	    for (int i = 0; i <= number; i++) {
	        int remain = number % 10;
	        number = number / 10;
	        reverse = reverse * 10 + remain;
	    }
	    return reverse == original;
	};

}
