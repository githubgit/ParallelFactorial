import java.math.BigInteger;

public final class SimpleFactorialRecursive {

	public static final BigInteger calculate(long n) {
		if (n < 0) {
			System.err.println("Error: input should be more than zero");
			return null;
		}

		BigInteger result = BigInteger.ONE;

		if (n > 0) {
			result = BigInteger.valueOf(n).multiply(calculate(n - 1));
		}
		return result;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		BigInteger fact = BigInteger.ONE;
		for (int i = 0; i <= 1000; i++) {
			fact = SimpleFactorialRecursive.calculate(1000);
			// System.out.println(fact);
		}
		long end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000 + " ms  -  " + fact);

	}

}
