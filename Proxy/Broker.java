package Proxy;

/**
* 代理类Broker同样实现StarObject接口的方法，在代理类中即可实现委托类的方法
* 又可以增加自己想要的方法
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
