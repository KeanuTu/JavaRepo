package Proxy;

public class Client {

	public static void main(String[] args) {
		// ��̬����ģʽ
		StarObject star = new Broker(new Star());
		star.show("Jack Ma");
	}
}
