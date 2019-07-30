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
		assertEquals(Model.functionalCal(2,2),4);

	}
}


