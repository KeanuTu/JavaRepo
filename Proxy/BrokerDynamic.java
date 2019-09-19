package Proxy;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BrokerDynamic {
	private StarObject star;
	
	public BrokerDynamic(StarObject star){
		this.star=star;		//传入实现类
	}
	
	/**
	 * 参数说明:
	 * 第一个参数为类加载器，我们这里使用StarObject接口，就直接得到它对应的类加载器;
	 * 第二个参数是指实类所实现的接口列表，我们这里只实现StarInterface接口，故只传一个；
	 * 第三个参数为一个实现了调用处理器InvocationHandler接口的实例
	 */
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(star.getClass().getClassLoader()
				,star.getClass().getInterfaces()
				,new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before ...");
                Object ret = method.invoke(star, args);
                System.out.println("After ...");
                return ret;
            }
		});
	}
}
