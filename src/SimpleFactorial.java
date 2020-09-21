import java.math.BigInteger;

public final class SimpleFactorial {

	public static final BigInteger calculate(long n) {
		if (n < 0) {
			System.err.println("Error: input should be more than zero");
			return null;
		}

		BigInteger result = BigInteger.ONE;

		if (n > 0) {
			for (; n > 0; n--) {
				result = result.multiply(BigInteger.valueOf(n));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		BigInteger fact = BigInteger.ONE;

		for (int i = 0; i <= 1000; i++) {
			fact = SimpleFactorial.calculate(1000);
			// System.out.println(fact);
		}

		long end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000 + " ms  -  " + fact);

	}

}
