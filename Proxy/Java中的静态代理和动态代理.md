# Java中的静态代理和动态代理

### Q1：什么是代理？

A：代理是设计模式的一种，代理类**(Proxy Subject)**为委托类**(Real Subject)**提供消息预处理，消息转发，事后消息处理等功能。

![代理模式](代理模式.webp)

更明白的说，如果RealSubject是明星，ProxySubject是经纪人，如果想谈明星来演出，则跟经纪人说就能实现明星演出这件事，但经纪人在安排明星演出这件事上，还需要做其他的一些事情，比如出场费的讨论、安保工作和行程安排等。经纪人就是明星的代理人。



### Q2：什么是静态代理？什么是动态代理？

Java中的静态代理要求代理类和委托类都实现同一接口。静态代理中代理类在编译期就已经确定，而动态代理则是JVM运行时动态生成的，静态代理的效率相对于动态的代理来说相对高一点，但是静态代理代码冗余太大，一旦需要修改接口，代理类和委托类都要修改。

#### **静态代理**

**接口(Subject):**

```Java
/**
 * 定义一个明星接口StarObject
 */
public interface StarObject {
	public void show(String name);
}
```

**委托类(RealSubject):**

```Java
/**
* 定义一个委托类Star实现接口StarObject,使其具有一定的业务能力
 */
public class Star implements StarObject {
	@Override
	public void show(String name) {
		System.out.println("我是明星"+name+"，我在演出。");
	}

}

```

**代理类(ProxySubject):**

```Java
/**
* 代理类Broker同样实现StarObject接口的方法，在代理类中即可实现委托类的方法又可以增加自己想要的方法
 */
public class Broker implements StarObject {
	private Star star;	//实例委托类的对象，方便在后面调用委托类实现接口的方法
	
	public Broker(Star star) {
		this.star = star;
	}

	@Override
	public void show(String name) {
		System.out.println("我是经纪人，现在去叫" + name + "来演出。");
		star.show(name);
        System.out.println("我是经纪人，" + name + "演出结束，谢谢大家。");
	}

}
```

**测试类(Client):**

```java
public class Client {

	public static void main(String[] args) {
		// 静态代理模式
		StarObject star = new Broker(new Star());
		star.show("Jack Ma");
	}
}
```

------

#### 动态代理

**动态代理类(ProxyDynamic):**

```java
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
        /*public interface InvocationHandler {
        public Object invoke(Object proxy,Method method,Object[] args) throws Throwable; 
        } 
        参数说明： 
        Object proxy：指被代理的对象。 
        Method method：要调用的方法 
        Object[] args：方法调用时所需要的参数 
可以将InvocationHandler接口的子类想象成一个代理的最终操作类。
		*/
	}
}
```

**测试类（Dynamic）:**

```java
public class Dynamic {

	public static void main(String[] args) {
		
		StarObject star = new Star();
		StarObject dynamicProxy=(StarObject) new BrokerDynamic(star).getProxyInstance();
		
		dynamicProxy.show("Jack Ma");
		//在调用star的show方法时，代理类会转为去调用BrokerDynamic类invoke方法
		//invoke方法的参数proxy就是发起调用的代理类star实例
		//method就是指show()方法
		//args就是调用show()方法时传的参数"Jack Ma"

	}

}
```



### Q3：静态代理和动态代理间的联系是？

1. 静态代理实现较简单，代理类在编译期生成，效率高。缺点是会生成大量的代理类。
2. JDK动态代理不要求代理类和委托类实现同一个接口，但是委托类需要实现接口，代理类需要实现InvocationHandler接口。
3. 动态代理要求代理类InvocationHandler接口，通过反射代理方法，比较消耗系统性能，但可以减少代理类的数量，使用更灵活。