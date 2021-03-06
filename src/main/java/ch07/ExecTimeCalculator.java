package ch07;

public class ExecTimeCalculator implements Calculator {

    private Calculator delegate;

    public ExecTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();
        System.out.printf("%s.factorial(%d) response time = %d\n",
                delegate.getClass().getSimpleName(),
                num,
                (end - start));

        return result;
    }
}
