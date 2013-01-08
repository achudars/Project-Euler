import java.math.BigInteger;

public class PE016 {

	public static void main(String[] args) {

		int sumOfDigits = 0;
		// get the number 2^1000
		BigInteger number = new BigInteger("2");
		number = number.pow(1000);
		// convert to string
		String theNumber = number.toString();
		// traverse evry character in teh string array and calculate value
		for (char a : theNumber.toCharArray()) {
			sumOfDigits = sumOfDigits + Character.getNumericValue(a);
		}

		System.out.println("Answer: " + sumOfDigits);

	};
}