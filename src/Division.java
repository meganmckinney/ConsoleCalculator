/**
 * 
 * @author Megan McKinney
 * 
 * The Division class implements the calculator interface.
 * It takes care of the calculations for division.
 *
 */
public class Division implements Calculator{
	
	/**
	 * @param x double is the first input value passed in
	 * @param y double is the second input value passed in
	 * @returns the solution of the division
	 *
	 * This method handles the calculations involved in division.
	 */
	@Override
	public double calculate (double x, double y) {
		return x / y;
	}
}
