package seedu.duke.model;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deadline is a class that extends Todo
 * As Deadline consist of deadline information in this class.
 * @author olivier cheah
 */
public class Deadline extends Todo {
    private Date deadline;

    public Deadline(String description, Date deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
      String date = sdf.format(deadline);
      return super.toString() + " (by: " + date + ")";
    }

    @Override
    public String saveTask(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String date = sdf.format(deadline);
        return "D | " + (super.isDone() ? "1" : "0") + " | " + super.getDescription() + " | " + date + "\n";
    }

    @Override
    public String getDeadline(){
      SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
      String date = sdf.format(deadline);

      return date;
    }

}
