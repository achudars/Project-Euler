import java.math.BigInteger;

public class PE034 {

	public static void main(String[] args) {
		
		int sumOfFactorialOfDigits = 0;
		Integer factA, factB, factC, factD, factE = 0;
		
		// checks if a! = a
		for(int a=0; a<10; a++){
			factA = Integer.parseInt(factorial(a).toString());
			// checks if a!+b! = ab
			for(int b=0; b<10; b++){
				factB = Integer.parseInt(factorial(b).toString());
				// checks if a!+b!+c! = abc
				for(int c=0; c<10; c++){
					factC = Integer.parseInt(factorial(c).toString());
					// checks if a!+b!+c!+d! = abcd
					for(int d=0; d<10; d++){
						factD = Integer.parseInt(factorial(d).toString());
						// checks if a!+b!+c!+d!+e! = abcde
						for(int e=0; e<10; e++){
							factE = Integer.parseInt(factorial(e).toString());
							if ((a*10000 + b*1000 + c*100 + d*10 + e) == (factA + factB + factC + factD+ factE) && a>0){
								sumOfFactorialOfDigits += (a*10000 + b*1000 + c*100 + d*10 + e);
							}
						}
						if ((a*1000 + b*100 + c*10 + d) == (factA + factB + factC + factD)){
							sumOfFactorialOfDigits += (a*1000 + b*100 + c*10 + d);
						}
					}
					if ((a*100 + b*10 + c*1) == (factA + factB + factC)){
						sumOfFactorialOfDigits += (a*100 + b*10 + c);
					}
				}
				if ((a*10 + b) == (factA + factB)){
					sumOfFactorialOfDigits += (a*10 + b);
				}
			}
			if ((a) == (factA) && a!=1 && a!=2){
				sumOfFactorialOfDigits += a;
			}
		}
		System.out.println("Answer: " + sumOfFactorialOfDigits);

	};

	public static BigInteger factorial(int n) {
		BigInteger product = BigInteger.ONE;
		if (n < 0) {
			return new BigInteger("-1");
		}
		/* Chain Multiply from 'n' to '1' */
		for (int c = n; c > 0; c--) {
			product = product.multiply(BigInteger.valueOf(c));
		}
		return product;
	};
}
