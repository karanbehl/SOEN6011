/**
* Model performs all calculations only.
* @author  Karan Behl
* @version 1.0
* @since   2019-07-29 
*/

public class Model {

	
	private static double calculation;
	
	/**
	   * This method is Iterative solution to calculate pow(x, y) using binary operators
	   * @param x(int), y(int)
	   * @return pow(double).
	   */
	public static double power(int x, int y){
		double pow = 1;
		// do till n is not zero
		while (y > 0){
			// if n is odd, multiply result by x
			if ((y & 1) == 1) {
				pow *= x;
				}
			// divide n by 2
			y = y >> 1;
			// multiply x by itself
			x = x * x;
			}
		calculation = pow;
		// return result
		return pow;
		}
	
	/**
	   * This method is for checking y is positive or negative
	   * It performs calculation according to input
	   * @param firstNumber(int), secondNumber(int)
	   * @return (double).
	   */
	public static double functionalCal(int firstNumber, int secondNumber)
	{
		if(secondNumber>=0){
			power(firstNumber, secondNumber);
			return getCalculation();
		}
		else{
			int temp= Math.abs(secondNumber);
			power(firstNumber, temp);
			return (1/getCalculation());
		}
	}
	
	/**
	   * This method is used to get calculated value of function
	   * @return (double).
	   */
	public static double getCalculation(){
		return calculation;
	}



}
