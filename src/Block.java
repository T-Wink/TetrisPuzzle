import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
	
	Block leftNeighbor, rightNeighbor, upNeighbor, downNeighbor;
	Tile usedTile;
	Double mainSceneX, mainSceneY, width, standardX, standardY;
	static Color color = Color.BROWN;
	static Color borderColor = Color.BLACK;
	Block[] figure;
	
	
	/**
	 * Block constructor; sets position, width/height, neighboring blocks, event-handling, stroke (border color) and color
	 * @param x position on the x-axis
	 * @param y position on the y-axis
	 * @param width width/height of the Block
	 * @param blocks optional neighboring Blocks which have to be given in the following order: left, right, up, down
	 * Here, the association (setXXXBlock) is set on both sides, whereas if you just call setXXXBlock it is only associated on one side
	 */
	public Block(double x, double y, Block... blocks) {
		super(x, y, Grid.getStandardBlockSize(), Grid.getStandardBlockSize());
		this.width = Grid.getStandardBlockSize(); // TODO: width auslagern oder statisch machen
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
			BlockHandler.handleReleased(this);
	    });
		
		this.setFill(Block.color);
		this.setStroke(Block.borderColor);
	}
	
	/**
	 * Since x and y position are adjusted automatically when neighboring blocks are set, there may be no need to pass them as arguments
	 * if a neighboring block already has a set position
	 * @param blocks optional neighboring Blocks which have to be given in the following order: left, right, up, down
	 */
	public Block(Block...blocks) {
		this(0, 0, blocks);
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
	
	public Double getStandardX() {
		return standardX;
	}

	public void setStandardX(Double standardX) {
		this.standardX = standardX;
	}

	public Double getStandardY() {
		return standardY;
	}

	public void setStandardY(Double standardY) {
		this.standardY = standardY;
	}

	public Block[] getNeighboringBlocks() {
		Block[] neighbors = {leftNeighbor, rightNeighbor, upNeighbor, downNeighbor};
		return neighbors;
	}
	
	public Block[] getFigure() {
		return this.figure;
	}
	
	public void setFigure(Block[] figure) {
		this.figure = figure;
	}
	
	public void onMouseDragged(MouseEvent t) {
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

	public void setStandard(double x, double y) {
		this.standardX = x;
		this.standardY = y;
		
	}
	
}
