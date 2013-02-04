import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PE143 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		HashMap<Long, HashSet<Long>> map = new HashMap<Long, HashSet<Long>>();

		for (long m = 1; m < 119999; m++) {
			for (long n = 1; m * n < 119999 && (3 * m * m - n * n - 2 * m * n) > 0; n++)
				if (mcd(m, n) == 1) {
					
					long p;
					long q;
					
					for (int k = 1; m * n * k < 119999; k++) {
						
						p = m * n * k;
						q = ((3 * m * m - n * n - 2 * m * n) * k) / 4;
						
						if (p + q < 120000 && ((3 * m * m - n * n - 2 * m * n) * k) % 4 == 0) {
							
							if (map.containsKey(p)){
								map.get(p).add(q);
							} else {
								HashSet<Long> newset = new HashSet<Long>();
								newset.add(q);
								map.put(p, newset);
							}
							if (map.containsKey(q)){
								map.get(q).add(p);
							} else {
								HashSet<Long> newset = new HashSet<Long>();
								newset.add(p);
								map.put(q, newset);
							}
						}
					}
				}
		}
		
		long[] arr = new long[120001];
		
		for (Map.Entry<Long, HashSet<Long>> entry : map.entrySet()) {
			
			long p = entry.getKey();
			
			for (long q : entry.getValue()) {
				
				HashSet<Long> commons = new HashSet<Long>(map.get(p));
				commons.retainAll(map.get(q));
				for (long r : commons)
					if (p + q + r <= 120000)
						arr[(int) (p + q + r)] = 1;
			}
		}

		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				result = result + i;
		}
		
		
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static long mcd(long x, long y) {
		while (y != 0) {
			long tmp = y;
			y = x % y;
			x = tmp;
		}
		return x;
	}

}
