import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
* Test Class for Model
* @author  Karan Behl
* @version 1.0
* @since   2019-07-29 
*/
class TestFunction {
	
	Model model;
	View view;
	Controller controller;
	
	@Before
	public void setUp()
	{
		 model = new Model();
		 view = new View();
		 controller = new Controller(view,model);
	}
	
	@Test
    public void powerTest() {
        // assert statements
        assertEquals(Model.power(1,1), 1);
        assertEquals(Model.power(2, 3), 8);
       assertEquals(Model.power(5, 8), 390625);
    }
	
	@Test
	public void functionCal()
	{
		assertEquals(Model.functionalCal(1, -1), 1);
		assertEquals(Model.functionalCal(25, -5), 0.0000001024);

	}
}


