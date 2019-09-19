package Proxy;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BrokerDynamic {
	private StarObject star;
	
	public BrokerDynamic(StarObject star){
		this.star=star;		//����ʵ����
	}
	
	/**
	 * ����˵��:
	 * ��һ������Ϊ�����������������ʹ��StarObject�ӿڣ���ֱ�ӵõ�����Ӧ���������;
	 * �ڶ���������ָʵ����ʵ�ֵĽӿ��б���������ֻʵ��StarInterface�ӿڣ���ֻ��һ����
	 * ����������Ϊһ��ʵ���˵��ô�����InvocationHandler�ӿڵ�ʵ��
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
