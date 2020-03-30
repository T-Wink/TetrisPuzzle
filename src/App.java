import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class App extends Application {
	
	Double mainSceneX = new Double(0);
	Double mainSceneY = new Double(0);

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
	    Scene scene = new Scene(root, 1280, 700);
	    Grid.init();
	    FigureHandler.setRoot(root);
	    
	    for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				root.getChildren().add(Grid.getTiles()[i][j]);
			}
		}
	    
	    FigureHandler.initFiguresToPlace();

	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	
	public static void main(String[] args) {
		launch(args);
	}

}
