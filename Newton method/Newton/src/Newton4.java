import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program estimates the square root of x using the Newton method.
 *
 * @author Tan Qi Hao
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error EPSILON.
     *
     * @param x
     *            positive number to compute square root of
     * @param EPSILON
     *            User input relative error to compute square root Use final for
     *            EPSILON, so that the user input value will be constant
     * @return 0 x = 0, when x equal 0.
     * @return r estimate of square root
     */
    private static double sqrt(double x, final double EPSILON) {
        double r = x; //r is the initial guess of square root x.

        //Check whether x is equal 0
        if (x == 0) {

            return 0;

        }
        while (Math.abs(r * r - x) / x > EPSILON * EPSILON) {
            r = (r + x / r) / 2.0;
        }

        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        final double EPSILON; //User input Epsilon constant
        double num; //num, the number of square root
        boolean prompt = true; //Prompt for the validity of y

        out.println("The square root number: ");
        num = in.nextDouble();
        out.println("Enter the EPSILON: ");
        EPSILON = in.nextDouble();

        //This while loop let user repeat input the value of x
        while (prompt) {
            out.println("The square root is " + sqrt(num, EPSILON));
            out.println("New value for x: ");
            num = in.nextDouble();

            //Check the validity of num, when num is bigger and equal than zero
            if (num >= 0) {
                prompt = true;
            } else {
                prompt = false; //The while loop exterminated, when num < 0
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
