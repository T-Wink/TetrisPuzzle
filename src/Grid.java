
public class Grid {
	
	static Double standardFigureX = (double) 200;
	static Double standardFigureY = (double) 200;
	static Double standardBlockSize = (double) 50;
	static Double standardTileSize = standardBlockSize + 1;
	Tile[][] tiles;

	public Grid() {
		tiles = new Tile[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) tiles[i][j] = new Tile(i * standardTileSize, j * standardTileSize, standardTileSize);
		}
	}
	
	public Grid(Double standardX, Double standardY, Double standardSize) {
		Grid.standardFigureX = standardX;
		Grid.standardFigureY = standardY;
		Grid.standardBlockSize = standardSize;
		Grid.standardTileSize = standardBlockSize + 1;
		tiles = new Tile[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) tiles[i][j] = new Tile(i * standardTileSize, j * standardTileSize, standardTileSize);
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
	
	public Tile[][] getTiles() {
		return this.tiles;
	}
	
}
