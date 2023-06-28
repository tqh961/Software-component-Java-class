import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Tan Qi Hao
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    /**
     * Boundary case - testReduceToGCD(0,0).
     */
    @Test
    public void testReduceToGCD0and0() {
        final NaturalNumber n = new NaturalNumber2(0);
        final NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    /**
     * routine case - testReduceToGCD(30, 21).
     */
    @Test
    public void testReduceToGCD30and21() {
        final NaturalNumber n = new NaturalNumber2(30);
        final NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    /**
     * challenging case - isEven(0).
     */
    @Test
    public void testIsEven0() {
        final NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    /**
     * challenging case - isEven(1).
     */
    @Test
    public void testIsEven1() {
        final NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    /**
     * boundary case - isEven(2) - smallest even number.
     */
    @Test
    public void testIsEven2() {
        final NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("2", n.toString());
        assertTrue(result);
    }

    /**
     * routine case - isEven(2) - smallest even number.
     */
    @Test
    public void testIsEven546() {
        final NaturalNumber n = new NaturalNumber2(546);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("546", n.toString());
        assertTrue(result);
    }

    /*
     * Tests of powerMod
     */

    /**
     * boundary case - powerMod(0,0,2).
     */
    @Test
    public void testPowerMod0and0and2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    /**
     * routine case - powerMod(17,18,19).
     */
    @Test
    public void testPowerMod17and18and19() {
        final NaturalNumber n = new NaturalNumber2(17);
        final NaturalNumber p = new NaturalNumber2(18);
        final NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    /**
     * boundary case - isWitnessToCompositeness(2,4).
     */
    @Test
    public void testIsWitnessToCompositeness2and4() {
        final NaturalNumber w = new NaturalNumber2(2);
        final NaturalNumber n = new NaturalNumber2(4);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("2", w.toString());
        assertEquals("4", n.toString());
        assertTrue(result);

    }

    /**
     * routine case - isWitnessToCompositeness(3,14).
     */
    @Test
    public void testIsWitnessToCompositeness3and14() {
        final NaturalNumber w = new NaturalNumber2(3);
        final NaturalNumber n = new NaturalNumber2(14);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("3", w.toString());
        assertEquals("14", n.toString());
        assertTrue(result);

    }

    /**
     * routine case - isWitnessToCompositeness(3,7).
     */
    @Test
    public void testIsWitnessToCompositeness3and7() {
        final NaturalNumber w = new NaturalNumber2(3);
        final NaturalNumber n = new NaturalNumber2(7);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("3", w.toString());
        assertEquals("7", n.toString());
        assertTrue(!result);

    }

    /*
     * Tests of isPrime1
     */

    /**
     * boundary case - isPrime1(2).
     */
    @Test
    public void testIsPrime1with2() {
        final NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals("2", n.toString());
        assertTrue(result);

    }

    /**
     * challenging case - isPrime1(3).
     */
    @Test
    public void testIsPrime1with3() {
        final NaturalNumber n = new NaturalNumber2(3);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals("3", n.toString());
        assertTrue(result);

    }

    /**
     * routine case - isPrime1(27).
     */
    @Test
    public void testIsPrime1with27() {
        final NaturalNumber n = new NaturalNumber2(27);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals("27", n.toString());
        assertTrue(!result);

    }

    /**
     * routine case - isPrime1(421).
     */
    @Test
    public void testIsPrime1with421() {
        final NaturalNumber n = new NaturalNumber2(421);
        boolean result = CryptoUtilities.isPrime1(n);
        assertEquals("421", n.toString());
        assertTrue(result);

    }

    /*
     * Tests of isPrime2
     */

    /**
     * boundary case - isPrime2(2).
     */
    @Test
    public void testIsPrime2with2() {
        final NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("2", n.toString());
        assertTrue(result);

    }

    /**
     * challenging case - isPrime2(3).
     */
    @Test
    public void testIsPrime2with3() {
        final NaturalNumber n = new NaturalNumber2(3);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("3", n.toString());
        assertTrue(result);

    }

    /**
     * routine case - isPrime2(27).
     */
    @Test
    public void testIsPrime2with27() {
        final NaturalNumber n = new NaturalNumber2(27);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("27", n.toString());
        assertTrue(!result);

    }

    /**
     * routine case - isPrime2(421).
     */
    @Test
    public void testIsPrime2with421() {
        final NaturalNumber n = new NaturalNumber2(421);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("421", n.toString());
        assertTrue(result);

    }

    /*
     * Tests of generateNextLikelyPrime
     */

    /**
     * boundary case - GenerateNextLikelyPrime(4).
     */
    @Test
    public void testGenerateNextLikelyPrime4() {
        final NaturalNumber n = new NaturalNumber2(4);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("5", n.toString());
    }

    /**
     * routine case - GenerateNextLikelyPrime(200).
     */
    @Test
    public void testGenerateNextLikelyPrime200() {
        final NaturalNumber n = new NaturalNumber2(200);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("211", n.toString());
    }

    /**
     * routine case - GenerateNextLikelyPrime(104724).
     */
    @Test
    public void testGenerateNextLikelyPrime104724() {
        final NaturalNumber n = new NaturalNumber2(104724);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("104729", n.toString());
    }
}