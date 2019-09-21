package Matrix;


public class TestIntegerMatrix {
	
	private static final GernericMatrix<Integer> GenericMatrix = null;

	public static void main(String[] args) {
		//创建Integer数组
		Integer[][] m1 = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
		Integer[][] m2 = {{1,5,1},{2,4,2},{0,0,0}};
		
		//创建IntegerMatrix实例
		IntegerMatrix iM = new IntegerMatrix();
		
		System.out.println("整数矩阵加法：");
		GenericMatrix.printResult(m1,m2,iM.addMatrix(m1,m2),'+');
		
		System.out.println("整数矩阵乘法：");
		GenericMatrix.printResult(m1,m2,iM.multiplyMatrix(m1, m2),'*');
	}	
}
