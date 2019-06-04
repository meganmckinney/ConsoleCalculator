
public class Root implements Calculator {
	
	@Override
	public double calculate(double x, double y) {
		return Math.pow(Math.E, Math.log(x)/y);
	}

}
