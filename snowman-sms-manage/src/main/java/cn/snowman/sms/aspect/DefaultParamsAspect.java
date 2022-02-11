package cn.snowman.sms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author kangz
 */
@Aspect
public class DefaultParamsAspect {


    @Before("@annotation(cn.snowman.sms.annotation.DefaultParams)")
    public void beforEvent(JoinPoint joinPoint) {

        // TODO 自动注入基础属性（创建者、创建时间、修改者、修改时间）

    }

}
