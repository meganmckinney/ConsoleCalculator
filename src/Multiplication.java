/**
 * 
 * @author Megan McKinney
 * 
 * The Multiplication class implements the Calculator interface.
 * It takes care of any of the calculations involved in multiplication
 *
 */
public class Multiplication implements Calculator {
	
	/**
	 * @param x double is the first input value
	 * @param y double is the second input value
	 * @return the solution of the multiplication
	 * 
	 * This calculate method takes care of the calculations for multiplication.
	 */
	@Override
	public double calculate(double x, double y) {
		return x * y;
	}
}
