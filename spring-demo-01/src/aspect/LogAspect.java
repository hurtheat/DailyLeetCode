package aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author kyg
 * @version 1.0
 * @description
 * @since 2020/11/4 15:48
 */
@Aspect
@Order(value = 1)
public class LogAspect {

    public LogAspect() {
    }

    @Pointcut("execution(public void dao.impl.UserDaoImpl.*(..))")
    private void pointCut() {

    }

    @Before("pointCut()")
    /*前置通知*/
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("增强的目标类"+joinPoint.getTarget());
        System.out.println("增强的类型"+joinPoint.getKind());
        System.out.println("前置通知执行了...");
    }


    @AfterReturning("pointCut()")
    public void afterReturnAdvice(JoinPoint joinPoint) {
        System.out.println("增强目标类："+joinPoint.getTarget());
        System.out.println("后置通知执行了...");
    }

    @Around("pointCut()")
    /*环绕通知*/
    public Object aroundAdvice(ProceedingJoinPoint joinPoint)throws Throwable {
        System.out.println("环绕前的代码执行了...");
        System.out.println("增强的目标类"+joinPoint.getTarget());
        Object o = joinPoint.proceed();
        System.out.println("增强的类型"+joinPoint.getKind());
        System.out.println("环绕通知执行了...");
        return o;
    }
    @After("pointCut()")
    /*后置通知*/
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("增强的目标类"+joinPoint.getTarget());
        System.out.println("增强的类型"+joinPoint.getKind());
        System.out.println("最终通知执行了...");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    /*异常通知*/
    public void exceptionAdvice(JoinPoint joinPoint, Throwable e) {
        System.out.println("增强的目标类"+joinPoint.getTarget());
        System.out.println("增强的类型"+joinPoint.getKind());
        System.out.println("发生的异常:"+e.getMessage());
        System.out.println("异常通知执行了...");
    }

}
