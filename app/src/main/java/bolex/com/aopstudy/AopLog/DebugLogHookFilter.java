package bolex.com.aopstudy.AopLog;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.TimeUnit;

/**
 * Created by liushenen on 2017/9/4.
 */
@Aspect
public class DebugLogHookFilter {

    //在带有DebugLog注解的方法
    @Pointcut("execution(@bolex.com.aopstudy.AopLog.DebugLog * *(..))")
    public void debugLog() {}

    @Around("debugLog()")
    public Object logAndExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        enterMethod(joinPoint);//执行方法前
        long startNanos = System.nanoTime();
        Object result = joinPoint.proceed();//执行原方法
        long stopNanos = System.nanoTime();
        long lengthMillis = TimeUnit.NANOSECONDS.toMillis(stopNanos - startNanos);
        exitMethod(joinPoint, result, lengthMillis);//执行方法后
        return result;
    }

    private void enterMethod(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Log.d("debug","enterMethod="+args.length);
    }

    private void exitMethod(ProceedingJoinPoint joinPoint, Object result, long lengthMillis) {
        Log.d("debug","exitMethod="+result);
    }

}



