package Proxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class Dynamic {

	public static void main(String[] args) {
		/**
		 * ����˵��:
		 * ��һ������Ϊ�����������������ʹ��StarInterface�ӿڣ���ֱ�ӵõ�����Ӧ���������;
		 * �ڶ���������ָʵ����ʵ�ֵĽӿ��б���������ֻʵ��StarInterface�ӿڣ���ֻ��һ����
		 * ����������Ϊһ��ʵ���˵��ô�����InvocationHandler�ӿڵ�ʵ��
		 */
		StarObject star = new Star();
		StarObject dynamicProxy=(StarObject) new BrokerDynamic(star).getProxyInstance();
		
		dynamicProxy.show("Jack Ma");
		//�ڵ���star��show����ʱ���������תΪȥ����BrokerDynamic��invoke����
		//invoke�����Ĳ���proxy���Ƿ�����õĴ�����starʵ��
		//method����ָshow()����
		//args���ǵ���show()����ʱ���Ĳ���"Jack Ma"

	}

}
