
public class Root implements Calculator {
	
	/**
	 * @param x double
	 * @param y double
	 * @returns the product of a root equation
	 */
	@Override
	public double calculate(double x, double y) {
		return Math.pow(Math.E, Math.log(x)/y);
	}

}
