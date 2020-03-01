

import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BlockHandler {
	
	Double mainSceneX, mainSceneY;
	
	public BlockHandler(double mainSceneX, double mainSceneY) {
		this.mainSceneX = mainSceneX;
		this.mainSceneY = mainSceneY;
	}
	
	public Rectangle newRectangle(double x, double y, double width, double height) {
		Rectangle newRectangle = new Rectangle(x, y, width, height);
		// hier setzen wir die Maus, sodass sie
	    // eine Hand wird, wenn wir drüber fahren
		newRectangle.setCursor(Cursor.HAND);

	    // das wird aufgerufen, wenn unsere Maus auf
	    // das Viereck drückt
		newRectangle.setOnMousePressed((t) -> {
	    	mainSceneX = t.getSceneX();
	    	mainSceneY = t.getSceneY();
	    	Rectangle r = (Rectangle) (t.getSource());
	    	r.toFront();
	    });

	    // Wird aufgerufen, wenn unser Viereck sich bewegt
	    // also sehr häufig
		newRectangle.setOnMouseDragged((t) -> {
	      double offsetX = t.getSceneX() - mainSceneX;
	      double offsetY = t.getSceneY() - mainSceneY;

	      Rectangle r = (Rectangle) (t.getSource());

	      r.setX(r.getX() + offsetX);
	      r.setY(r.getY() + offsetY);

	      mainSceneX = t.getSceneX();
	      mainSceneY = t.getSceneY();
	    });

	    // wird aufgerufen, wenn man die Maus loslässt
		newRectangle.setOnMouseReleased((t) -> {
			newRectangle.setFill(Color.BLACK);
	    });
		
		return newRectangle;
	}

}
