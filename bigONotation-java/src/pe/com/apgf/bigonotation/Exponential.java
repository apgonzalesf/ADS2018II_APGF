package pe.com.apgf.bigonotation;

import java.util.concurrent.TimeUnit;

public class Exponential {
	public static void main(String[] args) throws Exception {
		Stopwatch stopwatch = Stopwatch.start();
		Exponential exponential = new Exponential();
		ExponentialExampleType exponentialExampleType = ExponentialExampleType.Fibonacci;
		switch (exponentialExampleType) {
		case Fibonacci:
			long n= 45; // 8 40 80
			for (long i = 1; i <= n; i++) {
				int fibonacci = exponential.fibonacci(i);
				System.out.printf("fibonacci %d = %d\n", i, fibonacci);
			}
			break;
		}
		System.out.printf("Time elapsed : %d seconds", stopwatch.time(TimeUnit.SECONDS));
		System.in.read();

	}

	int fibonacci(long n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
