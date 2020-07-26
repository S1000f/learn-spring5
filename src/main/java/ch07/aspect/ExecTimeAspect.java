package ch07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExecTimeAspect {

    @Pointcut("execution(public * ch07..*(..))")
    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.nanoTime();
            Signature signature = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) service time : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    signature.getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    (finish - start));
        }
    }

}
