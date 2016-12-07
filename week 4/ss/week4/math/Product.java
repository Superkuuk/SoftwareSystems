package ss.week4.math;

public class Product implements Function {
	
	private Function function1;
	private Function function2;
	
	public Product(Function a, Function b) {
		function1 = a;
		function2 = b;
	}
	
	@Override
	public double apply(double a) {
		return function1.apply(a) * function2.apply(a);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(function1.derivative(), function2), 
				new Product(function1, function2.derivative()));
	}
	
	@Override
	public String toString() {
		return function1.toString() + " * " + function2.toString();
	}

}
