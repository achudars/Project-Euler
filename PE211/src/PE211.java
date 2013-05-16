// Use the -Xmx1024m switch in the java command to increase the heap size.

import java.util.Arrays;

/**
 * Returns an array of sums of squared divisors of i
 * for 0 <= i < n
 */
public class PE211 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		 System.out.println(Runtime.getRuntime().maxMemory());

	    //int n = 100;  // Answer: 43
	    //int n = 1000;  // Answer: 1304
	    int n = 64000000;  // Answer: 1922364685

	    long[] sums = getSumsOfSqDivs(n);

	    long s = 0;
	    for (int i = 1; i < n; i++)
	    {
	      if (isSquare(sums[i]))
	        s += i;
	    }
	    System.out.println(s);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long[] getSumsOfSqDivs(int n)
	  {
	    long[] sums = new long[n];
	    Arrays.fill(sums, 1); sums[0] = 0;

	    for (int p = 2; p < n; p++)
	    {
	      if (sums[p] == 1)
	      {
	        long p2 = (long)p * p;
	        for (int i = p; i < n; i += p)
	        {
	          long s = 1, powp = p, powp2 = p2;
	          while (i % powp == 0)
	          {
	            s += powp2;
	            powp *= p;
	            powp2 *= p2;
	          }
	          sums[i] *= s;
	        }
	      }
	    }
	    return sums;
	 }
	
	public static boolean isSquare(long x)
	  {
	    long y = Math.round(Math.sqrt(x));
	    return y*y == x;
	  }

}
