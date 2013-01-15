import java.io.File;
import java.util.Scanner;

public class PE079 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// get the file
		Scanner scanner;
		try {
			scanner = new Scanner(new File("src/keylog.txt"));
		} catch (Exception e) {
			throw new RuntimeException("file not found");
		}
		// If it finds digits i and j out of place in the password from one of
		// the login attempts, it changes the password so that i is right before
		// j.
		String password = "";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			for (int i = 0; i < line.length(); i++) {
				if (password.indexOf(line.charAt(i)) < 0)
					password += line.charAt(i);
			}
			for (int i = 0; i < line.length(); i++) {
				for (int j = i; j < line.length(); j++) {
					int indexOfI = password.indexOf(line.charAt(i));
					int indexOfJ = password.indexOf(line.charAt(j));
					if (indexOfI > indexOfJ) {
						password = password.substring(0, indexOfI)
								+ password.substring(indexOfI + 1,
										password.length());
						password = password.substring(0, indexOfJ)
								+ line.charAt(i)
								+ password.substring(indexOfJ,
										password.length());
					}
				}
			}
		}
		System.out.println("Answer: " + password);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
