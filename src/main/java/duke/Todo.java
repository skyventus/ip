package duke;

/**
 * Todo is a class that extends to task. As it contains the status of the tasks.
 * @author Olivier Cheah
 */
public class Todo extends Task {
    boolean taskStatus;

    public Todo(String Desc){
        super(Desc);
        taskStatus=false;
    }
    @Override
    public boolean isDone() {
        return taskStatus;
    }

    @Override
    public String saveTask(){
        return "T | " + (taskStatus ? "1" : "0")+ " | " + super.getDescription() + "\n";
    }


    @Override
    public void setDone(boolean done) {
        this.taskStatus=done;
    }
}
