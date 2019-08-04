/**
 * 
 * @author Megan McKinney
 *
 * RaisePower implements the Calculator interface.
 * This class handles all operations associated with raising a value to the nth power.
 *
 */
public class RaisePower implements Calculator {
	
	/**
	 * @param x double is the first input value
	 * @param y double is the second input value
	 * @return the solution raised to the nth power
	 * 
	 * Handles the operations involved with raising a value to the nth power
	 */
	@Override
	public double calculate(double x, double y){
		
		return Math.pow(x, y);
	}
}
