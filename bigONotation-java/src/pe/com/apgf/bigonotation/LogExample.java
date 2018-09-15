package pe.com.apgf.bigonotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class LogExample {
	public static void main(String[] args) throws IOException {
		Stopwatch stopwatch = Stopwatch.start();
		System.out.println("Starting...");
		LogExample logExample = new LogExample();
		System.out.println("Step 1: Reading Log Items...");
		int lineCount = logExample.readAllLogs();
		System.out.printf("%d Log Items Read \n", lineCount);
		System.out.println("Step 2: Counting Unique IPs...");
		int ipCount = logExample.countUniqueIPs();
		System.out.printf("Number of unique IPs: " + ipCount);
		System.out.printf("\nTime elapsed: %d seconds \n", stopwatch.time(TimeUnit.SECONDS));
		System.in.read();
	}

	int readAllLogs() {
		LogReader logReader = new LogReader();
		int linesSeen = 0;
		for (LogLine logLine : logReader) {
			String ip = logLine.getIP();
			linesSeen++;
		}

		return linesSeen;
	}

	int countUniqueIPs() {
		LogReader logReader = new LogReader();
		DataStructureType dataStructureType = DataStructureType.HashSet;
		Collection<String> ipsSeen = null;
		switch (dataStructureType) {
		case List:
			ipsSeen = new ArrayList<String>();
			break;
		case HashSet:
			ipsSeen = new HashSet<String>();
			break;
		default:
			ipsSeen = new ArrayList<String>();
			break;
		}
		for (LogLine logLine : logReader) {
			String ip = logLine.getIP(); 
			if (!ipsSeen.contains(ip)) {
				ipsSeen.add(ip);
			}
		}
		return ipsSeen.size();
	}
}