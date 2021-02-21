package seedu.duke.ui;

import java.util.Scanner;

/**
 * UI is a class that create a scanner also showing general message all in one place.
 *
 * @author olivier cheah
 */

public class Ui {

  private Scanner in;
  static String indent = "    ";

  public Ui() {
    in = new Scanner(System.in);
  }

  String checkedMark = "\u2713";
  String cross = "\u2718";


  public static void printWelcome() {
    System.out.println(indent + "Hello! I'm Duke.Duke");
    System.out.println(indent + "What can I do for you?");
  }

  public static void printError(String message) {
    System.out.println(message);
  }

  public static void printDone() {
    System.out.println(indent + " Nice! I've marked this task as done: ");
  }

  public static void showToUser(String s) {
    System.out.println(s);
  }

  public static void printGotIt() {
    System.out.println(indent + "Got it. I've added this task:");
  }

  public String readUserCommand() {
    System.out.print("Your task? \n");
    return in.nextLine().trim();
  }

  public void showAddedTask(String classType, String description) {
    System.out.println(indent + "  [" + classType + "][" + cross + "] " + description);
  }

  public void showDoneTask(String classType, String description) {
    System.out.println(indent + "  [" + classType + "][" + checkedMark + "] " + description);
  }

  public void showTaskWithOrder(String classType, String description, int rank, boolean isDone) {
    System.out.println(indent + rank + ".[" + classType + "][" + (isDone ? checkedMark : cross) + "] " + description);
  }

  public void showTotalNumberTaskAdded(int totalNumberOfTask) {
    System.out.println(indent + "Now you have " + totalNumberOfTask + " tasks in the list");
  }

  public void showByeMessage() {
    System.out.println(indent + "Bye. Hope to see you again");
  }

  public void showDeleteMessage() {
    System.out.println(indent + "Noted. I've removed this task: ");
  }

  public void showDeleteTaskDetails(String classType, String description, boolean isDone) {
    System.out.println(indent + "  [" + classType + "][" + (isDone ? checkedMark : cross) + "] " + description);
  }

  public void showFileSavedMessage() {
    System.out.println(indent + "Your file has been saved to data/Duke.txt directory");
  }

  public static String getFileSavedMessage() {
    return (indent + "Your file has been saved to data/Duke.txt directory");
  }

  public static String getPrintWelcome() {
    String returnMessage;
    returnMessage = indent + "Hello! I'm Duke.Duke" + "\n" + indent + "What can I do for you?";
    return returnMessage;
  }

  public static String getPrintError(String message) {
    return message;
  }

  public static String getPrintDone() {
    return indent + " Nice! I've marked this task as done: ";
  }

  public static String getShowToUser(String s) {
    return (s);
  }

  public static String getPrintGotIt() {
    return indent + "Got it. I've added this task:";
  }

  public String getReadUserCommand() {
    System.out.print("Your task? \n");
    return in.nextLine().trim();
  }

  public String getShowAddedTask(String classType, String description) {
    return (indent + "  [" + classType + "][" + cross + "] " + description);
  }

  public String getShowDoneTask(String classType, String description) {
    return (indent + "  [" + classType + "][" + checkedMark + "] " + description);
  }

  public String getShowTaskWithOrder(String classType, String description, int rank, boolean isDone) {
    return (indent + rank + ".[" + classType + "][" + (isDone ? checkedMark : cross) + "] " + description);
  }

  public String getShowTotalNumberTaskAdded(int totalNumberOfTask) {
    return (indent + "Now you have " + totalNumberOfTask + " tasks in the list");
  }

  public String getShowByeMessage() {
    return (indent + "Bye. Hope to see you again");
  }

  public String getShowDeleteMessage() {
    return(indent + "Noted. I've removed this task: ");
  }

  public String getShowDeleteTaskDetails(String classType, String description, boolean isDone) {
    return(indent + "  [" + classType + "][" + (isDone ? checkedMark : cross) + "] " + description);
  }

  public String getShowFileSavedMessage() {
    return(indent + "Your file has been saved to data/Duke.txt directory");
  }
}
