/**
 * 
 * @author mmcki
 * 
 * The Division class implements the calculator interface.
 * It takes care of the calculations for division.
 *
 */
public class Division implements Calculator{
	
	/**
	 * @param x double is the first input value passed in
	 * @param y double is the second input value passed in
	 * @returns the quotient
	 */
	@Override
	public double calculate (double x, double y) {
		return x / y;
	}

}
