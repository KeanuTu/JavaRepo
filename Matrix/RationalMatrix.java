package Matrix;

//Rational 有理数集,即分数的形式
public class RationalMatrix extends GernericMatrix<Rational> {

	@Override
	protected Rational add(Rational o1, Rational o2) {
		// TODO 自动生成的方法存根
		return o1.add(o2);
	}

	@Override
	protected Rational multiply(Rational o1, Rational o2) {
		// TODO 自动生成的方法存根
		return o1.multiply(o2);
	}

	@Override
	protected Rational zero() {
		// TODO 自动生成的方法存根
		return new Rational(0,1);
	}


	

	

}
