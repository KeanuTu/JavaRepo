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
        System.out.println("String类运行时间 = " + (endTime - startTime));
         
        
        startTime = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer("");
        for(int i = 0; i < 100000; ++ i) {
            sBuffer.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer类运行时间 = " + (endTime - startTime));
        
        startTime = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder("");
        for(int i = 0; i < 100000; ++ i) {
            sBuilder.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder类运行时间 = " + (endTime - startTime));
        
        StringBuilder sb= new StringBuilder();
        sb.append("Java,World");				//append方法都是在字符串末尾添加的
        sb.insert(5, "Hello ");					//insert方法是指定offset起始字符串位置后插入
        System.out.println("插入方法:"+sb);
        
        sb.deleteCharAt(4);						//deleteCharAt方法删除一个字符
        sb.delete(0, 4);						//delete(int start,int end)删除一个字符串
        System.out.println("删除方法:"+sb);
        
        sb.reverse();							//字符串反转
        System.out.println("字符串反转:"+sb);
        sb.reverse();
        
        sb.setCharAt(0, 'h');					//setCharAt(index, ch)替换单个字符
        System.out.println(sb);
        sb.replace(0, 5, "Hello");				//replace(start, end, str1)替换某个字符串
        System.out.println(sb);
        
          
    }
}

/**
 * 1、速度：
 * String类操作速度最慢是因为它是字符串常量，任何对String类的改变都会引起新的String对象生成。
 * 而StringBuilder和StringBuffer类都是字符变量，对其操作类似于链表的操作，所以不会产生新的对象。
 * 2、安全：
 * StringBuffer类中的方法大多采用了synchronized修饰，因此是线程安全的，当在字符串缓冲区被多个线程调用时，JVM不能保证StringBuilder类操作是安全的
 * 3、具体使用
 * 操作少量数据时，可以使用String类；单线程操作字符串缓冲区下大量字符串数据时，使用StringBuilder类；多线程用StringBuffer。
 */
