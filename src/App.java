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
	  // Die Liste unserer Nodes (hier Vierecke)
	private ArrayList<Shape> nodes;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
	    Scene scene = new Scene(root, 400, 300);
	    BlockHandler blockHandler = new BlockHandler(mainSceneX, mainSceneY);

	    // Viereck, das Bewegt wird
	    Rectangle rectToMove = blockHandler.newRectangle(50, 50, 50, 50);
	    // Viereck, das unser Ziel ist
	    Rectangle rectTarget = blockHandler.newRectangle(150, 150, 100, 100);

	    // hinzufügen unserer Vierecke (Nodes)
	    nodes = new ArrayList<Shape>();
	    nodes.add(rectToMove);
	    nodes.add(rectTarget);

	    root.getChildren().addAll(rectToMove,rectTarget);


	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }

	  // Diese Methode sucht nach einer Kollision. Danke an Jewelsea von StackOverflow
	  // Diese Methode wird jedes mal aufgerufen wenn man unser kleines Viereck
	  // gedraggt wird.
	  private void checkBounds(Shape block) {
		  boolean collisionDetected = false;
		  for (Shape static_bloc : nodes) {
		    if (static_bloc != block) {
		      static_bloc.setFill(Color.YELLOW);

		      if (block.getBoundsInParent().intersects(static_bloc.getBoundsInParent())) {
		        collisionDetected = true;
		      }
		    }
		  }

		  if (collisionDetected) {
		    block.setFill(Color.GREEN);
		  } else {
		    block.setFill(Color.BLUE);
		  }
		}
	
	public static void main(String[] args) {
		launch(args);
	}

}
