package Proxy;

/**
* ������Brokerͬ��ʵ��StarObject�ӿڵķ������ڴ������м���ʵ��ί����ķ���
* �ֿ��������Լ���Ҫ�ķ���
 */
public class Broker implements StarObject {
	private Star star;	//ʵ��ί����Ķ��󣬷����ں������ί����ʵ�ֽӿڵķ���
	
	public Broker(Star star) {
		this.star = star;
	}

	@Override
	public void show(String name) {
		System.out.println("���Ǿ����ˣ�����ȥ��" + name + "���ݳ���");
		star.show(name);
        System.out.println("���Ǿ����ˣ�" + name + "�ݳ�������лл��ҡ�");
	}

}
