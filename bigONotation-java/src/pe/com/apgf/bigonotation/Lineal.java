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
					39, 30, 1, 39, 38, 97, 52, 60, 94, 55, 62, 87, 54, 34, 67, 61, 33, 80, 64, 46, 78, 50, 78, 17, 47,
					64, 15, 22, 96, 44, 21, 56, 55, 69, 55, 93, 11, 82, 93, 45, 74, 26, 36, 71, 81, 88, 68, 82, 39, 31,
					85, 46, 80, 65, 1, 88, 9, 24, 83, 84, 40, 10, 41, 39, 87, 81, 1, 74, 87, 73, 75, 93, 63, 98, 32, 8,
					77, 38, 99, 90, 50, 95, 0, 67, 53, 69, 30, 59, 61, 31, 98, 48, 61, 50, 99, 37, 27, 22, 84, 50, 88,
					75, 78, 72, 51, 26, 47, 97, 20, 55, 81, 8, 21, 53, 3, 4, 11, 6, 7, 30, 50, 98, 31, 81, 90, 93, 29,
					18, 17, 20, 64, 55, 42, 21, 93, 80, 13, 80, 72, 20, 78, 28, 89, 21, 84, 1, 70, 91, 77, 65, 86, 72,
					0, 32, 39, 35, 53, 37, 77, 86, 99, 43, 52, 40, 17, 62, 78, 28, 60, 80, 11, 69, 74, 36, 4, 7, 64, 76,
					3, 9, 67, 10, 6, 14, 12, 60, 94, 9, 60, 71, 38, 19, 67, 36, 4, 1, 65, 22, 66, 72, 53, 89, 33, 50,
					21, 37, 56, 74, 66, 74, 63, 27, 84, 13, 95, 91, 54, 14, 77, 0, 11, 29, 52, 35, 8, 36, 12, 42, 8, 57,
					7, 26, 69, 21, 41, 42, 81, 71, 23, 51, 78, 86, 53, 26, 89, 0, 26, 55, 48, 41, 42, 58, 10, 1, 38, 14,
					94, 70, 33, 32, 3, 87, 77, 60, 32, 98, 70, 91, 75, 7, 87, 0, 67, 30, 55, 6, 71, 86, 11, 90, 36, 34,
					90, 26, 67, 72, 68, 11, 62, 14, 80, 56, 12, 11, 25, 3, 6, 99, 80, 67, 62, 91, 19, 8, 8, 60, 80, 65,
					18, 56, 23, 63, 25, 69, 64, 8, 5, 98, 91, 84, 62, 0, 9, 39, 71, 42, 55, 71, 81, 22, 89, 97, 64, 31,
					50, 55, 93, 87, 53, 91, 48, 3, 49, 78, 62, 51, 68, 90, 55, 91, 33, 53, 75, 41, 96, 87, 0, 49, 86, 5,
					45, 43, 90, 99, 83, 13, 55, 94, 67, 87, 65, 44, 64, 31, 32, 23, 9, 0, 75, 99, 79, 13, 98, 13, 1, 65,
					67, 22, 72, 21, 14, 29, 75, 46, 17, 67, 9, 31, 65, 17, 79, 6, 51, 5, 21, 50, 0, 63, 67, 45, 10, 42,
					49, 43, 50, 70, 95, 62, 53, 36, 1, 9, 13, 47, 95, 17, 75, 10, 56, 91, 24, 12, 51, 78, 42, 14, 55,
					43, 54, 91, 97, 10, 81, 69, 2, 72, 3, 91, 56, 49, 28, 32, 26, 95, 86, 63, 93, 4, 7, 39, 53, 92, 44,
					9, 31, 2, 59, 52, 45, 9, 15, 55, 10, 69, 79, 12, 23, 69, 19, 17, 83, 69, 99, 68, 19, 16, 13, 89, 79,
					4, 14, 68, 93, 54, 71, 92, 45, 13, 46, 33, 83, 72, 79, 98, 99, 48, 21, 18, 77, 77, 43, 87, 52, 5,
					42, 21, 9, 23, 2, 1, 34, 14, 9, 29, 27, 97, 62, 48, 99, 93, 82, 56, 41, 69, 21, 7, 63, 2, 48, 81,
					87, 64, 48, 93, 61, 88, 17, 27, 54, 37, 81, 81, 43, 77, 13, 95, 78, 34, 31, 80, 40, 1, 54, 53, 36,
					34, 30, 82, 76, 99, 32, 62, 41, 71, 4, 60, 66, 76, 49, 66, 77, 85, 37, 74, 31, 62, 12, 75, 25, 26,
					89, 43, 39, 4, 73, 2, 12, 51, 14, 25, 63, 60, 99, 50, 76, 69, 65, 91, 88, 98, 24, 6, 56, 69, 62, 39,
					61, 88, 33, 34, 95, 0, 47, 83, 91, 3, 80, 74, 83, 90, 41, 74, 9, 2, 34, 99, 35, 25, 71, 65, 48, 29,
					66, 10, 66, 36, 56, 15, 13, 49, 23, 17, 91, 26, 65, 64, 43, 76, 45, 97, 95, 16, 38, 8, 1, 5, 32, 51,
					58, 25, 80, 70, 46, 15, 31, 76, 43, 9, 53, 42, 88, 74, 43, 58, 45, 33, 74, 11, 62, 91, 33, 69, 98,
					12, 79, 8, 58, 98, 79, 27, 92, 19, 21, 70, 88, 28, 27, 44, 53, 81, 34, 62, 70, 1, 92, 23, 85, 61,
					10, 76, 93, 29, 84, 46, 11, 74, 31, 86, 54, 82, 71, 24, 93, 84, 55, 69, 60, 92, 83, 21, 6, 53, 64,
					83, 77, 71, 12, 3, 42, 91, 80, 29, 98, 30, 44, 9, 10, 57, 8, 67, 35, 53, 27, 48, 31, 99, 77, 37, 73,
					90, 39, 45, 80, 13, 21, 53, 97, 69, 71, 34, 74, 99, 40, 18, 63, 5, 76, 22, 44, 85, 81, 16, 95, 22,
					89, 8, 16, 10, 47, 29, 63, 10, 25, 22, 44, 82, 68, 54, 56, 59, 86, 60, 70, 88, 27, 9, 23, 33, 5, 79,
					53, 51, 10, 85, 40, 13, 5, 25, 36, 28, 76, 59, 81, 1, 93, 16, 47, 62, 41, 81, 39, 72, 69, 1, 69, 74,
					80, 40, 98, 95, 39, 48, 79, 8, 14, 49, 51, 22, 5, 21, 20, 18, 4, 13, 96, 26, 33, 86, 38, 38, 49, 91,
					71, 48, 53, 21, 4, 69, 14, 86, 48, 57, 77, 26, 40, 90, 25, 39, 69, 94, 38));
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
