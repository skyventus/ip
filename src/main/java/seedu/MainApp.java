package seedu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seedu.duke.Duke;
import seedu.duke.commons.DukeException;
import seedu.duke.model.TaskList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import java.io.IOException;


public class MainApp extends Application{

  private ScrollPane scrollPane;
  private VBox dialogContainer;
  private TextField userInput;
  private Button sendButton;
  private Scene scene;
  private HBox hbox;
  private Ui ui;
  private TaskList taskList;
  private Storage storage;
  final String filePath = "data/Duke.txt";
  ListView listView = new ListView();

  Duke duke = new Duke(filePath);

  @Override
  public void init() throws Exception {
    storage  = new Storage("Data","Duke.txt");
    try {
      taskList = storage.load(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DukeException e) {
      e.printStackTrace();
    }
    initModel();
    super.init();
  }

  public void initModel(){
    System.out.println("---PROGRAM STARTING UP---");
    for (int i = 1; i<=taskList.getSize(); i++){
      listView.getItems().add(taskList.getTask(i-1));
    }
  }

  @Override
  public void start(Stage stage) throws Exception {
    System.out.println("---PROGRAM RUNNING---");

    scrollPane = new ScrollPane();
    dialogContainer = new VBox();
    scrollPane.setContent(dialogContainer);

    userInput = new TextField();
    sendButton = new Button("Send");

    AnchorPane mainLayout = new AnchorPane();
    mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

    scene = new Scene(mainLayout);

    stage.setScene(scene);
    stage.show();

    //Step 2. Formatting the window to look as expected
    stage.setTitle("Duke");
    stage.setResizable(false);
    stage.setMinHeight(600.0);
    stage.setMinWidth(400.0);

    mainLayout.setPrefSize(400.0, 600.0);

    scrollPane.setPrefSize(385, 535);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

    scrollPane.setVvalue(1.0);
    scrollPane.setFitToWidth(true);

    // You will need to import `javafx.scene.layout.Region` for this.
    dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

    userInput.setPrefWidth(325.0);

    sendButton.setPrefWidth(55.0);

    AnchorPane.setTopAnchor(scrollPane, 1.0);

    AnchorPane.setBottomAnchor(sendButton, 1.0);
    AnchorPane.setRightAnchor(sendButton, 1.0);

    AnchorPane.setLeftAnchor(userInput , 1.0);
    AnchorPane.setBottomAnchor(userInput, 1.0);

    dialogContainer.getChildren().add(getWelcomeDialogLabel());
    sendButton.setOnMouseClicked((event) -> {
      dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
      userInput.clear();
    });

    userInput.setOnAction((event) -> {
      dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
      userInput.clear();
    });
  }


  @Override
  public void stop() throws Exception {
    System.out.println("---PROGRAM CLOSING AND SAVING---");
    duke.saveAllTask();
    super.stop();
  }

  /**
   * Iteration 1:
   * Creates a label with the specified text and adds it to the dialog container.
   * @param text String containing text to add
   * @return a label with the specified text that has word wrap enabled.
   */
  private Label getDialogLabel(String text) {
    // You will need to import `javafx.scene.control.Label`.
    // Call Duke with the input so that we can get the result that we want to display.

    String answer = duke.getResponse(text);
    Label textToAdd = new Label(answer);
    textToAdd.setWrapText(true);

    return textToAdd;
  }

  private Label getWelcomeDialogLabel() {
    // You will need to import `javafx.scene.control.Label`.
    // Call Duke with the input so that we can get the result that we want to display.

    String welcome =  Ui.getPrintWelcome() + "\n";
    welcome = welcome + Ui.getShowToUser("---Total number of task loaded: " + taskList.getSize()) ;
    Label textToAdd = new Label(welcome);
    textToAdd.setWrapText(true);

    return textToAdd;
  }
  public static void main(String[] args) {
    launch(args);
  }
}
