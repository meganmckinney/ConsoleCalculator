/**
 * 
 * @author Megan McKinney
 * 
 * The Root class implements the Calculator interface.
 * This class is responsible for all calculations involved in taking the nth root.
 *
 */
public class Root implements Calculator {
	
	/**
	 * @param x double
	 * @param y double
	 * @returns the solution with the nth root taken
	 *
	 * Handles the operations involved in taking the nth root.
	 */
	@Override
	public double calculate(double x, double y) {
		return Math.pow(Math.E, Math.log(x)/y);
	}
}
