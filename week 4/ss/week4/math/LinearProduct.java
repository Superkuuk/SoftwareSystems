package ss.week4.math;

public class LinearProduct extends Product implements Integrandable  {

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

	@Override
	public Function integrand() {
		if (g instanceof Integrandable) {
			return new LinearProduct(n, ((Integrandable) g).integrand());
		} else {
			return null;
		}
	}
}