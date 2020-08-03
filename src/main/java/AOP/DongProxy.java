package AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*动态代理(都需要实现 InvocationHandler 接口)（代理的是接口，不是实现类）

* 两种方式：
* 基于接口：jdk(最常用)
* 基于类:cglib
*
* 这是一个生成代理角色的代理程序，并非代理角色
* */
public class DongProxy implements InvocationHandler{
    /**
     * 目标对象（被代理的接口）
     */
    private Object target;

    /**
     * 生成并返回代理类实例
     * @param obj 绑定具体的代理实例，生成代理角色
     * @return 动态代理类实例
     */
    public Object getInstance(Object obj) {
        this.target = obj;
        Class<?> clazz = this.target.getClass();
        // Proxy 提供了创建动态代理类和实例的静态方法
        /*
        该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例。
        第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器。
        第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口。
        第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        根据传入的目标返回一个代理对象
        */
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
    /**
     * 处理代理实例（加入扩展功能），并返回结果
     * @param proxy  代理
     * @param method 原对象被调用的方法
     * @param args   方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        //动态代理的本质就是反射实现的
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("物色成功");
    }
    private void before() {
        System.out.println("我是媒婆，以拿到需求");
        System.out.println("开始物色人选");
    }
}
