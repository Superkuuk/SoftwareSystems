package ss.week4.math;

public class Constant implements Function {

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
		return "constant " + value;
	}
}
