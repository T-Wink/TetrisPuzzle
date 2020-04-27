import java.util.ArrayList;

import javafx.animation.FillTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class BlockHandler {
	
	private static int numberOfObjects = 81 + 1 + 1 + 4; //81 Tiles, highScore and score Texts, the four rectangles constituting the ticTacToe-Grid
	
	private BlockHandler() {
		
	}
	
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
			GameHandler.updateScore(b.getFigure().length);
			if(FigureHandler.getRoot().getChildren().size() <= numberOfObjects) FigureHandler.initFiguresToPlace();
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
				if(i % 3 == 1 && j % 3 == 1) {
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
			if(usedTilesInRow.size() == 9) tilesToSetEmpty.addAll(usedTilesInRow);
		}
		setTilesEmpty(tilesToSetEmpty);
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
		
		for(Tile tile : getHoveredTiles()) tile.setEmpty();
	}

	private static void setTilesUsed(Block b) {
		for(Tile tile : getHoveredTiles()) tile.setUsed();	
	}
	
	private static void setTilesEmpty(ArrayList<Tile> tilesToSetEmpty) {
		for(Tile t : tilesToSetEmpty) {
			// Create a transition from the color of the blocks to the color of the background tiles
			FillTransition fill = new FillTransition();
			fill.setAutoReverse(true);
			fill.setCycleCount(1);
			fill.setDuration(Duration.millis(500));
			fill.setFromValue(Block.color);
			fill.setToValue(Tile.fillColor);
			fill.setShape(t);
			fill.play();
			t.setEmpty();
		}
		GameHandler.updateScore(tilesToSetEmpty.size());
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
