package log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class LogAop implements MethodBeforeAdvice {

    /*method:要执行的目标对象的方法
    * objects:参数
    * o:目标对象
    * */
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "的" + method.getName() + "被执行了");
    }

}
