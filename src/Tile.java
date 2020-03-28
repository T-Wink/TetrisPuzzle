import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
	
	boolean isUsed = false;
	Block usedBlock;
	
	
	public Tile(double xPos, double yPos, double width) {
		this.setX(xPos);
		this.setY(yPos);
		this.setWidth(width);
		this.setHeight(width);
		this.setFill(Color.BEIGE);
		this.setStroke(Color.BLACK);
	}
	
	public void setBlock(Block usedBlock) {
		if(this.usedBlock == null) {
			this.usedBlock = usedBlock;
			isUsed = true;
			usedBlock.placeAt(this);
		}
	}

}
