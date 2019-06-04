
/**
 * 
 * @author mmcki
 * 
 * Subtraction class, implements the calculator interface
 * Deals with subtraction in the calculator
 *
 */
public class Subtraction implements Calculator{
	
	/**
	 * @param x double, is the first input value passed in
	 * @param y double, is the second input value passed in
	 * 
	 * This method performs subtraction operation
	 */
	@Override
	public double calculate(double x, double y) {
		return x - y;
	}

}
