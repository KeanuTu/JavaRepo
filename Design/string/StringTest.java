package string;

public class StringTest {

	public static void main(String[] args) {
        String str = "syc" ;
        String str1 = "";        
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000; ++ i) {
            str1 += str; 
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String������ʱ�� = " + (endTime - startTime));
         
        
        startTime = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer("");
        for(int i = 0; i < 100000; ++ i) {
            sBuffer.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer������ʱ�� = " + (endTime - startTime));
        
        startTime = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder("");
        for(int i = 0; i < 100000; ++ i) {
            sBuilder.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder������ʱ�� = " + (endTime - startTime));
        
        StringBuilder sb= new StringBuilder();
        sb.append("Java,World");				//append�����������ַ���ĩβ��ӵ�
        sb.insert(5, "Hello ");					//insert������ָ��offset��ʼ�ַ���λ�ú����
        System.out.println("���뷽��:"+sb);
        
        sb.deleteCharAt(4);						//deleteCharAt����ɾ��һ���ַ�
        sb.delete(0, 4);						//delete(int start,int end)ɾ��һ���ַ���
        System.out.println("ɾ������:"+sb);
        
        sb.reverse();							//�ַ�����ת
        System.out.println("�ַ�����ת:"+sb);
        sb.reverse();
        
        sb.setCharAt(0, 'h');					//setCharAt(index, ch)�滻�����ַ�
        System.out.println(sb);
        sb.replace(0, 5, "Hello");				//replace(start, end, str1)�滻ĳ���ַ���
        System.out.println(sb);
        
          
    }
}

/**
 * 1���ٶȣ�
 * String������ٶ���������Ϊ�����ַ����������κζ�String��ĸı䶼�������µ�String�������ɡ�
 * ��StringBuilder��StringBuffer�඼���ַ������������������������Ĳ��������Բ�������µĶ���
 * 2����ȫ��
 * StringBuffer���еķ�����������synchronized���Σ�������̰߳�ȫ�ģ������ַ���������������̵߳���ʱ��JVM���ܱ�֤StringBuilder������ǰ�ȫ��
 * 3������ʹ��
 * ������������ʱ������ʹ��String�ࣻ���̲߳����ַ����������´����ַ�������ʱ��ʹ��StringBuilder�ࣻ���߳���StringBuffer��
 */
