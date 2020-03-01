import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Block {
	
	ArrayList<Rectangle> rectangles;
	ArrayList<Tile> usedTiles;
	
	public void placeBlocks(ArrayList<Rectangle> usedTiles) {
		this.rectangles = rectangles;
	}
	
	public void placeBlock(Tile tile) {
		if(!rectangles.contains(tile)) {
			rectangles.add(tile);
			tile.setPiece(this);
		}
	}
	
	public void deleteTiles(ArrayList<Tile> deletedTiles) {
		for(Tile tile : deletedTiles) {
			deleteTile(tile);
		}
	}
	
	public void deleteTile(Tile tile) {
		if(rectangles.contains(tile)) {
			rectangles.remove(tile);
			tile.deletePiece();
		}
	}
}
