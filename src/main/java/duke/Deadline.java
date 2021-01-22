package duke;


/**
 * Deadline is a class that extends Todo
 * As Deadline consist of deadline information in this class.
 * @author olivier cheah
 */
public class Deadline extends Todo{
    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }

    @Override
    public String saveTask(){
        return "D | " + (super.isDone() ? "1" : "0") + " | " + super.getDescription() + " | " + deadline + "\n";
    }

}
