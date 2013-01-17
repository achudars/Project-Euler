import java.util.ArrayList;
import java.util.Collections;

public class PE095 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int[] sums = new int[1000001];
		ArrayList<Integer> temp;
		int count, max = 0, maxval = -1, n;
		for (int i = 1; i <= 1000000; i++) {
			sums[i] = sumDiv(normalize(i)) - i;
		}
		for (int i = 1; i <= 1000000; i++) {
			temp = new ArrayList<Integer>();
			temp.add(i);
			n = sums[i];
			count = 0;
			while (Collections.binarySearch(temp, n) < 0) {
				if (n > 1000000) {
					count = 0;
					break;
				}
				temp.add(n);
				Collections.sort(temp);
				n = sums[n];
				count++;
			}
			if (count > max && n == i) {
				max = count;
				maxval = i;
			}
		}
		int x = maxval, min = 1000001;
		for (int i = 0; i < max; i++) {
			if (x < min)
				min = x;
			x = sums[x];
		}
		System.out.println("Answer: " + min);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	private static ArrayList<ArrayList<Integer>> proper(int n) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int count = 0;
		if (n % 2 == 0) {
			while (n % 2 == 0) {
				n /= 2;
				count++;
			}
			a.add(new ArrayList<Integer>());
			a.get(a.size() - 1).add(2);
			a.get(a.size() - 1).add(count);
		}
		int b = (int) Math.sqrt(n);
		for (int i = 3; i <= b; i += 2) {
			if (n % i == 0) {
				n /= i;
				a.add(new ArrayList<Integer>());
				a.get(a.size() - 1).add(i);
				a.get(a.size() - 1).add(1);
				i -= 2;
			}
		}
		if (n > 1) {
			a.add(new ArrayList<Integer>());
			a.get(a.size() - 1).add(n);
			a.get(a.size() - 1).add(1);
		}
		return a;
	}

	public static ArrayList<ArrayList<Integer>> normalize(int b) {
		if (b < 1)
			return null;
		ArrayList<ArrayList<Integer>> a;
		if (b == 1) {
			a = new ArrayList<ArrayList<Integer>>();
			a.add(new ArrayList<Integer>());
			a.get(0).add(1);
			a.get(0).add(1);
			return a;
		}
		a = proper(b);
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i).get(0) == a.get(i + 1).get(0)) {
				a.remove(i + 1);
				a.get(i).set(1, a.get(i).get(1) + 1);
				i--;
			}
		}
		return a;
	}

	public static int numDiv(ArrayList<ArrayList<Integer>> a) {
		int num = 1;
		for (int i = 0; i < a.size(); i++)
			num *= a.get(i).get(1) + 1;
		return num;
	}

	@SuppressWarnings("unchecked")
	public static int sumDiv(ArrayList<ArrayList<Integer>> a) {
		int sum = 0;
		if (a.size() == 1) {
			for (int i = 0; i <= a.get(0).get(1); i++) {
				sum += Math.pow(a.get(0).get(0), i);
			}
			return sum;
		}
		ArrayList<ArrayList<Integer>> c = (ArrayList<ArrayList<Integer>>) (a
				.clone());
		c.remove(0);
		for (int i = 0; i <= a.get(0).get(1); i++) {
			sum += Math.pow(a.get(0).get(0), i) * sumDiv(c);
		}
		return sum;
	}

}
