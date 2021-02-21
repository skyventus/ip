package seedu.duke.model;

import seedu.duke.commons.DukeException;
import seedu.duke.commons.Parser;
import seedu.duke.ui.Ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TaskList is a class that hold a list of tasks and its related function.
 *
 * @author Olivier Cheah
 */
public class TaskList {
  private List<Task> listOfTasks;
  Ui ui = new Ui();
  final String newLine = "\n";

  public TaskList() {
    this.listOfTasks = new ArrayList<>();
  }

  public void addTask(Task task) {
    listOfTasks.add(task);
    Ui.printGotIt();
    ui.showAddedTask(Parser.getTaskType(task), task.toString());
    ui.showTotalNumberTaskAdded(listOfTasks.size());
  }

  public String getAddTask(Task task) {
    String message = "";
    listOfTasks.add(task);
    message = message + Ui.getPrintGotIt() + newLine;
    message = message + ui.getShowAddedTask(Parser.getTaskType(task), task.toString()) + newLine;
    message = message + ui.getShowTotalNumberTaskAdded(listOfTasks.size()) + newLine;

    return message;
  }

  public void addTaskWithoutMessage(Task task) {
    listOfTasks.add(task);
  }

  public void printTasks() {
    //to keep track of item starting from 1
    int itemRank = 1;

    if (listOfTasks.isEmpty())
      Ui.showToUser("No tasks has been added to the list yet.");

    for (Task task : listOfTasks) {
      ui.showTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
      itemRank++;
    }
  }

  public void sortDeadlineTasks() {
    int itemRank = 1;
    List<Task> sortedTask = new ArrayList<>();

    sortedTask.addAll(listOfTasks);

    if (listOfTasks.isEmpty())
      Ui.showToUser("No tasks has been added to the list yet.");

    Collections.sort(sortedTask, new Comparator<Task>() {
      DateFormat f = new SimpleDateFormat("dd/mm/yyyy");

      @Override
      public int compare(Task task, Task t1) {
        try {
          if (task.getDeadline() == null && task.getDeadline() == null)
            return -1;
          if (task.getDeadline() == null)
            return -1;
          if (t1.getDeadline() == null)
            return -1;

          return f.parse(task.getDeadline()).compareTo(f.parse(t1.getDeadline()));
        } catch (ParseException e) {
          throw new IllegalArgumentException(e);
        }
      }
    });
  }

    public String  getSortedDeadlineTasks() {
      int itemRank = 1;
      String message = "";
      List<Task> sortedTask = new ArrayList<>();

      sortedTask.addAll(listOfTasks);

      if (listOfTasks.isEmpty())
        return ("No tasks has been added to the list yet.");

        Collections.sort(sortedTask, new Comparator<Task>() {
          DateFormat f = new SimpleDateFormat("dd/mm/yyyy");

          @Override
          public int compare(Task task, Task t1) {
            try {
              if (task.getDeadline() == null && task.getDeadline() == null)
                return -1;
              if (task.getDeadline() == null)
                return -1;
              if (t1.getDeadline() == null)
                return -1;

              return f.parse(task.getDeadline()).compareTo(f.parse(t1.getDeadline()));
            } catch (ParseException e) {
              throw new IllegalArgumentException(e);
            }
          }
        });
      for (Task task : sortedTask) {
        message = message + ui.getShowTaskWithOrder(Parser.getTaskType(task), task.toString(), itemRank, task.isDone());
        message = message + "\n";
        itemRank++;
      }

      return message;
    }

  public String getPrintTasks() {
    //to keep track of item starting from 1
    int itemRank = 1;
    String message = "";
    if (listOfTasks.isEmpty())
      return Ui.getShowToUser("No tasks has been added to the list yet.");

    for (Task task : listOfTasks) {
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
      listOfTasks.get(idx - 1).setDone(true);
      return ui.getShowDoneTask(Parser.getTaskType(listOfTasks.get(idx - 1)), listOfTasks.get(idx - 1).toString());
    } catch (IndexOutOfBoundsException e) {
      return ("[ERROR] No task found for the number you want to set done");
    }
  }

  public void setTaskDone(int idx) throws DukeException {
    try {
      Ui.printDone();
      listOfTasks.get(idx - 1).setDone(true);
      ui.showDoneTask(Parser.getTaskType(listOfTasks.get(idx - 1)), listOfTasks.get(idx - 1).toString());
    } catch (IndexOutOfBoundsException e) {
      throw new DukeException("[ERROR] No task found for the number you want to set done");
    }
  }

  public boolean isTaskCompleted(int idx) {
    return listOfTasks.get(idx - 1).isDone();
  }

  public void setTaskDoneSliently(int idx) throws DukeException {
    try {
      Ui.printDone();
      listOfTasks.get(idx - 1).setDone(true);
    } catch (IndexOutOfBoundsException e) {
      throw new DukeException("[ERROR] No task found for the number you want to set done");
    }
  }

  public void removeTask(int idx) throws DukeException {
    try {
      if(idx<1) {
        throw new IndexOutOfBoundsException();
      }
      if(listOfTasks.size() < idx)
        throw new IndexOutOfBoundsException();

      ui.showDeleteMessage();
      ui.showDeleteTaskDetails(Parser.getTaskType(listOfTasks.get(idx - 1)), listOfTasks.get(idx - 1).toString(), listOfTasks.get(idx - 1).isDone());
      listOfTasks.remove(idx - 1);
      ui.showTotalNumberTaskAdded(listOfTasks.size());
    } catch (IndexOutOfBoundsException e) {
      throw new DukeException("[ERROR] No task found for the number you want to set done");
    }
  }

  public String getRemoveTask(int idx) throws DukeException {
    String message = "";
    String newLine = "\n";
    try {
      message = message + ui.getShowDeleteMessage() + newLine;
      message = message + ui.getShowDeleteTaskDetails(Parser.getTaskType(listOfTasks.get(idx - 1)), listOfTasks.get(idx - 1).toString(), listOfTasks.get(idx - 1).isDone()) +
                newLine;
      listOfTasks.remove(idx - 1);
      message = message + ui.getShowTotalNumberTaskAdded(listOfTasks.size()) + newLine;
    } catch (IndexOutOfBoundsException e) {
      message = ("[ERROR] No task found for the number you want to set done");
    }

    return message;
  }

  public boolean isEmpty() {
    boolean isEmpty = listOfTasks.isEmpty();
    return isEmpty;
  }

  public int getSize() {
    return listOfTasks.size();
  }

  public String saveTask(int idx) {
    String value = listOfTasks.get(idx).saveTask();
    //System.out.println(value);
    return value;
  }

  public void findTask(String keyword) {
    int itemRank = 1;

    if (listOfTasks.isEmpty())
      Ui.showToUser("No tasks has been added to the list yet.");

    for (Task task : listOfTasks) {
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
    if (listOfTasks.isEmpty())
      return Ui.getShowToUser("No tasks has been added to the list yet.");

    for (Task task : listOfTasks) {
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
    String item = listOfTasks.get(index).toString();
    System.out.println(item);
    return item;
  }
}
