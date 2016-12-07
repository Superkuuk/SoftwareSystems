package ss.week4.math;

public interface Function {

	/**
	 * Calculates the value of this function.
	 * @return double
	 */
	public double apply(double d);
	
	/**
	 * Returns the derivative of this function.
	 * @return Function
	 */
	public Function derivative();
	
	/**
	 * Returns a nice and cozy string with the value of this function.
	 * @return String
	 */
	public String toString();
	
}
