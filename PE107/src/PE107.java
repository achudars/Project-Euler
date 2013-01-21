import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class PE107 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		ArrayList<Integer> known = new ArrayList<Integer>();
		ArrayList<Integer> goods = new ArrayList<Integer>();
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		File file = new File("src/network.txt");
		Scanner scnr = null;
		try {
			scnr = new Scanner(file);
		} catch (Exception e) {

		}
		int count = 0;
		int len = 0;
		while (scnr.hasNext()) {
			String line = scnr.nextLine();
			String[] split = line.split(",");
			len = split.length;
			break;
		}
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (Exception e) {

		}

		int[][] array = new int[len][len];
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] split = line.split(",");
			for (int i = 0; i < len; i++) {
				if (split[i].equals("-"))
					array[count][i] = -1;
				else
					array[count][i] = Integer.parseInt(split[i]);
			}
			count++;
		}

		int initSum = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++)
				if (array[i][j] != -1)
					initSum += array[i][j];

		// Prim's algorithm for Minimum Spanning Tree
		known.add(0);
		map.put(0, 0);
		while (true) {
			int min = 1000000;
			int index = -1;
			int mapdex = -1;
			for (int i = 0; i < known.size(); i++) {
				for (int j = 0; j < len; j++) {
					int now = array[map.get(i)][j];
					if (now < min && now != -1 && !known.contains(j)) {
						min = now;
						index = j;
						mapdex = known.size();
					}

				}
			}
			goods.add(min);
			known.add(index);
			map.put(mapdex, index);
			if (known.size() == len)
				break;
		}

		int sum = 0;
		for (int i = 0; i < goods.size(); i++)
			sum += goods.get(i);
		System.out.println("Answer: " + (initSum - sum));

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}

}
