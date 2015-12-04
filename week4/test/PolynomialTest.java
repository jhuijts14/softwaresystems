package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Constant;
import ss.week4.math.Function;
import ss.week4.math.Polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private static final double DELTA = 1e-15;
    private static final double[] CONSTANT_ARRAY = new double[] {0, 1, 2, 3};
    private Polynomial polynomial;

    @Before
    public void setUp() {
        polynomial = new Polynomial(CONSTANT_ARRAY);
    }

    @Test
    public void testApply() {
        assertEquals(0, polynomial.apply(0), DELTA);
        assertEquals(-2, polynomial.apply(-1), DELTA);
        assertEquals(6, polynomial.apply(1), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(polynomial.derivative() instanceof Function);
        assertEquals(1.00, polynomial.derivative().apply(0), DELTA);
    }
    
    @Test
    public void testIntegrand() {
    	assertTrue(polynomial.integrand() instanceof Function);
        assertEquals(0.0, polynomial.integrand().apply(0), DELTA);
    }
}
