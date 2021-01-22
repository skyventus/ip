package duke;

import org.junit.jupiter.api.Test;


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
