// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class View extends JFrame{

	private JLabel displayTextX = new JLabel("Value of x");
	private JTextField firstNumber  = new JTextField(10);
	private JLabel displayTextY = new JLabel("Value of y");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("=");
	private JTextField calcSolution = new JTextField(10);

	View(){

		// Sets up the view and adds the components

		JPanel calcPanel = new JPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		calcPanel.add(displayTextX);
		calcPanel.add(firstNumber);
		calcPanel.add(displayTextY);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);

		// Number Panel
				JPanel numberPanel = new JPanel(new GridLayout(4, 3));
				calcPanel.add(numberPanel);

				ArrayList<String> listButton = new ArrayList<>();
				listButton.add("7");
				listButton.add("8");
				listButton.add("9");
				listButton.add("4");
				listButton.add("5");
				listButton.add("6");
				listButton.add("1");
				listButton.add("2");
				listButton.add("3");
				listButton.add("C");
				listButton.add("0");
				listButton.add("CE");

				for(String buttonName : listButton) {
					JButton button = new JButton(buttonName);
					//button.addActionListener(controller.actionListener());
					numberPanel.add(button);
				}
				
				
		this.add(calcPanel);


		// End of setting up the components --------

	}

	public int getFirstNumber(){

		return Integer.parseInt(firstNumber.getText());

	}

	public int getSecondNumber(){

		return Integer.parseInt(secondNumber.getText());

	}

	public int getCalcSolution(){

		return Integer.parseInt(calcSolution.getText());

	}

	public void setCalcSolution(double solution){

		calcSolution.setText(Double.toString(solution));

	}

	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed

	void addCalculateListener(ActionListener listenForCalcButton){

		calculateButton.addActionListener(listenForCalcButton);

	}


	// Open a popup that contains the error message passed

	void displayErrorMessage(String errorMessage){

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}
