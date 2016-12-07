package ss.week4.math;

public class Polynomial implements Function {

	private Function[] fArray;
	
	public Polynomial(double[] arr) {
		fArray = new Function[arr.length];
		for (int i = 0; i < fArray.length; i++) {
			fArray[i] = new LinearProduct(new Constant(arr[i]), new Exponent(i));
		}
	}
	
	@Override
	public double apply(double d) {
		double sum = 0;
		for (int i = 0; i < fArray.length; i++) {
			sum += fArray[i].apply(d);
		}
		return sum;
	}

	@Override
	public Function derivative() {
		Sum f;
		f = new Sum(fArray[0].derivative(), fArray[1].derivative());
		
		for (int i = 2; i < fArray.length; i++) {
			f = new Sum(f, fArray[i].derivative());
		}		
		
		return f;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < fArray.length; i++) {
			s += fArray[i].toString();
		}
		return s;
	}
}
