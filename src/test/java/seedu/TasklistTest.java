package seedu;

import org.junit.jupiter.api.Test;
import seedu.duke.commons.DukeException;
import seedu.duke.model.TaskList;
import seedu.duke.commons.Parser;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TasklistTest {
    String fullCommand = "todo hello world";
    String commandWord = "todo";
    private TaskList task;

    @Test
    public void removeTaskTest() throws DukeException {
        task = new TaskList();
        task.addTask(Parser.createTodo(Parser.getTodoDescription(fullCommand,commandWord)));
        task.removeTask(1);

        assertTrue(task.isEmpty());
    }

    public void getSizeTest() throws DukeException{
        task = new TaskList();
        task.addTask(Parser.createTodo(Parser.getTodoDescription(fullCommand,commandWord)));

        assertEquals(1, task.getSize());
    }
}
