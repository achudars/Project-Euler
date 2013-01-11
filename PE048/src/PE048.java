import java.math.BigInteger;

public class PE048 {

	public static void main(String[] args) {

		String variable = "0";
		BigInteger sum = BigInteger.ZERO;

		for (Integer i = 1; i <= 1000; i++) {
			variable = i.toString();
			BigInteger number = new BigInteger(variable);
			number = number.pow(i);

			sum = sum.add(number);
		}

		// 1. make sum a string
		// 2. reverse it
		// 3. get first ten numbers
		// 4. reverse back
		// 5. enjoy
		String answer = new StringBuffer(new StringBuffer(sum.toString()).reverse().toString().substring(0, 10)).reverse().toString();
		System.out.println("Answer: " + answer);

	};
}