package Matrix;

public class IntegerMatrix extends GernericMatrix<Integer> {
	//ʵ��GernericMatrix�е��������󷽷�
	@Override
	protected Integer add(Integer o1, Integer o2) {
		// TODO �Զ����ɵķ������
		return o1+o2;
	}

	@Override
	protected Integer multiply(Integer o1, Integer o2) {
		// TODO �Զ����ɵķ������
		return o1*o2;
	}

	@Override
	protected Integer zero() {
		// TODO �Զ����ɵķ������
		return 0;
	}
	
	
}
