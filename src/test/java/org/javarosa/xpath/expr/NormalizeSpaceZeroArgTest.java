package org.javarosa.xpath.expr;

import org.javarosa.core.test.Scenario;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalizeSpaceZeroArgTest {

    private Scenario scenario;
    private String valueXpath = "/data/entry[0]";

    @Before
    public void setUp() {
        scenario = Scenario.init("normalize-space-zero-arg-test.xml");
    }

    @Test
    public void failContainsSpaceConstraint() {
        assertFalse(scenario.evaluateConstraint(valueXpath, "abc"));
        assertFalse(scenario.evaluateConstraint(valueXpath, " abc\n"));
        assertFalse(scenario.evaluateConstraint(valueXpath, "A.B.C."));
    }

    @Test
    public void passContainsSpaceConstraint() {
        assertTrue(scenario.evaluateConstraint(valueXpath, "Abc Def"));
        assertTrue(scenario.evaluateConstraint(valueXpath, "\nDr.\nR\n"));
        assertTrue(scenario.evaluateConstraint(valueXpath, " A B C "));
        assertTrue(scenario.evaluateConstraint(valueXpath, "A       BC"));
    }
}
