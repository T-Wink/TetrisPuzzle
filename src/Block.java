import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
	
	Block leftNeighbor, rightNeighbor, upNeighbor, downNeighbor;
	Tile usedTile;
	Double mainSceneX, mainSceneY, width;
	
	
	public Block(double x, double y, double width, Block... blocks) {
		super(x, y, width, width);
		this.width = width; // TODO: width auslagern oder statisch machen
		if(blocks.length > 0) {
			setLeftBlock(blocks[0]);
			blocks[0].setRightBlock(this);
		}
		if(blocks.length > 1) {
			setRightBlock(blocks[1]);
			blocks[0].setLeftBlock(this);
		}
		if(blocks.length > 2) {
			setUpBlock(blocks[2]);
			blocks[0].setDownBlock(this);
		}
		if(blocks.length > 3) {
			setDownBlock(blocks[3]);
			blocks[0].setUpBlock(this);
		}
		
		this.setCursor(Cursor.HAND);


		this.setOnMousePressed((t) -> {
	    	BlockHandler.handleClicked(t, this);
	    });


		this.setOnMouseDragged((t) -> {
	      BlockHandler.handleDragged(t, this);
	    });

		
		this.setOnMouseReleased((t) -> {
			this.setFill(Color.BLACK);
	    });
	}
	
	public void placeAt(Tile tile) {
		if(usedTile != null) return;
		this.usedTile = tile;
		// TODO: for each neighboring tile, perform placeAt as well
	}
	
	public void setLeftBlock(Block block) {
		leftNeighbor = block;
		if(block != null) {
			this.setX(block.getX() + width);
			this.setY(block.getY());
		}
	}
	
	public void setRightBlock(Block block) {
		rightNeighbor = block;
		if(block != null) {
			this.setX(block.getX() - width);
			this.setY(block.getY());
		}
	}
	
	public void setUpBlock(Block block) {
		upNeighbor = block;
		if(block != null) {
			this.setY(block.getY() + width);
			this.setX(block.getX());
		}
	}
	
	public void setDownBlock(Block block) {
		downNeighbor = block;
		if(block != null) {
			this.setY(block.getY() - width);
			this.setX(block.getX());
		}
	}
	
	public Block getLeftBlock() {
		return leftNeighbor;
	}
	
	public Block getRightBlock() {
		return rightNeighbor;
	}
	
	public Block getUpBlock() {
		return upNeighbor;
	}
	
	public Block getDownBlock() {
		return downNeighbor;
	}
	
	public Block[] getNeighboringBlocks() {
		Block[] neighbors = {leftNeighbor, rightNeighbor, upNeighbor, downNeighbor};
		return neighbors;
	}
	
	public void onMouseDragged(MouseEvent t) {
		//TODO: Das hier verstehen
		double offsetX = t.getSceneX() - mainSceneX;
	    double offsetY = t.getSceneY() - mainSceneY;
	    this.setX(this.getX() + offsetX);
	    this.setY(this.getY() + offsetY);
	    mainSceneX = t.getSceneX();
	    mainSceneY = t.getSceneY();
	}
	
	public void onMouseClicked(MouseEvent t) {
		mainSceneX = t.getSceneX();
    	mainSceneY = t.getSceneY();
    	this.toFront();
	}
	
}
