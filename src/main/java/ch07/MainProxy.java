package ch07;

public class MainProxy {

    public static void main(String[] args) {
        ExecTimeCalculator execTimeCalculator = new ExecTimeCalculator(new ImplCalculator());
        System.out.println(execTimeCalculator.factorial(20));

        ExecTimeCalculator execTimeCalculator1 = new ExecTimeCalculator(new RecCalculator());
        System.out.println(execTimeCalculator1.factorial(20));
    }
}
