import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PE102 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		try {
			System.out.println("Answer: " + getResult("src/triangles.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));
	}

	public static int getResult(String file) throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while (line != null) {
			String[] coordinates = line.split(",");
			int aX = Integer.parseInt(coordinates[0]);
			int aY = Integer.parseInt(coordinates[1]);

			int bX = Integer.parseInt(coordinates[2]);
			int bY = Integer.parseInt(coordinates[3]);

			int cX = Integer.parseInt(coordinates[4]);
			int cY = Integer.parseInt(coordinates[5]);

			if (containsOrigin(aX, aY, bX, bY, cX, cY)) {
				result++;
			}
			line = br.readLine();

		}
		return result;
	}

	public static boolean containsOrigin(int aX, int aY, int bX, int bY, int cX, int cY) {
        // Heron's formula
		double total = getArea(aX, aY, bX, bY, cX, cY);
		double partial = getArea(aX, aY, bX, bY, 0, 0) + getArea(aX, aY, cX, cY, 0, 0) + getArea(bX, bY, cX, cY, 0, 0);

		return Math.abs(partial - total) < 0.5d;
	}

	public static double getArea(int aX, int aY, int bX, int bY, int cX, int cY) {
		double ab = Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));
		double ac = Math.sqrt(Math.pow(aX - cX, 2) + Math.pow(aY - cY, 2));
		double bc = Math.sqrt(Math.pow(bX - cX, 2) + Math.pow(bY - cY, 2));
		double perimeter = (ab + ac + bc) / 2;

		return Math.sqrt(perimeter * (perimeter - ab) * (perimeter - bc) * (perimeter - ac));
	}
}
