import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;
import components.set.Set2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Tan Qi Hao
 *
 */
public class StringReassemblyTest {

    /**
     * test case - testCombination()
     */
    /**
     * Boundary case - testCombination0() - when overlap is 1.
     */
    @Test
    public void testCombination1() {
        String str1 = "1234";
        String str2 = "456789";
        final int overlap = 1;
        final int one = 1;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals("1234", str1);
        assertEquals("456789", str2);
        assertEquals(one, overlap);

        assertEquals("123456789", result);
    }

    /**
     * Boundary case - testCombination0() - when both string overlap.
     */
    @Test
    public void testCombinationAll() {
        String str1 = "1234";
        String str2 = "1234";
        final int overlap = 4;
        final int four = 4;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals("1234", str1);
        assertEquals("1234", str2);
        assertEquals(four, overlap);

        assertEquals("1234", result);
    }

    /**
     * Routine case - testCombination3().
     */
    @Test
    public void testCombination3() {
        String str1 = "123456";
        String str2 = "456789";
        final int overlap = 3;
        final int three = 3;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals("123456", str1);
        assertEquals("456789", str2);
        assertEquals(three, overlap);

        assertEquals("123456789", result);
    }

    /**
     * Routine case - testCombination4().
     */
    @Test
    public void testCombination4() {
        String str1 = "abcdef";
        String str2 = "cdefgh";
        final int overlap = 4;
        final int four = 4;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals("abcdef", str1);
        assertEquals("cdefgh", str2);
        assertEquals(four, overlap);

        assertEquals("abcdefgh", result);
    }

    /**
     * boundary case - testlinesFromInputggg().
     */
    @Test
    public void testlinesFromInputggg() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L("linesFromInputgggTest.txt");
        out.println("g");
        out.println("gg");

        //Read the file after the method
        SimpleReader in = new SimpleReader1L("linesFromInputgggTest.txt");

        Set<String> set = StringReassembly.linesFromInput(in);

        final int one = 1;
        String gg = "gg";

        //Test the size of the set
        assertEquals(one, set.size());

        //Test the contains of the set
        assertTrue(set.contains(gg));

        out.close();
        in.close();

    }

    /**
     * routine case - testlinesFromInputaaaaAndggg().
     */
    @Test
    public void testlinesFromInputaaaaAndggg() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L(
                "linesFromInputaaaaAndgggTest.txt");
        out.println("g");
        out.println("aa");
        out.println("ggg");
        out.println("aaaa");

        //Read the file after the method
        SimpleReader in = new SimpleReader1L(
                "linesFromInputaaaaAndgggTest.txt");

        Set<String> set = StringReassembly.linesFromInput(in);

        final int two = 2;
        String ggg = "ggg";
        String aaaa = "aaaa";

        //Test the size of the set
        assertEquals(two, set.size());

        //Test the contains of the set
        assertTrue(set.contains(ggg));
        assertTrue(set.contains(aaaa));

        out.close();
        in.close();

    }

    /**
     * routine case - testlinesFromInputghi().
     */
    @Test
    public void testlinesFromInputghi() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L("linesFromInputghiTest.txt");
        out.println("g");
        out.println("h");
        out.print("i");

        //Read the file after the method
        SimpleReader in = new SimpleReader1L("linesFromInputghiTest.txt");

        Set<String> set = StringReassembly.linesFromInput(in);

        final int three = 3;
        String g = "g";
        String h = "h";
        String i = "i";

        //Test the size of the set
        assertEquals(three, set.size());

        //Test the contains of the set
        assertTrue(set.contains(g));
        assertTrue(set.contains(h));
        assertTrue(set.contains(i));

        out.close();
        in.close();

    }

    /**
     * challenging case - testlinesFromInputabcAndbcde().
     */
    @Test
    public void testlinesFromInputabcAndbcde() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L(
                "linesFromInputabcAndbcdeTest.txt");
        out.println("abc");
        out.println("bcde");

        //Read the file after the method
        SimpleReader in = new SimpleReader1L(
                "linesFromInputabcAndbcdeTest.txt");

        Set<String> set = StringReassembly.linesFromInput(in);

        final int two = 2;
        String abc = "abc";
        String bcde = "bcde";

        //Test the size of the set
        assertEquals(two, set.size());

        //Test the contains of the set
        assertTrue(set.contains(abc));
        assertTrue(set.contains(bcde));

        out.close();
        in.close();

    }

    /**
     * test case - testaddToSetAvoidingSubstrings().
     */
    /**
     * Routine case - testaddToSetAvoidingSubstringswithdef().
     */
    @Test
    public void testaddToSetAvoidingSubstringswithdef() {

        Set<String> strSet = new Set2<>();
        Set<String> strSet2 = new Set2<>();

        //Set up the Actual set
        strSet.add("abc");
        strSet.add("def");
        strSet.add("ghi");

        //Set up the expected set
        strSet2.add("abc");
        strSet2.add("ghi");

        String str = "def";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

    /**
     * Routine case - testaddToSetAvoidingSubstringswithef().
     */
    @Test
    public void testaddToSetAvoidingSubstringswithef() {

        Set<String> strSet = new Set2<>();
        Set<String> strSet2 = new Set2<>();

        //Set up the actual set
        strSet.add("abc");
        strSet.add("def");
        strSet.add("ghi");

        //Set up the expected set
        strSet2.add("abc");
        strSet2.add("def");
        strSet2.add("ghi");

        String str = "ef";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

    /**
     * Routine case - testaddToSetAvoidingSubstringswithcccccdef().
     */
    @Test
    public void testaddToSetAvoidingSubstringswithcccccdef() {

        Set<String> strSet = new Set2<>();
        Set<String> strSet2 = new Set2<>();

        //Set up the actual set
        strSet.add("abc");
        strSet.add("def");
        strSet.add("ghi");

        //Set up the expected set
        strSet2.add("abc");
        strSet2.add("cccccdef");
        strSet2.add("ghi");

        String str = "cccccdef";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

    /**
     * boundary case - testaddToSetAvoidingSubstringswithEmptySetandStr().
     */
    @Test
    public void testaddToSetAvoidingSubstringswithEmptySetandStr() {

        //Set up the empty set
        Set<String> strSet = new Set2<>();

        //Initialize the string to be empty
        String str = "";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);

        //Test for the empty set to be empty
        assertEquals(str, strSet.removeAny());
    }

    /**
     * test case - testprintWithLineSeparatorswithabcde().
     */
    /**
     * routine case - testprintWithLineSeparatorswithabcde().
     */
    @Test
    public void testprintWithLineSeparatorswithabcde() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L("abcdeTest.txt");
        String text = "a b ~ c ~ d e";

        StringReassembly.printWithLineSeparators(text, out);
        //Read the file after the method
        SimpleReader in = new SimpleReader1L("abcdeTest.txt");

        //Set the expected file
        SimpleWriter outExpected = new SimpleWriter1L("ExpectedabcdeTest.txt");
        outExpected.println("a b ");
        outExpected.println(" c ");
        outExpected.println(" d e");

        SimpleReader inExpected = new SimpleReader1L("ExpectedabcdeTest.txt");

        //Loop through each of the character in the file
        while (!inExpected.atEOS() && !in.atEOS()) {

            assertEquals(inExpected.nextLine(), in.nextLine());

        }

        out.close();
        in.close();
        outExpected.close();
        inExpected.close();

    }

    /**
     * routine case - testprintWithLineSeparatorswithAdashdashdashB().
     */
    @Test
    public void testprintWithLineSeparatorswithAdashdashdashB() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L("AdashdashdashBTest.txt");
        String text = "A~~~B";

        StringReassembly.printWithLineSeparators(text, out);
        //Read the file after the method
        SimpleReader in = new SimpleReader1L("AdashdashdashBTest.txt");

        //Set the expected file
        SimpleWriter outExpected = new SimpleWriter1L(
                "ExpectedAdashdashdashBTest.txt");
        outExpected.println("A");
        outExpected.println();
        outExpected.println();
        outExpected.print("B");

        SimpleReader inExpected = new SimpleReader1L(
                "ExpectedAdashdashdashBTest.txt");

        //Loop through each of the character in the file
        while (!inExpected.atEOS() && !in.atEOS()) {

            assertEquals(inExpected.nextLine(), in.nextLine());

        }

        out.close();
        in.close();
        outExpected.close();
        inExpected.close();

    }

    /**
     * boundary case - testprintWithLineSeparatorswithonlyabcde().
     */
    @Test
    public void testprintWithLineSeparatorswithonlyabcde() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L("onlyabcdeTest.txt");
        String text = "a b c d e";

        StringReassembly.printWithLineSeparators(text, out);
        //Read the file after the method
        SimpleReader in = new SimpleReader1L("onlyabcdeTest.txt");

        //Set the expected file
        SimpleWriter outExpected = new SimpleWriter1L(
                "ExpectedOnlyabcdeTest.txt");
        outExpected.println("a b c d e");

        SimpleReader inExpected = new SimpleReader1L(
                "ExpectedOnlyabcdeTest.txt");

        //Loop through each of the character in the file
        while (!inExpected.atEOS() && !in.atEOS()) {

            assertEquals(inExpected.nextLine(), in.nextLine());

        }

        out.close();
        in.close();
        outExpected.close();
        inExpected.close();

    }

    /**
     * boundary case - testprintWithLineSeparatorswithonlydash().
     */
    @Test
    public void testprintWithLineSeparatorswithonlydash() {
        //Output the file
        SimpleWriter out = new SimpleWriter1L("onlydashTest.txt");
        String text = "~~~~";

        StringReassembly.printWithLineSeparators(text, out);
        //Read the file after the method
        SimpleReader in = new SimpleReader1L("onlydashTest.txt");

        //Set the expected file
        SimpleWriter outExpected = new SimpleWriter1L(
                "ExpectedOnlydashTest.txt");
        outExpected.println();
        outExpected.println();
        outExpected.println();
        outExpected.println();

        SimpleReader inExpected = new SimpleReader1L(
                "ExpectedOnlydashTest.txt");

        //Loop through each of the character in the file
        while (!inExpected.atEOS() && !in.atEOS()) {

            assertEquals(inExpected.nextLine(), in.nextLine());

        }

        out.close();
        in.close();
        outExpected.close();
        inExpected.close();

    }
}
