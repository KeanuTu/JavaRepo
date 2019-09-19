package Proxy;

/**
* 定义一个委托类Star实现接口StarObject,使其具有一定的业务能力
 */
public class Star implements StarObject {
	@Override
	public void show(String name) {
		System.out.println("我是明星"+name+"，我在演出。");
	}

}
