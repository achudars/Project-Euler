import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class PE186 {

	static long calls = 0;
	static long nums = 0;
	static Vector cs = new Vector(56);
	static Vector[] hash = new Vector[1000000];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int PM = 524287;
		Vector work;
		Arrays.fill(hash, null);
		int allocs = 0;
		int misdials = 0;
		int numbers = 0;

		while (true) {
			// generate a phone call
			int from = lagFib();
			int to = lagFib();
			if (from == to) // misdial
			{
				misdials++;
				continue;
			}
			calls++;
			if (hash[from] == null) {
				// first call for from number
				if (hash[to] == null) {
					// first call for either number
					work = new java.util.Vector();
					allocs++;
					work.add(new Integer(from));
					work.add(new Integer(to));
					hash[from] = hash[to] = work;
					numbers += 2;
				} else {
					work = hash[from] = hash[to];
					work.add(new Integer(from));
					numbers++;
				}
			} else {
				if (hash[to] == null) {
					work = hash[to] = hash[from];
					work.add(new Integer(to));
					numbers++;
				} else {
					// both numbers have been called
					if (hash[from] == hash[to])
						continue; // already had one of these calls
					// have 2 lists to merge
					work = merge(to, from);
					allocs--;
				}
			}

			if ((work = hash[PM]) != null) {
				// call involved friend(s) of PM
				int friends = work.size();
				if (friends >= 990000) {
					//System.out.println("friends = " + friends);
					//System.out.println("calls = " + calls);
					//System.out.println("allocs = " + allocs);
					//System.out.println("numbers = " + numbers);
					//System.out.println("misdials = " + misdials);
					System.out.println("Answer: " + calls);
					long endTime = System.nanoTime();
					System.out.printf("Total Time: %.6f seconds\n",
							((endTime - startTime) / 1000000000.0));
					return;
				}
				continue;
			}
			
		}

	}

	static int lagFib() {
		long S;
		nums++;
		if (nums < 56)
			S = (100003 - 200003 * nums + 300007 * nums * nums * nums) % 1000000;
		else {
			S = (((Integer) (cs.elementAt(0))).intValue() + ((Integer) (cs
					.elementAt(31))).intValue()) % 1000000;
			cs.remove(0);
		}
		cs.add(new Integer((int) S));
		return (int) S;
	}

	static Vector merge(int to, int from) {
		Vector sfrom = hash[from];
		Vector sto = hash[to];
		if (sfrom.size() > sto.size()) {
			sfrom = hash[to];
			sto = hash[from];
		}
		Iterator it = sfrom.iterator();
		while (it.hasNext()) {
			Integer num = (Integer) (it.next());
			sto.add(num);
			hash[num.intValue()] = sto;
		}
		return sto;
	}
}
