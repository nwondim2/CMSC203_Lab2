import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {

    /**
     
The main method for the GUI example program JavaFX version
@param args not used
@throws IOException*/
public static void main(String[] args) {
    launch(args);
}
@Override
public void start(Stage stage) throws IOException {//student Task #1://  instantiate the FXMainPane, name it root
    FXMainPane root = new FXMainPane(); // set scene to hold root
    
    stage.setScene(new Scene(root, 350, 350)); // set the stage
    stage.setTitle("Hello World GUI"); // show the stage
    stage.show();

    }
}