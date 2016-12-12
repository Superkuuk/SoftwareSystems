package ss.week4.math;

public class Sum implements Integrandable {
	
	private Function function1;
	private Function function2;
	
	public Sum(Function a, Function b) {
		function1 = a;
		function2 = b;
	}
	
	@Override
	public double apply(double a) {
		return function1.apply(a) + function2.apply(a);
	}

	@Override
	public Function derivative() {
		return new Sum(function1.derivative(), function2.derivative());
	}
	
	@Override
	public String toString() {
		return "(" + function1.toString() + " + " + function2.toString() + ")";
	}

	@Override
	public Function integrand() {
		if (function1 instanceof Integrandable && function2 instanceof Integrandable) {
			return new Sum(((Integrandable) function1).integrand(), 
					((Integrandable) function2).integrand());
		} else {
			return null;
		}
	}

}
