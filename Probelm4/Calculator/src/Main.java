/**
* This is Main class use to run app
*
* @author  Karan Behl
* @version 1.0
* @since   2019-07-29 
*/
public class Main {
	/**
	   * This is the main method which runs app by calling model View and Controller.
	   * @param args Unused.
	   * @return Nothing.
	   */
    public static void main(String[] args) {
    	
    	View view = new View();
        
    	Model model = new Model();
        
        Controller controller = new Controller(view,model);
        
        view.setVisible(true);
        
    }
}
