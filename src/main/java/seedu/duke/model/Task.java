package seedu.duke.model;

/**
 * Task is the based class for this Duke and is a abstract class.
 * @author Olivier Cheah
 */

public abstract class Task {
    private String description;
//    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return description;
    }

    //Abstract methods
    public abstract boolean isDone();
    public abstract String saveTask();
    public abstract void setDone(boolean done);

}