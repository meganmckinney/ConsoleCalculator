/**
 * 
 * @author mmcki
 *
 *The Addition class implements the Calculator interface.
 *
 *This class takes care of the calculations involved in addition
 *
 */
public class Addition implements Calculator {
	
	/**
	 * This method takes care of the calculations involved in addition
	 * @param x double is the first input value passed in
	 * @param y double is the second input value passed in
	 */
	@Override
	public double calculate(double x, double y) {
		return x + y;
	}
	

}
