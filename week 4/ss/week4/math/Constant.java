package ss.week4.math;

public class Constant implements Integrandable {

	private double value;
	
	public Constant(double d) {
		value = d;
	}
	
	@Override
	public double apply(double d) {
		return value;
	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}

	@Override
	public String toString() {
		return "(" + value + ")";
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(value), new Exponent(1));
	}
}
