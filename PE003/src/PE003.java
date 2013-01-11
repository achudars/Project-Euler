import java.math.BigInteger;

public class PE003
{
    public static void main(String[] args){
    	long startTime = System.nanoTime();
    	BigInteger theLargeNumber = new BigInteger("600851475143");
        // although smallest prime is 2, it is odd
        BigInteger rem = new BigInteger("3");
        int largestPrime = 3;
       
        while(true)
        {
            // divide until the largest prime factor is found
            while (theLargeNumber.remainder(rem).equals(BigInteger.ZERO))
            { 
                theLargeNumber = theLargeNumber.divide(rem);
                largestPrime = rem.intValue();
            }
           
            rem = rem.add(BigInteger.valueOf(2));
           
            if (theLargeNumber.equals(BigInteger.ONE))
                break;
        }
       
        System.out.printf("Answer: %d\n", largestPrime);
        long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
    }
}