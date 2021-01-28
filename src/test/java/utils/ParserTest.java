package utils;
import seedu.duke.commons.DukeException;
import seedu.duke.commons.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    String fullCommand = "todo hello world";
    String commandWord = "todo";

    @Test
    public void getCommandWordTest() {
      String actual = Parser.getCommandWord(fullCommand);
      String expected = "todo";

      assertEquals(expected, actual);
    }

    @Test
    public void getTodoDescriptionTest() throws DukeException {
        String actual = Parser.getTodoDescription(fullCommand,
                commandWord);
        String expected = "hello world";

        assertEquals(expected,actual);
    }

    @Test
    public void findMatchKeywordsTest(){
       assertTrue(Parser.findMatchKeywords("Hello World", "hello"));
    }


}