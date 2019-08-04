/**
 * 
 * @author mmcki
 * 
 * The Modulo class implements the Calculator interface.
 * It is responsible for handling the modulo division in the calculator.
 *
 */
public class Modulo implements Calculator {
	
	/**
	 * @param x double is the first input value
	 * @param y double is the second input value
	 * @return remainder of the division
	 * 
	 * This method is responsible for handling the modulo division operation
	 */
	@Override
	public double calculate(double x, double y) {
		return x % y;
	}
}
