package Matrix;


public class TestIntegerMatrix {
	
	private static final GernericMatrix<Integer> GenericMatrix = null;

	public static void main(String[] args) {
		//����Integer����
		Integer[][] m1 = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
		Integer[][] m2 = {{1,5,1},{2,4,2},{0,0,0}};
		
		//����IntegerMatrixʵ��
		IntegerMatrix iM = new IntegerMatrix();
		
		System.out.println("��������ӷ���");
		GenericMatrix.printResult(m1,m2,iM.addMatrix(m1,m2),'+');
		
		System.out.println("��������˷���");
		GenericMatrix.printResult(m1,m2,iM.multiplyMatrix(m1, m2),'*');
	}	
}
