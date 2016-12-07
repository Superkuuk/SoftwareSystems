package ss.week4.math;

public class Exponent implements Function {

	private int n;
	
	public Exponent(int n) {
		this.n = n;
	}
	
	@Override
	public double apply(double d) {
		return Math.pow(d, n);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(n), new Exponent(n - 1));
	}
	
	@Override
	public String toString() {
		return "x ^ " + n;
	}

}
