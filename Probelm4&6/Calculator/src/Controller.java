import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* Controller cordinate interaction between View and Model
* @author  Karan Behl
* @version 1.0
* @since   2019-07-29 
*/

public class Controller {

	private View theView;
	
	public Controller(View theView, Model theModel) {
		this.theView = theView;
		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		this.theView.addCalculateListener(new CalculateListener());
		}
	
	
	/**
	* CalculateListener class is actionlistener for "=" button
	* @author  Karan Behl
	* @version 1.0
	* @since   2019-07-29 
	*/
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber = 0;
			int secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			try{
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				modelInteraction(firstNumber,secondNumber);
			}
			catch(NumberFormatException ex){
				theView.displayErrorMessage("You Need to Enter 2 Integers");
			}
		}
		
		/**
		   * This method is used to interact with Modelfor Calculations
		   * @param firstNumber(int), secondNumber(int)
		   */
		public void modelInteraction(int firstNumber, int secondNumber){
			double result = Model.functionalCal(firstNumber,secondNumber);
			theView.setCalcSolution(firstNumber,secondNumber,result);
		}
	}

}



