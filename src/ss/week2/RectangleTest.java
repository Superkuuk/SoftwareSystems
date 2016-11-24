package ss.week2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testprogram for Rectangle.
 * Lab Exercise SoftwareSystems
 * @author Rutger Frieswijk
 * @version 1.0
 */
public class RectangleTest {
    /** Testvariabele for a <tt>Rectangle</tt>-object. */
    private Rectangle rectangle;


    /**
     * Sets initial variables to a well-defined initial value.
     */
    @Before
    public void setUp() {
        // initialisation of a good rectangle
    	rectangle = new Rectangle(4, 5);
    }

    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testInitialcondition() {
        assertEquals(4, rectangle.length());
        assertEquals(5, rectangle.width());
    }
    
    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testArea() {
        assertEquals(20, rectangle.area());
    }
    
    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testPerimeter() {
        assertEquals(18, rectangle.perimeter());
    }
}
