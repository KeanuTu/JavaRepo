package Proxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class Dynamic {

	public static void main(String[] args) {
		/**
		 * 参数说明:
		 * 第一个参数为类加载器，我们这里使用StarInterface接口，就直接得到它对应的类加载器;
		 * 第二个参数是指实类所实现的接口列表，我们这里只实现StarInterface接口，故只传一个；
		 * 第三个参数为一个实现了调用处理器InvocationHandler接口的实例
		 */
		StarObject star = new Star();
		StarObject dynamicProxy=(StarObject) new BrokerDynamic(star).getProxyInstance();
		
		dynamicProxy.show("Jack Ma");
		//在调用star的show方法时，代理类会转为去调用BrokerDynamic类invoke方法
		//invoke方法的参数proxy就是发起调用的代理类star实例
		//method就是指show()方法
		//args就是调用show()方法时传的参数"Jack Ma"

	}

}
