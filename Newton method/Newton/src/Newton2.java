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
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01% and
     * check if x is zero or not.
     *
     * @param x
     *            positive number to compute square root of
     * @return 0 when x equal 0.
     * @return r estimate of square root
     */
    private static double sqrt(double x) {
        final double EPSILON = 0.0001; //The relative error constant
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

        boolean prompt = true; //Prompt for the validity of y
        double num; //Number that need to be square root
        String y_Orn; //User input for y and others.

        //This while loop repeats inputing x
        while (prompt) {
            out.println("The square root number: ");
            num = in.nextDouble();
            out.println("The square root is " + sqrt(num));
            out.println(
                    "Do you want to input another number of square root? y/n: ");
            y_Orn = in.nextLine();

            //Check the validity of y_Orn
            if (y_Orn.equals("y")) {
                prompt = true;
            } else {
                prompt = false;
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
