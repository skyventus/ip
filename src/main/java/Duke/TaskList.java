package Duke;

import utils.Parser;
import utils.Ui;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    Ui ui = new Ui();

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        ui.printGotIt();
        ui.showAddedTask(Parser.getTaskType(task), task.getDescription());
        ui.showTotalNumberTaskAdded(tasks.size());
    }

    public void printTasks() {
        //to keep track of item starting from 1
        int itemRank = 1;

        if (tasks.isEmpty())
            ui.showToUser("No tasks has been added to the list yet.");

        for (Task task : tasks) {
            ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
            itemRank++;
        }
    }

    public void setTaskDone(int idx) throws DukeException {
        try {
            ui.printDone();
            tasks.get(idx - 1).setDone(true);
            ui.showDoneTask(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("[ERROR] No task found for the number you want to set done");
        }
    }
}
