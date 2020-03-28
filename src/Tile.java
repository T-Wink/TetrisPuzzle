
public class Tile {
	
	boolean isUsed = false;
	Block usedBlock;
	int xPos, yPos;
	
	
	public Tile(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void setBlock(Block usedBlock) {
		if(this.usedBlock == null) {
			this.usedBlock = usedBlock;
			isUsed = true;
			usedBlock.placeAt(this);
		}
	}

}
