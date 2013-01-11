import java.util.Calendar;
import java.util.GregorianCalendar;

public class PE019 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		// Set beginning as 1 Jan 1901
		Calendar begin = GregorianCalendar.getInstance();
		begin.set(Calendar.MONTH, Calendar.JANUARY);
		begin.set(Calendar.DATE, 1);
		begin.set(Calendar.YEAR, 1901);

		// Set end as 31 Dec 2000
		Calendar end = GregorianCalendar.getInstance();
		end.set(Calendar.MONTH, Calendar.DECEMBER);
		end.set(Calendar.DATE, 31);
		end.set(Calendar.YEAR, 2000);

		int result = 0;

		while (begin.before(end)) {
			if (begin.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
					&& begin.get(Calendar.DAY_OF_MONTH) == 1) {
				result++;
			}
			begin.add(Calendar.MONTH, 1);
		}
		System.out.println("Answer: " + result);

		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	};

}
