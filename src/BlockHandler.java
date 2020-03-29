import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BlockHandler {
	
	private static ArrayList<Tile> hoveredTiles = new ArrayList<Tile>();
	
	public static void handleClicked(MouseEvent t, Block b) {
		for(Block figureBlock : b.getFigure()) figureBlock.onMouseClicked(t);
	}
	
	public static void handleDragged(MouseEvent t, Block b) {
		for(Block figureBlock : b.getFigure()) figureBlock.onMouseDragged(t);
		updateTiles(b);
	}

	public static void handleReleased(Block b) {
		updateHoveredTilesList();
		if(hoveredTiles.size() == b.getFigure().length) {
			setTiles(b);
			for(Block figureBlock : b.getFigure()) FigureHandler.getRoot().getChildren().remove(figureBlock);
			if(FigureHandler.getRoot().getChildren().size() < 82) FigureHandler.init();
		}
		else putBack(b);
		
	}

	private static void putBack(Block b) {
		for(Block figureBlock : b.getFigure()) {
			figureBlock.setX(figureBlock.getStandardX());
			figureBlock.setY(figureBlock.getStandardY());
		}
	}

	private static void setTiles(Block b) {
		updateHoveredTilesList();
		for(Tile tile : hoveredTiles) tile.setUsed();
		
	}

	private static void updateTiles(Block b) {
		for(Tile[] tileRow : Grid.getTiles()) {
			for(Tile tile : tileRow) {
				boolean found = false;
				for(Block figureBlock : b.getFigure()) {
					double xCenter = figureBlock.getX() + (figureBlock.getWidth() / 2);
					double yCenter = figureBlock.getY() + (figureBlock.getWidth() / 2);
					if(!tile.isUsed && tile.getX() <= xCenter && tile.getX() + tile.getWidth() >= xCenter && tile.getY() <= yCenter && tile.getY() + tile.getWidth() >= yCenter) {
						found = true;
						tile.setHovered();
					}
				}
				if(!(found || tile.isUsed)) tile.setUnhovered();
			}
		}
	}
	
	private static void updateHoveredTilesList() {
		hoveredTiles.clear();
		for(Tile[] tileRow : Grid.getTiles()) {
			for(Tile tile : tileRow) if(tile.isHovered) hoveredTiles.add(tile);
		}
	}
}
