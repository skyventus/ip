package seedu.duke;


import seedu.duke.commons.DukeException;
import seedu.duke.model.TaskList;
import seedu.duke.commons.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.text.ParseException;

public class Duke {

    private Ui ui;
    private TaskList listOfTasks;
    private Storage storage;

    public Duke (String filePath){

        storage  = new Storage("Data","Duke.txt");
        try {
            listOfTasks =storage.load(filePath);
            Ui.showToUser("---Total number of task loaded: " + listOfTasks.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }

    public String getResponse(String input){

      String fullCommand = input.toLowerCase();
      String commandWord = Parser.getCommandWord(fullCommand);
      String returnMessage = "You have entered: '" + fullCommand + "' \n";
      try{
        switch(commandWord){
          case("list"):
            return returnMessage + listOfTasks.getPrintTasks();
          case("done"):
            return returnMessage + listOfTasks.getSetTaskDone(Parser.getTaskIndex(fullCommand));
          case("todo"):
            return returnMessage + listOfTasks.getAddTask(Parser.createTodo(Parser.getTodoDescription(fullCommand,commandWord)));
          case("deadline"):
            return returnMessage + listOfTasks.getAddTask(Parser.createDeadline(Parser.getDescriptionOnly(fullCommand,commandWord, "/by")
                    ,Parser.getDeadline(fullCommand)));
          case("event"):
            return returnMessage + listOfTasks.getAddTask(Parser.createEvent(Parser.getDescriptionOnly(fullCommand,commandWord, "/at")
                    ,Parser.getEventTiming(fullCommand)));
          case("delete"):
            return returnMessage + listOfTasks.getRemoveTask(Parser.getDeleteIndex(fullCommand));
          case("save"):
            return "When you close this program, the list of tasks will be saved.";
          case("find"):
            return returnMessage + listOfTasks.getFindTask(Parser.getItemToFind(fullCommand,commandWord));
          default:
            return returnMessage + Ui.getShowToUser("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
      }catch (DukeException e){
        return returnMessage + (e.getMessage());
      }catch (ParseException e){
        return returnMessage + ("Date format invalid. Please set it as dd/mm/yyyy. Eg: 21/12/2021");
      }

    }

    public void saveAllTask() throws DukeException {
      storage.save(listOfTasks);
    }
    public void run(){
        ui = new Ui();

        ui.printWelcome();

        String fullCommand = ui.readUserCommand().toLowerCase();
        String commandWord = Parser.getCommandWord(fullCommand);

        while(!commandWord.equals("bye")) {
            try{
                switch(commandWord){
                    case("list"):
                        listOfTasks.printTasks();
                        break;
                    case("sort"):
                      listOfTasks.sortDeadlineTasks();
                        break;
                    case("done"):
                        listOfTasks.setTaskDone(Parser.getTaskIndex(fullCommand));
                        break;
                    case("todo"):
                        listOfTasks.addTask(Parser.createTodo(Parser.getTodoDescription(fullCommand,commandWord)));
                        break;
                    case("deadline"):
                        listOfTasks.addTask(Parser.createDeadline(Parser.getDescriptionOnly(fullCommand,commandWord, "/by")
                                ,Parser.getDeadline(fullCommand)));
                        break;
                    case("event"):
                        listOfTasks.addTask(Parser.createEvent(Parser.getDescriptionOnly(fullCommand,commandWord, "/at")
                                ,Parser.getEventTiming(fullCommand)));
                        break;
                    case("delete"):
                        listOfTasks.removeTask(Parser.getDeleteIndex(fullCommand));
                        break;
                    case("save"):
                        storage.save(listOfTasks);
                        break;
                    case("find"):
                        listOfTasks.findTask(Parser.getItemToFind(fullCommand,commandWord));
                        break;
                    default:
                        Ui.showToUser("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        break;
                }
            }catch (DukeException e){
                System.out.println(e.getMessage());
            }catch (ParseException e){
              System.out.println("Date format invalid. Please set it as dd/mm/yyyy. Eg: 21/12/2021");
            }
            fullCommand = ui.readUserCommand().toLowerCase();
            commandWord = Parser.getCommandWord(fullCommand);
        }

        ui.showByeMessage();

    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.java.command"));
        new Duke("data/Duke.txt").run();
    }


}
