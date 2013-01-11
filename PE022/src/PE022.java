import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PE022 {

	public static void main(String args[]) {
		long startTime = System.nanoTime();
		// read from file
		// replace unnecessary non-word characters
		// split the string into items in an array, then sort
		String[] listOfNames = readFile().replaceAll("\"", "").split(",");
		Arrays.sort(listOfNames);

		long total = 0;

		for (int loop = 0; loop < listOfNames.length; loop++) {
			total += getValueOfEachName(listOfNames[loop]) * (loop + 1);
		}

		System.out.println("Total value: " + total);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	private static long getValueOfEachName(String name) {
		long total = 0;
		for (int loop = 0; loop < name.length(); loop++)
			total += (int) name.charAt(loop) - 64;
		return total;
	}

	private static String readFile() {
		String names = "";
		String strLine = "";
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("src/names.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// concatenate
				// System.out.println(strLine);
				names = names + strLine;
			}

			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return names;
	}

}