import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BlockHandler {
	
	public static void handleClicked(MouseEvent t, Block b) {
		for(Block figureBlock : b.getFigure()) figureBlock.onMouseClicked(t);
	}
	
	public static void handleDragged(MouseEvent t, Block b) {
		for(Block figureBlock : b.getFigure()) figureBlock.onMouseDragged(t);
		updateWhichTilesAreHovered(b);
	}

	public static void handleReleased(Block b) {
		if(getHoveredTiles().size() == b.getFigure().length) {
			setTilesUsed(b);
			for(Block figureBlock : b.getFigure()) FigureHandler.getRoot().getChildren().remove(figureBlock);
			handleRowColumnOrBlockFilled();
			if(FigureHandler.getRoot().getChildren().size() < 82) FigureHandler.initFiguresToPlace();
		}
		else putBack(b);
		
	}

	private static void handleRowColumnOrBlockFilled() {
		ArrayList<Tile> tilesToSetEmpty = new ArrayList<>();
		ArrayList<Tile> usedTilesInRow;
		ArrayList<Tile> usedTilesInColumn;
		for(int i = 0; i < 9; i++) {
			usedTilesInRow = new ArrayList<Tile>();
			for(int j = 0; j < 9; j++) {
				if(isOneFourOrSeven(i) && isOneFourOrSeven(j)) {
					ArrayList<Tile> usedTiles = getUsedTilesOfTileBlock(i, j);
					if(usedTiles.size() == 9) tilesToSetEmpty.addAll(usedTiles);
				}
				if(Grid.getTiles()[i][j].isUsed) usedTilesInRow.add(Grid.getTiles()[i][j]);
				if(i == 0) {
					usedTilesInColumn = new ArrayList<Tile>();
					for(int k = 0; k < 9; k++) if(Grid.getTiles()[k][j].isUsed) usedTilesInColumn.add(Grid.getTiles()[k][j]);
					if(usedTilesInColumn.size() == 9) tilesToSetEmpty.addAll(usedTilesInColumn);
				}
				
			}
			System.out.println(usedTilesInRow.size());
			if(usedTilesInRow.size() == 9) tilesToSetEmpty.addAll(usedTilesInRow);
		}
		setTilesEmpty(tilesToSetEmpty);
		
	}

	private static boolean isOneFourOrSeven(int i) {
		return i == 1 || i == 4 || i == 7;
	}

	private static ArrayList<Tile> getUsedTilesOfTileBlock(int row, int column) {
		ArrayList<Tile> usedTiles = new ArrayList<Tile>();
		for(int i = row - 1; i < row + 2; i++) {
			for(int j = column - 1; j < column + 2; j++) if(Grid.getTiles()[i][j].isUsed) usedTiles.add(Grid.getTiles()[i][j]);
		}
		return usedTiles;
	}

	private static void putBack(Block b) {
		for(Block figureBlock : b.getFigure()) {
			figureBlock.setX(figureBlock.getStandardX());
			figureBlock.setY(figureBlock.getStandardY());
		}
	}

	private static void setTilesUsed(Block b) {
		for(Tile tile : getHoveredTiles()) tile.setUsed();	
	}
	
	private static void setTilesEmpty(ArrayList<Tile> tilesToSetEmpty) {
		for(Tile t : tilesToSetEmpty) t.setEmpty();
	}

	private static void updateWhichTilesAreHovered(Block b) {
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
				if(!(found || tile.isUsed)) tile.setEmpty();
			}
		}
	}
	
	private static ArrayList<Tile> getHoveredTiles() {
		ArrayList<Tile> hoveredTiles = new ArrayList<Tile>();
		for(Tile[] tileRow : Grid.getTiles()) {
			for(Tile tile : tileRow) if(tile.isHovered) hoveredTiles.add(tile);
		}
		return hoveredTiles;
	}
}
