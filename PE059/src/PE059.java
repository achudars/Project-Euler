import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PE059 {

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		List<Integer> c = new ArrayList<Integer>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src/cipher1.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		scanner.useDelimiter("[\\W]+");
		while (scanner.hasNextInt())
			c.add(scanner.nextInt());
		scanner.close();
		char[] password = new char[3];
		for (int i = 1; i <= 26; ++i) {
			for (int j = 1; j <= 26; ++j) {
				for (int k = 1; k <= 26; ++k) {
					password[0] = (char) (i + 96);
					password[1] = (char) (j + 96);
					password[2] = (char) (k + 96);
					int n = 0;
					StringBuilder sb = new StringBuilder();
					for (Integer cc : c) {
						sb.append((char) (cc ^ (int) password[n]));
						if (++n == 3)
							n = 0;
					}
					String text = sb.toString();
					if (text.indexOf(" the ") > -1) {
						int sum = 0;
						for (int t = 0; t < text.length(); ++t)
							sum += (int) text.charAt(t);
						System.out.println("Answer: " + sum);
					}
				}
			}
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

}
