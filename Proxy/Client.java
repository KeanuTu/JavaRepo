package Proxy;

public class Client {

	public static void main(String[] args) {
		// 静态代理模式
		StarObject star = new Broker(new Star());
		star.show("Jack Ma");
	}
}
