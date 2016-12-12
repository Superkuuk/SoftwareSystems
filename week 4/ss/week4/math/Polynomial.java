package ss.week4.math;

public class Polynomial implements Integrandable {

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
		Function f;
		if (fArray.length == 0) {
			f = null;
		} else if (fArray.length == 1) {
			f = fArray[0];
		} else {
			f = new Sum(fArray[0].derivative(), fArray[1].derivative());
		
			for (int i = 2; i < fArray.length; i++) {
				f = new Sum(f, fArray[i].derivative());
			}		
		}
		return f;
	}

	@Override
	public String toString() {
		String s = "(";
		for (int i = 0; i < fArray.length; i++) {
			s += fArray[i].toString();
		}
		return s + ")";
	}

	@Override
	public Function integrand() {
		Function f;
		if (fArray.length == 0 || !(fArray[0] instanceof Integrandable)) {
			f = null;
		} else if (fArray.length == 1 && fArray[1] instanceof Integrandable) {
			f = ((Integrandable) fArray[0]).integrand();
		} else {
			f = new Sum(((Integrandable) fArray[0]).integrand(), 
				((Integrandable) fArray[1]).integrand());		
		
			for (int i = 2; i < fArray.length; i++) {
				f = new Sum(f, ((Integrandable) fArray[i]).integrand());
			}		
		}
		return f;
	}
}
