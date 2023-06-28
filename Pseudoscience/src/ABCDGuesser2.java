import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This program approximate u within a fraction of 1% by using the de Jager
 * formula, w^a * x^b * y^c * z^d, where w,x,y,z are four personal number.
 *
 * @author Tan Qi Hao
 */
public final class ABCDGuesser2 {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private ABCDGuesser2() {
        // no code needed here
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

        String num;
        num = in.nextLine();

        while (!FormatChecker.canParseDouble(num)
                || Double.parseDouble(num) <= 0.0) {

            out.println("Type positive real Number: ");
            num = in.nextLine();

        }

        return Double.parseDouble(num);

    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {

        String num;
        num = in.nextLine();

        while (!FormatChecker.canParseDouble(num)
                || Double.parseDouble(num) == 1.0
                || Double.parseDouble(num) <= 0.0) {

            out.println("Type positive real value not equal to 1: ");
            num = in.nextLine();

        }

        return Double.parseDouble(num);

    }

    /**
     * Calculate the exponents of a, b, c, d using for loop. Calculate the
     * estimated value of the de Jager Value. Return the estimated value.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @param u
     *            The approximate value u
     * @param w
     *            The first personal number
     * @param x
     *            The second personal number
     * @param y
     *            The third personal number
     * @param z
     *            The fourth personal number
     * @return The estimated value of de Jager formula
     */
    private static double estimatedValue(SimpleReader in, SimpleWriter out,
            double u, double w, double x, double y, double z) {

        final double relativeError = 0.01;
        final double[] valuePow = { -5, -4, -3, -2, -1, -1 / 2.0, -1 / 3.0,
                -1 / 4.0, 0, 1 / 4.0, 1 / 3.0, 1 / 2.0, 1, 2, 3, 4, 5 };

        double wa, xb, yc, zd;
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        double finalEstimate = 0;

        for (int i = 0; i < valuePow.length; i++) {
            wa = Math.pow(w, valuePow[i]);

            for (int j = 0; j < valuePow.length; j++) {
                xb = Math.pow(x, valuePow[j]);

                for (int k = 0; k < valuePow.length; k++) {
                    yc = Math.pow(y, valuePow[k]);

                    for (int l = 0; l < valuePow.length; l++) {
                        zd = Math.pow(z, valuePow[l]);

                        if (Math.abs(wa * xb * yc * zd - u)
                                / u <= relativeError) {
                            double estimatedValue = wa * xb * yc * zd;
                            if (Math.abs(estimatedValue - u) < Math
                                    .abs(finalEstimate - u)) {
                                finalEstimate = estimatedValue;
                                a = valuePow[i];
                                b = valuePow[j];
                                c = valuePow[k];
                                d = valuePow[l];
                            }

                        }

                    }

                }

            }

        }
        out.println("The exponents a,b,c,d are as followed:");
        out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);

        return finalEstimate;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        final double percentageConversionValue = 100.0;

        out.println("Type approximation, u: ");
        double u = getPositiveDouble(in, out);

        out.println("Type w: ");
        double w = getPositiveDoubleNotOne(in, out);
        out.println("Type x: ");
        double x = getPositiveDoubleNotOne(in, out);
        out.println("Type y: ");
        double y = getPositiveDoubleNotOne(in, out);
        out.println("Type z: ");
        double z = getPositiveDoubleNotOne(in, out);

        double finalEstimate = estimatedValue(in, out, u, w, x, y, z);

        out.println("The value of the fromula w^a * x^b * y^c * z^d: "
                + finalEstimate);
        double guessRelativeErrorPercentage = (Math.abs(finalEstimate - u) / u)
                * percentageConversionValue;
        out.print("The relative error of the approximation: ");
        out.print(guessRelativeErrorPercentage, 2, false);
        out.print("%");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
