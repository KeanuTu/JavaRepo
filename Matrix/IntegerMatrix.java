package Matrix;

public class IntegerMatrix extends GernericMatrix<Integer> {
	//实现GernericMatrix中的三个抽象方法
	@Override
	protected Integer add(Integer o1, Integer o2) {
		// TODO 自动生成的方法存根
		return o1+o2;
	}

	@Override
	protected Integer multiply(Integer o1, Integer o2) {
		// TODO 自动生成的方法存根
		return o1*o2;
	}

	@Override
	protected Integer zero() {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	
}
