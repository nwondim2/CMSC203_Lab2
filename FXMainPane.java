import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	// Buttons
	
	private Button helloButton;
	private Button howdyButton;
	private Button chineseButton;
	private Button clearButton;
	private Button exitButton;
	
	// Labels
	
	private Label label;
	
	// Boxes
	private HBox box1;
	private HBox box2;
	// Textbox
	private TextField txtField = new TextField();

	//student Task #4:
	//  declare an instance of DataManager
	private DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");
		label = new Label("Feedback: ");
		txtField = new TextField();
		box1 = new HBox();
		box2 = new HBox();
		
		// Organize buttons into boxes
		box1.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
		box2.getChildren().addAll(label, txtField);
		this.getChildren().addAll(box1, box2);
		
		
		// Set Margins
		box1.setMargin(helloButton, new Insets(5));
		box1.setMargin(howdyButton, new Insets(5));
		box1.setMargin(chineseButton, new Insets(5));
		box1.setMargin(clearButton, new Insets(5));
		box1.setMargin(exitButton, new Insets(5));
		
		box2.setMargin(label, new Insets(10));
		box2.setMargin(txtField, new Insets(10));
		
		box1.setAlignment(Pos.CENTER); // align
		box2.setAlignment(Pos.CENTER);
		
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		manager = new DataManager();
		helloButton.setOnAction(new ButtonHandler());
		howdyButton.setOnAction(new ButtonHandler());
		chineseButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		exitButton.setOnAction(new ButtonHandler());
		txtField.setOnAction(new ButtonHandler());
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
	
		
	}
	
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			if (event.getTarget() == helloButton) {
				txtField.setText(manager.getHello());
				
			} else if (event.getTarget() == howdyButton) {
				txtField.setText(manager.getHowdy());
				
			} else if (event.getTarget() == chineseButton) {
				txtField.setText(manager.getChinese());
				
			} else if (event.getTarget() == clearButton) {
				txtField.setText("");
				
			} else {
				// Program Ends
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
	
}