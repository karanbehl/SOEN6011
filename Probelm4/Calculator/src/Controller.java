import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class Controller {

	private View theView;
	private Model theModel;

	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class

		this.theView.addCalculateListener(new CalculateListener());
		
	}


	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				if(secondNumber>=0)
				{
					theModel.addTwoNumbers(firstNumber, secondNumber);
					theView.setCalcSolution(theModel.getCalculationaddValue());
				}
				else
				{
					int temp= Math.abs(secondNumber);
					theModel.addTwoNumbers(firstNumber, temp);
					theView.setCalcSolution(1/theModel.getCalculationaddValue());
					
				}

			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

}
