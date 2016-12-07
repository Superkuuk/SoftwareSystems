package ss.week4.math;

public class LinearProduct extends Product implements Function  {

	private Function n;
	private Function g;
	
	public LinearProduct(Function n, Function g) {
		super(n, g);
		this.n = n;
		this.g = g;
	}

	@Override
	public Function derivative() {
		return new LinearProduct(n,  g.derivative());
	}
}