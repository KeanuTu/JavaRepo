package Proxy;

/**
* ����һ��ί����Starʵ�ֽӿ�StarObject,ʹ�����һ����ҵ������
 */
public class Star implements StarObject {
	@Override
	public void show(String name) {
		System.out.println("��������"+name+"�������ݳ���");
	}

}
