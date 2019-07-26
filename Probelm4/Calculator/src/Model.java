// The Model performs all the calculations needed
// and that is it. It doesn't know the View
// exists

public class Model {

	// Holds the value of the sum of the numbers
	// entered in the view

	private double calculationaddValue, calculationsubValue;

	// Iterative solution to calculate pow(x, n) using binary operators
	public void addTwoNumbers(int x, int y){
		
		
		int pow = 1;

		// do till n is not zero
		while (y > 0)
		{
			// if n is odd, multiply result by x
			if ((y & 1) == 1) {
				pow *= x;
			}

			// divide n by 2
			y = y >> 1;

			// multiply x by itself
			x = x * x;
		}

		calculationaddValue = pow;

	}

	
	
	// Iterative solution to calculate pow(x, n) using binary operators
		public static double power(int x, int y)
		{
			double pow = 1;

			// do till n is not zero
			while (y > 0)
			{
				// if n is odd, multiply result by x
				if ((y & 1) == 1) {
					pow *= x;
				}

				// divide n by 2
				y = y >> 1;

				// multiply x by itself
				x = x * x;
			}

			// return result
			return pow;
		}



	public double getCalculationaddValue(){

		return calculationaddValue;

	}



}
