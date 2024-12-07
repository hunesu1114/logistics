package project.logistics.util.logtracer.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class LogPointcut {

    @Pointcut("execution(* project.logistics.controller.*.*(..))")
    public void allController() {
    }

    @Pointcut("execution(* project.logistics.repository.*.*(..))")
    public void allRepository() {
    }

    @Pointcut("execution(* project.logistics.service.*.*(..))")
    public void allService() {}

    @Pointcut("execution(* project.logistics.util.GeneratorUtil.*(..))")
    public void GeneratorUtil() {}

    @Pointcut("allController() || allRepository() || allService()")
    public void unionPointcut() {}
}
