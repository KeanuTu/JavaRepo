package Matrix;

//Rational ��������,����������ʽ
public class RationalMatrix extends GernericMatrix<Rational> {

	@Override
	protected Rational add(Rational o1, Rational o2) {
		// TODO �Զ����ɵķ������
		return o1.add(o2);
	}

	@Override
	protected Rational multiply(Rational o1, Rational o2) {
		// TODO �Զ����ɵķ������
		return o1.multiply(o2);
	}

	@Override
	protected Rational zero() {
		// TODO �Զ����ɵķ������
		return new Rational(0,1);
	}


	

	

}
