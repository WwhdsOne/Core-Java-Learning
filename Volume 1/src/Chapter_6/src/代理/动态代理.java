package Chapter_6.src.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/24 19:08
 * @description 补充Core Java第一卷内容
 **/
public class 动态代理 {
    public static void main(String[] args) throws Throwable {
        // 在 Java 动态代理机制中 InvocationHandler 接口和 Proxy 类是核心。
        // 要实现动态代理的话，还必须需要实现InvocationHandler 来自定义处理逻辑。
        // 当我们的动态代理对象调用一个方法时，这个方法的调用就会被转发到实现InvocationHandler 接口类的 invoke 方法来调用。
        // 1. JDK 动态代理类使用步骤定义一个接口及其实现类；
        class DebugInvocationHandler implements InvocationHandler {
            private final Object target;
            public DebugInvocationHandler(Object target) {
                this.target = target;
            }
            // 2. 自定义 InvocationHandler 并重写invoke方法，在 invoke 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
            // invoke() 方法有下面三个参数：
            // proxy :动态生成的代理类
            // method : 与代理类对象调用的方法相对应
            // args : 当前 method 方法的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("调用方法之前");
                Object result = method.invoke(target, args);
                System.out.println("调用方法之后");
                return result;
            }
        }
        // 3. 通过 Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) 方法创建代理对象；
        // Proxy 类中使用频率最高的方法是：newProxyInstance() ，这个方法主要用来生成一个代理对象。
        // 这个方法一共有 3 个参数：
        // loader :类加载器，用于加载代理对象。
        // interfaces : 被代理类实现的一些接口；
        // h : 实现了 InvocationHandler 接口的对象；
        Eat eat = (Eat) Proxy.newProxyInstance(
                Person.class.getClassLoader(), // 目标类的类加载器
                Person.class.getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(new Person())   // 代理对象对应的自定义 InvocationHandler
        );
        eat.eat();
    }
}
