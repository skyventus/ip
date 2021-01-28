package seedu;


import org.junit.jupiter.api.Test;
import seedu.duke.commons.DukeException;
import seedu.duke.model.TaskList;
import seedu.duke.commons.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    String fullCommand = "todo hello world";
    String commandWord = "todo";
    private TaskList task;

    @Test
    public void isDoneTest() throws DukeException {
        task = new TaskList();
        task.addTask(Parser.createTodo(Parser.getTodoDescription(fullCommand,commandWord)));


        assertFalse(task.isTaskCompleted(1));
        task.setTaskDone(1);
        assertTrue(task.isTaskCompleted(1));
    }
}
