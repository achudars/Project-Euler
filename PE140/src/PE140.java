import java.util.Vector;

public class PE140 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int counter = 2;

		Vector<Long> numbers = new Vector<Long>(40);

		numbers.add(0L);
		numbers.add(0L);
		numbers.add(2L);
		numbers.add(5L);

		long sum = 7L, number;

		while (numbers.size() < 32) {
			number = numbers.get(counter) * 7L - (numbers.get(counter - 2) - 7L);
			sum += number;
			numbers.add(number);
			counter++;
		}

		System.out.println("Answer: " + sum);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
