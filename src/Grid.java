import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The Grid initializes the 9x9 Tile-Objects and possesses the standard position / size attributes for figures / blocks and tiles
 * @author Timon
 *
 */
public class Grid {
	
	static Double standardBlockSize = (double) 50;
	static Double standardTileSize = standardBlockSize + 1;
	static Tile[][] tiles;
	static Double standardFigureX = (double) standardTileSize * 10;
	static Double standardFigureY = standardTileSize * 2 + 50;
	static Double standardFigure2X = Grid.standardFigureX + standardTileSize * 5;
	static Double standardFigure2Y = Grid.standardFigureY;
	static Double standardFigure3X = Grid.standardFigure2X + standardTileSize * 5;
	static Double standardFigure3Y = Grid.standardFigureY;
	static Color ticTacToeColor = Color.BLACK;
	static Rectangle[] ticTacToeGrid;
	
	private Grid() {
		
	}

	public static void init() {
		tiles = new Tile[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) tiles[i][j] = new Tile(j * standardTileSize, i * standardTileSize, standardTileSize);
		}
		
		ticTacToeGrid = new Rectangle[4];
		for(int i = 1; i < 3; i++) {
			Rectangle rect1 = new Rectangle(0, standardTileSize * 3 * i, standardTileSize * 9, 1);
			rect1.setFill(ticTacToeColor);
			Rectangle rect2 = new Rectangle(standardTileSize * 3 * i, 0, 1, standardTileSize * 9);
			rect2.setFill(ticTacToeColor);
			ticTacToeGrid[i == 1 ? i - 1 : i] = rect1;
			ticTacToeGrid[i == 1 ? i : i + 1] = rect2;
		}
		
		
	}
	
	public static void init(Double standardX, Double standardY, Double standardSize) {
		Grid.standardFigureX = standardX;
		Grid.standardFigureY = standardY;
		Grid.standardFigure2X = Grid.standardFigureX + 350;
		Grid.standardFigure2Y = Grid.standardFigureY;
		Grid.standardFigure3X = Grid.standardFigure2X + 350;
		Grid.standardFigure3Y = Grid.standardFigureY;
		Grid.standardBlockSize = standardSize;
		Grid.standardTileSize = standardBlockSize + 1;
		init();
	}
	
	public static Rectangle[] getTicTacToeGrid() {
		return ticTacToeGrid;
	}
	
	public static double getStandardX() {
		return standardFigureX;
	}
	
	public void setStandardX(Double standardX) {
		Grid.standardFigureX = standardX;
	}

	public static Double getStandardY() {
		return standardFigureY;
	}

	public void setStandardY(Double standardY) {
		Grid.standardFigureY = standardY;
	}

	public static Double getStandardSize() {
		return standardBlockSize;
	}

	public void setStandardSize(Double standardSize) {
		Grid.standardBlockSize = standardSize;
	}
	
	public static Tile[][] getTiles() {
		return Grid.tiles;
	}

	public static Double getStandardFigure2X() {
		return standardFigure2X;
	}

	public static void setStandardFigure2X(Double standardFigure2X) {
		Grid.standardFigure2X = standardFigure2X;
	}

	public static Double getStandardFigure2Y() {
		return standardFigure2Y;
	}

	public static void setStandardFigure2Y(Double standardFigure2Y) {
		Grid.standardFigure2Y = standardFigure2Y;
	}

	public static Double getStandardFigure3X() {
		return standardFigure3X;
	}

	public static void setStandardFigure3X(Double standardFigure3X) {
		Grid.standardFigure3X = standardFigure3X;
	}

	public static Double getStandardFigure3Y() {
		return standardFigure3Y;
	}

	public static void setStandardFigure3Y(Double standardFigure3Y) {
		Grid.standardFigure3Y = standardFigure3Y;
	}

	public static Double getStandardBlockSize() {
		return standardBlockSize;
	}

	public static void setStandardBlockSize(Double standardBlockSize) {
		Grid.standardBlockSize = standardBlockSize;
	}

	public static Double getStandardTileSize() {
		return standardTileSize;
	}

	public static void setStandardTileSize(Double standardTileSize) {
		Grid.standardTileSize = standardTileSize;
	}

	public static Double getStandardFigureX() {
		return standardFigureX;
	}

	public static void setStandardFigureX(Double standardFigureX) {
		Grid.standardFigureX = standardFigureX;
	}

	public static Double getStandardFigureY() {
		return standardFigureY;
	}

	public static void setStandardFigureY(Double standardFigureY) {
		Grid.standardFigureY = standardFigureY;
	}

	public static void setTiles(Tile[][] tiles) {
		Grid.tiles = tiles;
	}
	
	
	
	
	
}
