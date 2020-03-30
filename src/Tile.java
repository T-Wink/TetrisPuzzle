import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
	
	boolean isUsed = false;
	boolean isHovered = false;
	Block usedBlock;
	
	
	public Tile(double xPos, double yPos, double width) {
		this.setX(xPos);
		this.setY(yPos);
		this.setWidth(width);
		this.setHeight(width);
		this.setFill(Color.BEIGE);
		this.setStroke(Color.BLACK);
	}
	
	public void setUsed() {
		this.setFill(Block.color);
		isUsed = true;
		isHovered = false;
	}
	
	public void setEmpty() {
		this.setFill(Color.BEIGE);
		isUsed = false;
		isHovered = false;
	}
	
	public void setHovered() {
		this.setFill(Color.GRAY);
		isHovered = true;
	}

}
