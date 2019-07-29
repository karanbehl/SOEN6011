import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;


/**
* This is Main class.Its only job is to display what the user sees.
* It performs no calculation but instead passes information entered by user.
* @author  Karan Behl
* @version 1.0
* @since   2019-07-29 
*/

public class View extends JFrame{

	private JLabel displayTextX = new JLabel("Value of x");
	private JTextField firstNumber  = new JTextField(10);
	private JLabel displayTextY = new JLabel("Value of y");
	private JTextField secondNumber = new JTextField(10);
	public JButton calculateButton = new JButton("=");
	private JTextField calcSolution = new JTextField(10);
	private ArrayList<String> listButton= new ArrayList<>();
	private JPanel calcPanel = new JPanel();
	private JPanel numberPanel = new JPanel(new GridLayout(4, 3));
	private JButton[] button = new JButton[12];
	private JButton historyButton = new JButton("History");
	private ArrayList<Integer> focusLog = new ArrayList<>();
	private ArrayList<HistoryHelper> historyList = new ArrayList<>();
	View(){
		// Sets up the view and adds the components
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
		listButton.add("7");
		listButton.add("8");
		listButton.add("9");
		listButton.add("4");
		listButton.add("5");
		listButton.add("6");
		listButton.add("1");
		listButton.add("2");
		listButton.add("3");
		listButton.add(".");
		listButton.add("0");
		listButton.add("C");
		for(int i=0;i<listButton.size();i++) {
			button[i]= new JButton(listButton.get(i));
			button[i].addActionListener(listener);
			numberPanel.add(button[i]);
		}
		calcPanel.add(historyButton);
		firstNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
		       focusLog.add(1);
		       }
		      public void focusLost(FocusEvent e) {
		      }
		    });
		secondNumber.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		       focusLog.add(2);
		       }
		      public void focusLost(FocusEvent e) { 
		      }
		    });
		this.add(calcPanel);
		historyButton.addActionListener(listenerHistory);
		// End of setting up the components --------
	}

	/**
	   * This method is used to get value from JTextfield named firstNumber
	   * @return firstNumber(Integer).
	   */
	public int getFirstNumber(){
		return Integer.parseInt(firstNumber.getText());
	}

	/**
	   * This method is used to get value from JTextfield named secondNumber
	   * @return secondNumber(Integer).
	   */
	public int getSecondNumber(){
		return Integer.parseInt(secondNumber.getText());

	}

	/**
	   * This method is used to get value from JTextfield named calcSolution
	   * @return calcSolution(Integer).
	   */
	public int getCalcSolution(){
		return Integer.parseInt(calcSolution.getText());
	}

	/**
	   * This method is used for maintaing history of calculation
	   * @param firstNumber(double),secondNumber(double),solution(double)
	   */
	public void setCalcSolution(double firstNumber,double secondNumber,double solution){
		calcSolution.setText(Double.toString(solution));
		HistoryHelper helper = new HistoryHelper();
		helper.setSolution(solution);
		helper.setValueofx(firstNumber);
		helper.setValueofy(secondNumber);
		historyList.add(helper);
	}
	
	/**
	   * This method is used to set data in firstNumber JTextfield
	   * @param data(String)
	   */
	public void setFirstNumber(String data){
		firstNumber.setText(data);
	}
	
	/**
	   * This method is used to set data in secondNumber JTextfield
	   * @param data(String)
	   */
	public void setSecondNumber(String data){
		secondNumber.setText(data);
	}
	
	/**
	   * This method is used to check last focused JTextfield
	   * This method helps virtual keyboard
	   * @return textboxNumber(Integer)
	   */
	public int checkFocusedBox() {
		if(focusLog.get(focusLog.size()-1)==1)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}

	
	/**
	   * If the calculateButton is clicked execute a method
	   * in the Controller named actionPerformed
	   * @param datalistenForCalcButton(ActionListener)
	   */
	void addCalculateListener(ActionListener listenForCalcButton){
		calculateButton.addActionListener(listenForCalcButton);
		}
	
	
	/**
	   * If the calculateButton is clicked execute a method
	   * in the View named listneforKeyBoard
	   * @param data(String)
	   */
	void addKeyboardListner(ActionListener listneforKeyBoard){
		for(int i=0;i<listButton.size();i++) {
			button[i]= new JButton(listButton.get(i));
			button[i].addActionListener(listneforKeyBoard);
			}
		}

	
	/**
	   * Open a popup that contains the error message passed
	   * @param errorMessage(String)
	   */
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	
	/**
	   * This method helps to set text 
	   * when data is entered from virtual keyboard 
	   * @param data(String)
	   */
	public void performChanges(String data) {
		if(data=="C") {
			setFirstNumber("");
			setSecondNumber("");
			calcSolution.setText("");
		}
		else
		{
			int boxNumber = checkFocusedBox();
			if(boxNumber==1)
			{
				String temp = firstNumber.getText() + data;
				setFirstNumber(temp);
			}
			else if(boxNumber==2)
			{
				String temp = secondNumber.getText() + data;
				setSecondNumber(temp);
			}
			else
			{
				displayErrorMessage("Please Select Input Box");
			}
		}	
	}
	
	/**
	   * This method is action listner for virtual keyboard
	   * @param e(ActionEvent)
	   */
	ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
            	JButton button = (JButton) e.getSource();
    			String value = button.getText();
    			performChanges(value);
            }
        }
    };
    
    
    /**
	   * This method is used to launch new Dialogue Box
	   * This dialogue Box is History Table of calculations in current session
	   * @param e(ActionEvent)
	   */
    ActionListener listenerHistory = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            HistoryTable frame = new HistoryTable(historyList);
            frame.pack();
            frame.setVisible(true);
        }
    };

}
