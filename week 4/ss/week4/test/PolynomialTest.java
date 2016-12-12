package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private static final double DELTA = 1e-15;
    private Polynomial polynomial;

    @Before
    public void setUp() {
    	double[] arr = {3, 5, 9};
        polynomial = new Polynomial(arr);
        
    }

    @Test
    public void testApply() {
        // {a0 = 3, a1 = 5, a2 = 9}
        double answer = 9 * Math.pow(1.2, 2) + 5 * 1.2 + 3 * 1;
    	assertEquals(answer, polynomial.apply(1.2), DELTA);

    }

    @Test
    public void testDerivative() {
        assertTrue(polynomial.derivative() instanceof Sum);
        // {a0 = 3, a1 = 5, a2 = 9}
        double answer = 9 * 2 * 1.2 + 5;
        assertEquals(answer, polynomial.derivative().apply(1.2), DELTA);
    }
    
    @Test
    public void testIntegrand() {
        assertTrue(polynomial.integrand() instanceof Sum);
        // {a0 = 3, a1 = 5, a2 = 9}
        assertEquals(0, polynomial.integrand().apply(0), DELTA); 
        double answer = 3 * 2 + 5 * (Math.pow(2, 2) / 2) + 9 * (Math.pow(2, 3) / 3);
        assertEquals(answer, polynomial.integrand().apply(2), DELTA);   	
    }
    
}
