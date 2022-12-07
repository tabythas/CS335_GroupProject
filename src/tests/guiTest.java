package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.awt.Color;
import org.junit.Assert.*;
import javax.swing.JButton;
import org.junit.*;
import code.data;
import code.gui; 

public class guiTest {
    gui guiObject = new gui();

    @Test 
    public void testDisableWrongChoice(){
        // test that when a button is disabled, it is disabled
        JButton testButton = new JButton();
        guiObject.disableWrongChoice(testButton);
        assertFalse(testButton.isEnabled());
    }

    @Ignore
    @Test
    public void buildQuestionPanel() {
        // TODO: gui.java needs its own tests
        // Test method buildQuestionPanel
        // - wrongButton
        // - buildSummaryPanel
        // - buildResultsPage
        fail();
    }

}