package seedu.duke.model;

import seedu.duke.commons.DukeException;
import seedu.duke.commons.Parser;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskList is a class that hold a list of tasks and its related function.
 *
 * @author Olivier Cheah
 */
public class TaskList {
  private List<Task> tasks;
  Ui ui = new Ui();
  final String newLine = "\n";

  public TaskList() {
    this.tasks = new ArrayList<>();
  }

  public void addTask(Task task) {
    tasks.add(task);
    Ui.printGotIt();
    ui.showAddedTask(Parser.getTaskType(task), task.toString());
    ui.showTotalNumberTaskAdded(tasks.size());
  }

  public String getAddTask(Task task) {
    String message = "";
    tasks.add(task);
    message = message + Ui.getPrintGotIt() + newLine;
    message = message + ui.getShowAddedTask(Parser.getTaskType(task), task.toString()) + newLine;
    message = message + ui.getShowTotalNumberTaskAdded(tasks.size()) + newLine;

    return message;
  }

  public void addTaskWithoutMessage(Task task) {
    tasks.add(task);
  }

  public void printTasks() {
    //to keep track of item starting from 1
    int itemRank = 1;

    if (tasks.isEmpty())
      Ui.showToUser("No tasks has been added to the list yet.");

    for (Task task : tasks) {
      ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
      itemRank++;
    }
  }

  public String getPrintTasks() {
    //to keep track of item starting from 1
    int itemRank = 1;
    String message = "";
    if (tasks.isEmpty())
      return Ui.getShowToUser("No tasks has been added to the list yet.");

    for (Task task : tasks) {
      message = message + ui.getShowTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
      message = message + "\n";
      itemRank++;
    }
    return message;
  }

  public String getSetTaskDone(int idx) throws DukeException {

    try {
      Ui.printDone();
      if(idx - 1 < 0){
        System.out.println(idx);
        return ("[ERROR] No task found for the number you want to set done");
      }
      tasks.get(idx - 1).setDone(true);
      return ui.getShowDoneTask(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString());
    } catch (IndexOutOfBoundsException e) {
      return ("[ERROR] No task found for the number you want to set done");
    }
  }

  public void setTaskDone(int idx) throws DukeException {
    try {
      Ui.printDone();
      tasks.get(idx - 1).setDone(true);
      ui.showDoneTask(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString());
    } catch (IndexOutOfBoundsException e) {
      throw new DukeException("[ERROR] No task found for the number you want to set done");
    }
  }

  public boolean isTaskCompleted(int idx) {
    return tasks.get(idx - 1).isDone();
  }

  public void setTaskDoneSliently(int idx) throws DukeException {
    try {
      Ui.printDone();
      tasks.get(idx - 1).setDone(true);
    } catch (IndexOutOfBoundsException e) {
      throw new DukeException("[ERROR] No task found for the number you want to set done");
    }
  }

  public void removeTask(int idx) throws DukeException {
    try {
      ui.showDeleteMessage();
      ui.showDeleteTaskDetails(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString(), tasks.get(idx - 1).isDone());
      tasks.remove(idx - 1);
      ui.showTotalNumberTaskAdded(tasks.size());
    } catch (IndexOutOfBoundsException e) {
      throw new DukeException("[ERROR] No task found for the number you want to set done");
    }
  }

  public String getRemoveTask(int idx) throws DukeException {
    String message = "";
    String newLine = "\n";
    try {
      message = message + ui.getShowDeleteMessage() + newLine;
      message = message + ui.getShowDeleteTaskDetails(Parser.getTaskType(tasks.get(idx - 1)), tasks.get(idx - 1).toString(), tasks.get(idx - 1).isDone()) +
                newLine;
      tasks.remove(idx - 1);
      message = message + ui.getShowTotalNumberTaskAdded(tasks.size()) + newLine;
    } catch (IndexOutOfBoundsException e) {
      message = ("[ERROR] No task found for the number you want to set done");
    }

    return message;
  }

  public boolean isEmpty() {
    boolean isEmpty = tasks.isEmpty();
    return isEmpty;
  }

  public int getSize() {
    return tasks.size();
  }

  public String saveTask(int idx) {
    String value = tasks.get(idx).saveTask();
    //System.out.println(value);
    return value;
  }

  public void findTask(String keyword) {
    int itemRank = 1;

    if (tasks.isEmpty())
      Ui.showToUser("No tasks has been added to the list yet.");

    for (Task task : tasks) {
      if (Parser.findMatchKeywords(task.getDescription().trim(), keyword)) {
        ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
        itemRank++;
      }
    }
    if (itemRank == 1) {
      Ui.showToUser("No item matched in the list.");
    }
  }

  public String getFindTask(String keyword) {
    int itemRank = 1;
    String message = "";
    String newLine = "\n";
    if (tasks.isEmpty())
      return Ui.getShowToUser("No tasks has been added to the list yet.");

    for (Task task : tasks) {
      if (Parser.findMatchKeywords(task.getDescription().trim(), keyword)) {
        message = message + ui.getShowTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone()) + newLine;
        itemRank++;
      }
    }
    if (itemRank == 1) {
      return Ui.getShowToUser("No item matched in the list.");
    }
    return message;
  }
  public String getTask(int index) {
    String item = tasks.get(index).toString();
    System.out.println(item);
    return item;
  }
}
