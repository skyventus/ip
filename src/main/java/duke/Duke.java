package duke;

import java.io.IOException;

public class Duke {

    private Ui ui;
    private TaskList task;
    private Storage storage;

    public Duke (String filePath){

        storage  = new Storage("Data","Duke.txt");
        try {
            task=storage.load(filePath);
            Ui.showToUser("---Total number of task loaded: " + task.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DukeException e) {
            e.printStackTrace();
        }
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
                        task.printTasks();
                        break;
                    case("done"):
                        task.setTaskDone(Parser.getTaskIndex(fullCommand));
                        break;
                    case("todo"):
                        task.addTask(Parser.createTodo(Parser.getTodoDescription(fullCommand,commandWord)));
                        break;
                    case("deadline"):
                        task.addTask(Parser.createDeadline(Parser.getDescriptionOnly(fullCommand,commandWord, "/by")
                                ,Parser.getDeadline(fullCommand)));
                        break;
                    case("event"):
                        task.addTask(Parser.createEvent(Parser.getDescriptionOnly(fullCommand,commandWord, "/at")
                                ,Parser.getEventTiming(fullCommand)));
                        break;
                    case("delete"):
                        task.removeTask(Parser.getDeleteIndex(fullCommand));
                        break;
                    case("save"):
                        storage.save(task);
                        break;
                    case("find"):
                        task.findTask(Parser.getItemToFind(fullCommand,commandWord));
                        break;
                    default:
                        Ui.showToUser("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        break;
                }
            }catch (DukeException e){
                System.out.println(e.getMessage());
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
