package pe.com.apgf.bigonotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lineal {
	long[] fibonacciCache = null;

	public static void main(String[] args) throws Exception {
		Stopwatch stopwatch = Stopwatch.start();
		Lineal lineal = new Lineal();
		LinealExampleType linealExampleType = LinealExampleType.Factorial;
		int nFibonacciCache = 80; // 8 40 80
		lineal.fibonacciCache = new long[nFibonacciCache + 1];
		switch (linealExampleType) {
		case Loop:
			int n = 50;
			lineal.Loop(n);
			break;
		case ContainsNeedle:
			List<Integer> numberList = new ArrayList<>(Arrays.asList(10, 18, 29, 1, 0, 75, 79, 78, 58, 15, 6, 67, 67,
					66, 52, 7, 60, 69, 63, 51, 78, 41, 6, 4, 2, 50, 66, 57, 97, 7, 44, 90, 8, 12, 69, 65, 29, 15, 83,
					35, 31, 89, 50, 12, 87, 48, 2, 66, 80, 1, 33, 29, 85, 60, 37, 83, 2797, 36, 2, 50, 23, 87, 67, 8, 8,
					79, 72, 35, 89, 25, 83, 39, 96, 3, 66, 8, 28, 29, 17, 59, 18, 75, 65, 72, 76, 92, 17, 64, 27, 37,
					38, 99, 64, 10, 91, 64, 75, 81, 67, 6, 76, 27, 26, 63, 87, 27, 42, 41, 41, 2, 25, 16, 22, 97, 46,
					49, 76, 39, 11, 55, 11, 46, 92, 52, 31, 87, 76, 0, 81, 61, 15, 10, 6, 50, 15, 64, 96, 97, 58, 78,
					22, 16, 39, 29, 33, 4, 58, 10, 53, 61, 51, 92, 19, 27, 74, 63, 42, 38, 60, 27, 52, 39, 72, 20, 1,
					39, 30, 1, 39, 38, 97, 52, 60, 94, 55, 62, 87, 54, 34, 67, 61, 33, 80, 64, 46, 78, 50, 78, 17, 47
					));
			int needle = 760;
			boolean found = lineal.ContainsNeedle(needle, numberList);
			System.out.printf("Number %d found? %s  \n", needle, found);
			break;
		case Factorial:
			double nFactorial = 100 ;
			double factorial = lineal.Factorial(nFactorial);
			System.out.printf("Factorial of %.0f equal to %.0f \n", nFactorial, factorial);
			break;
		case Fibonacci:
			int nFibonacci = 80; // 8 40 80
			for (int i = 1; i <= nFibonacci; i++) {
				long fibonacci = lineal.Fibonacci(i);
				System.out.printf("fibonacci %d = %d \n", i, fibonacci);
			}
			break;
		case FibonacciCache:
			for (int i = 1; i <= nFibonacciCache; i++) {
				long fibonacci = lineal.FibonacciCache(i);
				System.out.printf("fibonacci %d = %d\n", i, fibonacci);
			}
			break;
		}
		System.out.printf("Time elapsed: %d seconds", stopwatch.time(TimeUnit.SECONDS));
		System.in.read();
	}

	/// Complexity: O(N)
	void Loop(long n) {
		int counter = 1;
		while (counter <= n) {
			System.out.println(counter);
			counter++;
		}
	}

	/// Complexity: O(N)
	boolean ContainsNeedle(int needle, List<Integer> numberList) {
		for (Integer item : numberList) {
			if (item == needle) {
				return true;
			}
		}
		return false;
	}

	/// Complexity: O(N)
	double Factorial(double n) {
		if (n == 1) {
			return 1;
		}
		return n * Factorial(n - 1);
	}

	/// Complexity: O(N)
	long Fibonacci(long n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			return 1;
		}
		long fibonacci = 0;
		long previous = 1;
		long penultimate = 0;
		for (int i = 1; i <= n; i++) {
			penultimate = fibonacci;
			fibonacci = previous + fibonacci;
			previous = penultimate;
		}
		return fibonacci;
	}

	/// Complexity: O(N)
	public long FibonacciCache(int n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			fibonacciCache[n] = 1;
		}
		if (fibonacciCache[n] == 0) {
			fibonacciCache[n] = FibonacciCache(n - 1) + FibonacciCache(n - 2);
		}
		return fibonacciCache[n];
	}
}
