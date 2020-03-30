
public class Grid {
	
	static Double standardBlockSize = (double) 50;
	static Double standardTileSize = standardBlockSize + 1;
	static Tile[][] tiles;
	static Double standardFigureX = (double) 200;
	static Double standardFigureY = standardTileSize * 9 + 50;
	static Double standardFigure2X = Grid.standardFigureX + 350;
	static Double standardFigure2Y = Grid.standardFigureY;
	static Double standardFigure3X = Grid.standardFigure2X + 350;
	static Double standardFigure3Y = Grid.standardFigureY;
	
	private Grid() {
		
	}

	public static void init() {
		tiles = new Tile[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) tiles[i][j] = new Tile(j * standardTileSize, i * standardTileSize, standardTileSize);
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
		tiles = new Tile[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) tiles[i][j] = new Tile(j * standardTileSize, i * standardTileSize, standardTileSize);
		}
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
	
	
	
}
