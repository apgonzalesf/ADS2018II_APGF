package pe.com.apgf.bigonotation;

public class Exponential {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		Exponential exponential = new Exponential();
		int n = 45; // 8 40 80
		for (int i = 1; i <= n; i++) {
			int fibonacci = exponential.fibonacci(i);
			System.out.println(String.format("fibonacci %d = %d", i, fibonacci));
		}

		long end = System.currentTimeMillis();
		System.out.println(String.format("Time elapsed : %d",  (end - start) / 1000) );
		System.in.read();

	}

	int fibonacci(int n) throws Exception {
		if (n < 0) {
			throw new Exception("n can not be less than zero");
		}
		if (n <= 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
