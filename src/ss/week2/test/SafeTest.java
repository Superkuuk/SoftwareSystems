package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.Safe;

import static org.junit.Assert.*;

public class SafeTest {
    /** Testvariabele for a <tt>Rectangle</tt>-object. */
    private Safe safe;


    /**
     * Sets initial variables to a well-defined initial value.
     */
    @Before
    public void setUp() {
        // initialisation of a safe
    	safe = new Safe();
    }

    /**
     * Test if the initial condition complies to the specification.
     */
    @Test
    public void testInitial() {
    	assertFalse(safe.isOpen());
    	assertFalse(safe.isActive());
    }
    
    /**
     * Test if the safe is active after entering a correct pass.
     */
    @Test
    public void testActiveCorrect() {
    	safe.activate("safePass");
    	assertTrue(safe.isActive());
    }

    /**
     * Test if the safe is active after entering a false pass.
     */
    @Test
    public void testActiveFalse() {
    	safe.activate("blablalbalbal");
    	assertFalse(safe.isActive());
    }
    
    /**
     * Test if the safe is open after entering a correct pass and if it's activated.
     */
    @Test
    public void testOpenCorrectActivated() {
    	safe.activate("safePass");
    	safe.open("safePass");
    	assertTrue(safe.isOpen());
    }

    /**
     * Test if the safe is open after entering a correct pass and if it isn't activated.
     */
    @Test
    public void testOpenCorrectNotActivated() {
    	safe.activate("balalblblalab");
    	safe.open("safePass");
    	assertFalse(safe.isOpen());
    }
    
    /**
     * Test if the safe is open after entering a wrong pass and if it's activated.
     */
    @Test
    public void testOpenFalseActivated() {
    	safe.activate("safePass");
    	safe.open("blablalbalbal");
    	assertFalse(safe.isOpen());
    }
    
    /**
     * Test if the safe is open after entering a wrong pass and if it isn't activated.
     */
    @Test
    public void testOpenFalseNotActivated() {
    	safe.activate("blablabl");
    	safe.open("blablalbalbal");
    	assertFalse(safe.isOpen());
    }
    
    /**
     * Test if the safe is open after closing it and it's active.
     */
    @Test
    public void testCloseActive() {
    	safe.activate("safePass");
    	safe.close();
    	assertFalse(safe.isOpen());
    	assertTrue(safe.isActive());
    }
    
    /**
     * Test if the safe is open after closing it and it isn't active.
     */
    @Test
    public void testCloseNotActive() {
    	safe.activate("blalballbal");
    	safe.close();
    	assertFalse(safe.isOpen());
    	assertFalse(safe.isActive());
    }
    
    /**
     * Test if the safe is deactivated, whilst it was first open.
     */
    @Test
    public void testDeactivateOpen() {
    	safe.activate("safePass");
    	safe.open("safePass");
    	safe.deactivate();
    	assertFalse(safe.isOpen());
    	assertFalse(safe.isActive());
    }
    
    /**
     * Test if the safe is deactivated, whilst it was first not active nor open.
     */
    @Test
    public void testDeactivateClose() {
    	safe.activate("blalblallb");
    	safe.deactivate();
    	assertFalse(safe.isOpen());
    	assertFalse(safe.isActive());
    }
}
