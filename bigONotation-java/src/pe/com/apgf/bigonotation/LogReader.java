package pe.com.apgf.bigonotation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogReader implements Iterable<LogLine> {
	int counter = 0;
	List<LogLine> temporal = new ArrayList<LogLine>();

	public LogReader() {
		int n = 100000;
		int uniqueIPs = 90001;
		while (counter < n) {
			temporal.add(new LogLine(counter % uniqueIPs));
			counter++;
		}
	}

	@Override
	public Iterator<LogLine> iterator() {
		return temporal.iterator();
	}

}
