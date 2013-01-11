import java.util.SortedSet;
import java.util.TreeSet;

public class PE032 {

	static int sum = 0;
	// I'm using sorted set because we need unique entries
	static SortedSet<Integer> elements = new TreeSet<Integer>();
	
	public static void main(String[] args) {
		
		permutation("123456789");
		
		// sum up like a bauce!
		for(Integer i : elements){
			sum += i;
		}
		
		System.out.println("\nAnswer: " + sum);
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0){
			// this is where the magic happens
			// there are only 2 possibilities which is easily deduced from mathematical analysis and combinatorics
			// 1) nnnn * n = nnnn
			Integer a1 = Integer.parseInt(prefix.substring(0, 4));
			Integer b1 = Integer.parseInt(prefix.substring(4, 5));
			Integer c1 = Integer.parseInt(prefix.substring(5, 9));
			// 2) nnn * nn = nnnn
			Integer a2 = Integer.parseInt(prefix.substring(0, 3));
			Integer b2 = Integer.parseInt(prefix.substring(3, 5));
			Integer c2 = Integer.parseInt(prefix.substring(5, 9));
			
			if (a1 * b1 == c1){ 
				System.out.println(a1+" x "+b1+" = "+c1);
				elements.add(c1);
			}
			if (a2 * b2 == c2){
				System.out.println(a2+" x "+b2+" = "+c2);
				elements.add(c2);
			}
			

		} else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}
}