package ss.week4.math;

public class Exponent implements Integrandable {

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
		return "(x ^ " + n + ")";
	}

	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(1.0 / (n + 1.0)), new Exponent(n + 1));
	}

}
