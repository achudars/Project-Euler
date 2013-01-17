import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PE099 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		String line = null;
		double e, max = 0.0;
		int n = 0, lineNumberContainingGreatestNumericalValue = 0;

		try {
			File InFile = new File("src/base_exp.txt");
			FileReader fileReader = new FileReader(InFile);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(fileReader);
			while ((line = reader.readLine()) != null) {
				n++;
				e = exponentiate(line);
				if (e > max) {
					max = e;
					lineNumberContainingGreatestNumericalValue = n;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Answer: " + lineNumberContainingGreatestNumericalValue);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

	public static double exponentiate(String line) {
		double e = 0.0;
		String[] tokens = line.split(",");
		int base = Integer.parseInt(tokens[0]);
		int exp = Integer.parseInt(tokens[1]);
		e = exp * Math.log10(base);
		return e;
	}

}
