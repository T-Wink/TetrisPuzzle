
public class Tile {
	
	boolean isUsed = false;
	Block usedBlock;
	int pos;
	
	public void setPiece(Block usedBlock) {
		if(!isUsed) {
			isUsed = true;
			this.usedBlock = usedBlock;
			usedBlock.placeBlock(this);
		}
	}
	
	public void deletePiece() {
		if(isUsed) {
			usedBlock.deleteTile(this);
			usedBlock = null;
			isUsed = false;
		}
	}

}
