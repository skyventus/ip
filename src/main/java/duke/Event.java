package duke;

public class Event extends Todo {
    private String eventInformation;

    public Event(String description, String event){
        super(description);
        this.eventInformation = event;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + eventInformation + ")";
    }

}