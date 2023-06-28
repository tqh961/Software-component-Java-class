import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Tan Qi Hao
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        int value = 0;
        int valueLeft = 0; //This is the value at .child(0)
        int valueRight = 0; //This is the value at .child(1)

        //This check the exp tag is number or not
        if (exp.label().equals("number")) {

            //If the label is number, the attributeValue will be stored in value
            value = Integer.parseInt(exp.attributeValue("value"));

        } else {

            //Or else use recursion to find valueLeft and valueRight
            valueLeft = evaluate(exp.child(0));
            valueRight = evaluate(exp.child(1));

            //Add both valueLeft and valueRight, if the label is plus
            if (exp.label().equals("plus")) {
                value = valueLeft + valueRight;

            } else if (exp.label().equals("minus")) {
                //minus both valueLeft and valueRight, if the label is minus
                value = valueLeft - valueRight;

            } else if (exp.label().equals("times")) {
                //times both valueLeft and valueRight, if the label is times
                value = valueLeft * valueRight;

            } else if (exp.label().equals("divide")) {

                //Check if denominator is zero
                if (valueRight == 0) {

                    Reporter.fatalErrorToConsole(
                            "Fatal Error: denominator is zero");

                }
                //Divide both valueLeft and valueRight, if the label is divide
                value = valueLeft / valueRight;

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
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}