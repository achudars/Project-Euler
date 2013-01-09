import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;


public class PE029 {

	public static void main(String[] args) {

		BigInteger value = BigInteger.ZERO;
		long distinctTerms = 0;
		SortedSet<BigInteger> elements = new TreeSet<BigInteger>();
		
		for(int a=2; a<=100; a++){
			for(int b=2; b<=100; b++){
				value = BigInteger.valueOf(a).pow(b);
				elements.add(value);
			}
			distinctTerms += elements.size();
		}

		System.out.println("ANSWER: " + elements.size());
		System.out.println("distinctTerms: " + distinctTerms);
	}

}
