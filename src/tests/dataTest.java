package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import code.data;
import junit.framework.Assert;
import junit.framework.TestCase;

/*
 * Limitations of JUnit
 * - Cannot generate test functions to GUI components
 * - GUI functions are private so there is no direct path
 * 
 * Potential ways of accessing Swing components:
 * - getX() methods for components
 * - Test code invokes events mimicking human operator
 * - Test code traverses component tree
 * 
 * 
 * Potentially, I want to move this file to separate files wrongButtonTest, buildSummaryPanelTest, etc. (?)
 */

// public class dataTest extends TestCase {
public class dataTest {
    data dataObject = new data();

    @Test
    public void testDataObjectExists() {
        // Check that an object can be made with the data class
        assertNotNull(dataObject);
    }

    @Test
    public void testGetCenturyReturnsArray() {
        // Clone in the getCentury should return a array
        assertEquals(String[].class, dataObject.getCentury().getClass());
    }

    // Note: This test may be deprecated based on how the application develops (ie. moving away from themes)
    // @Deprecated
    @Test
    public void testGetCenturyReturnsCenturies() {
        // getCentury should return a array of strings that have "century" in them
        for (String str: dataObject.getCentury()){
            boolean centuryIsFound = str.toLowerCase().contains("century");
            assertTrue(centuryIsFound);
        }
    }

    @Test 
    public void testQuestionArrayElementIsArray() {
        // test that the question array is a double nested array
        for (String[] ele: dataObject.getQuestionArray17()){
            assertEquals(String[].class, ele.getClass());
        }
    }

    @Test 
    public void testQuestionArrayElementHasStringElements() {
        // test that the questionArray for each question has elements that are strings
        for (String[] qlist: dataObject.getQuestionArray17()){
            for (int i = 0; i < qlist.length; ++i){
                assertEquals(String.class, qlist[i].getClass());
            }
        }
    }

    @Test 
    public void testGetCorrectAnswerInArray() {
        String answer = "Bananas";
        String[] answers = {"Lettuce", "Bananas", "Carrot", "Arugula"};
        // a little weird when you think about it
        assertTrue(dataObject.getCorrectAnswerInArray(answer, answers));
        assertFalse(dataObject.getCorrectAnswerInArray("noexist", answers));
    }

    @Test
    public void verifyCorrectAnswersInQuestionArray() {
        // test that the correctAnswer is in the questionsArray
        // TODO use TestCase @ to minimize the busy work below

        // 17th century
        int questionNumber = 0;
        for (String answer: dataObject.getCorrectAnswerArray17()){
            String[] questionArray = dataObject.getQuestionArray17()[questionNumber];
            assertTrue(dataObject.getCorrectAnswerInArray(answer, questionArray));
            questionNumber += 1;
        }

        // 18th century
        questionNumber = 0;
        for (String answer: dataObject.getCorrectAnswerArray18()){
            String[] questionArray = dataObject.getQuestionArray18()[questionNumber];
            assertTrue(dataObject.getCorrectAnswerInArray(answer, questionArray));
            questionNumber += 1;
        }

        // 19th century
        questionNumber = 0;
        for (String answer: dataObject.getCorrectAnswerArray19()){
            String[] questionArray = dataObject.getQuestionArray19()[questionNumber];
            assertTrue(dataObject.getCorrectAnswerInArray(answer, questionArray));
            questionNumber += 1;
        }

        // 20th century
        questionNumber = 0;
        for (String answer: dataObject.getCorrectAnswerArray20()){
            String[] questionArray = dataObject.getQuestionArray20()[questionNumber];
            assertTrue(dataObject.getCorrectAnswerInArray(answer, questionArray));
            questionNumber += 1;
        }
    }

}