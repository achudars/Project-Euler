import java.util.Arrays;


public class PE221 {


	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Answer: " + findNthAlexandrianInt(149999));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
	
	private static long findNthAlexandrianInt(int N) {
		   long[] bucket = new long[10*N]; // bucket array
		   int i = -1; // counter to stop algorithm after array is full
		   long p, q, r;
		   int oldper = -1; // for the percentage display
		   loop:for (p = -1; true; p--)
		      for (q = 1; q < -p; q++) {
		         if (q+p != 0) { // avoid division by 0
		            r = (1-p*q)/(q+p);
		            if (r < p) // eliminate duplicates
		               if (r*(q+p) == (1-p*q)) {
		                  i++;
		                  if (i == bucket.length)
		                     break loop;
		                  bucket[i] = p*q*r;
		                  if (bucket[i] <= 0) // Handle overflow
		                     bucket[i] = Long.MAX_VALUE;
		                  // calculate and show percentage if necessary
		                  int per = 100*i/bucket.length;
		                  if (oldper != per && per % 2 == 0) {
		                     System.out.println(per+"%");
		                     oldper = per;
		                  }
		               }
		         }
		      }
		   Arrays.sort(bucket);
		   return bucket[N-1];
		}

}
