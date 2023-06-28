import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code NaturalNumber}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {

        NaturalNumber value = new NaturalNumber1L(0);
        NaturalNumber valueLeft = new NaturalNumber1L(0); //Value at child(0)
        NaturalNumber valueRight = new NaturalNumber1L(0); //Value at child(1)

        //This constant is use to find denominator, when it is 0
        final NaturalNumber zero = new NaturalNumber1L(0);

        //Check the tag is number or not
        if (exp.label().equals("number")) {

            //Store the attribute value in naturalNumber type
            NaturalNumber attributeValue = new NaturalNumber1L(
                    exp.attributeValue("value"));

            //Copy the attributeValue to value
            value.copyFrom(attributeValue);

        } else {

            //Use recursion to find the child(0) and child(1) of each operator
            valueLeft.copyFrom(evaluate(exp.child(0)));
            valueRight.copyFrom(evaluate(exp.child(1)));

            if (exp.label().equals("plus")) {

                //This add the valueLeft and valueRight
                value.add(valueLeft);
                value.add(valueRight);

            } else if (exp.label().equals("minus")) {

                //Check that the left value smaller than right value
                if (valueLeft.compareTo(valueRight) < 0) {

                    Reporter.fatalErrorToConsole(
                            "Fatal Error: Subtracted value is negative");

                }

                //This subtract the valueLeft and valueRight
                valueLeft.subtract(valueRight);
                value.copyFrom(valueLeft);

            } else if (exp.label().equals("times")) {

                //This multiply the valueLeft and valueRight
                valueLeft.multiply(valueRight);
                value.copyFrom(valueLeft);

            } else if (exp.label().equals("divide")) {

                //Check that the denominator not equal to zero
                //Use constant variable zero as it is comparing natural number
                if (valueRight.equals(zero)) {

                    Reporter.fatalErrorToConsole(
                            "Fatal Error: denominator is zero");

                }

                //This divide the valueLeft with valueRight
                valueLeft.divide(valueRight);
                value.copyFrom(valueLeft);

            }

        }

        return value;

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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);

            //Find the expression answer in naturalNumber type
            NaturalNumber evaluateExp = new NaturalNumber1L(
                    evaluate(exp.child(0)));
            out.println(evaluateExp);
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}