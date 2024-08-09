package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        App app = new App();
        app.setup();
        System.out.println("getTemplateValue(): \n" + app.getTemplateValue() + "\n\n");
        System.out.println("getTemplateValueFast(): \n" + app.getTemplateValueFast()+ "\n\n");
        System.out.println("resultString: \n" + app.getResultString());

        assertEquals(app.getResultString(), app.getTemplateValue());
        assertEquals(app.getResultString(), app.getTemplateValueFast());
    }
}
