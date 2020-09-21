import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ParallelFactorial {

	private static Collection<FactRecursiveTask> createSubtasks(int n) {
		Collection<FactRecursiveTask> collection = new ArrayList<>();
		int range = n / 10;

		for (int i = 1; i <= n; i += range) {
			collection.add(new FactRecursiveTask(i, i + range - 1));
		}
		return collection;
	}

	public static void main(String[] args) {

		long start = System.nanoTime();
		BigInteger fact  = BigInteger.ONE;
		
		for (int i = 0; i <= 1000; i++) {
			fact = ForkJoinTask
					.invokeAll(createSubtasks(1000))
					.stream()
					.map(ForkJoinTask::join)
					.reduce(BigInteger.ONE, BigInteger::multiply);
		}
		long end = System.nanoTime();

		System.out.println("Time:" + (end - start) / 1000000 + " ms   result: " + fact);

	}

}

class FactRecursiveTask extends RecursiveTask<BigInteger> {
	private long start, end;

	public FactRecursiveTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected BigInteger compute() {
		BigInteger result = BigInteger.valueOf(start);

		for (long i = start + 1; i <= end; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
