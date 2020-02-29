import java.util.ArrayList;

public class Block {
	
	ArrayList<Tile> usedTiles = new ArrayList<Tile>();
	
	public void placeBlocks(ArrayList<Tile> usedTiles) {
		this.usedTiles = usedTiles;
	}
	
	public void placeBlock(Tile tile) {
		if(!usedTiles.contains(tile)) {
			usedTiles.add(tile);
			tile.setPiece(this);
		}
	}
	
	public void deleteTiles(ArrayList<Tile> deletedTiles) {
		for(Tile tile : deletedTiles) {
			deleteTile(tile);
		}
	}
	
	public void deleteTile(Tile tile) {
		if(usedTiles.contains(tile)) {
			usedTiles.remove(tile);
			tile.deletePiece();
		}
	}
}
