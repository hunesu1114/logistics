package project.logistics.util.logtracer.aop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import project.logistics.util.logtracer.TraceStatus;
import project.logistics.util.logtracer.logtrace.LogTrace;
import project.logistics.util.logtracer.logtrace.LogTraceImpl;

@Aspect
@Slf4j
@Component
public class LogAspect {

    private final LogTrace logTrace=new LogTraceImpl();

    @Around("project.logistics.util.logtracer.aop.pointcuts.LogPointcut.unionPointcut()")
    public Object writeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = logTrace.begin(joinPoint.getSignature().getName());
        try {
            Object proceed = joinPoint.proceed();
            logTrace.end(status);
            return proceed;
        } catch (Exception e) {
            logTrace.exception(status,e);
            throw e;
        }
    }
}
