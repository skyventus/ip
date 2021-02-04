package seedu.duke.storage;

import seedu.duke.commons.DukeException;
import seedu.duke.model.TaskList;
import seedu.duke.commons.Parser;
import seedu.duke.ui.Ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Storage {

    private String filePath;
    private String filename;
    private Ui myUI = new Ui();
    private TaskList tasks;

    public Storage(String filePath, String filename){
        this.filePath = filePath;
        this.filename = filename;
        File directory = new File(filePath);
        if(! directory.exists()) {
            directory.mkdir();
            System.out.println(directory.exists());
        }
    }

    public TaskList load(String NewFilepath) throws IOException, DukeException {
        //check directory
        this.filePath=NewFilepath;
        String[] task;
        File f = new File(filePath); // create a File for the given file path
        f.createNewFile();
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        int idx = 1;
        tasks = new TaskList();
        if(! s.hasNext()){
            System.out.println("No tasks to load");
        }
        while(s.hasNext()){
            task = s.nextLine().split(Pattern.quote("|"));
            try{
                if (task[0].trim().equals("T")) {
                    tasks.addTaskWithoutMessage(Parser.createTodo(task[2]));
                } else if (task[0].trim().equals("D")) {
//                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//                    Date date = df.parse(task[3].trim());
                    tasks.addTaskWithoutMessage(Parser.createDeadline(task[2].trim(), task[3].trim()));
                } else if (task[0].trim().equals("E")){
                    tasks.addTaskWithoutMessage(Parser.createEvent(task[2].trim(), task[3].trim()));
                }
                if (task[1].contains("1")) {
                    tasks.setTaskDoneSliently(idx);
                }
                idx++;
            }catch (StringIndexOutOfBoundsException | ParseException e){
                e.getMessage();
            }
        }

        return this.tasks;
    }

    public void save(TaskList tasks) throws DukeException {
        FileWriter fw ;
        if(tasks.isEmpty()){
            System.out.println("[INFO] No tasks in the file to save");
        }else {
            try {
                fw = new FileWriter(filePath);
                for (int i = 0; i < tasks.getSize(); i++) {
                    fw.write(tasks.saveTask(i));
                }
                fw.close();
                myUI.showFileSavedMessage();
            } catch (IOException e) {
                throw new DukeException(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException(e.getMessage());
            }
        }

    }

}
