
public class FigureHandler {
	
	public static Block[] getLeftRotatedL() {
		Block b1 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize());
		Block b2 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize(), b1);
		Block b3 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize(), b2);
		Block b4 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize());
		b4.setDownBlock(b3);
		b3.setUpBlock(b4);
		Block[] leftRotatedL = {b1, b2, b3, b4};
		return leftRotatedL;
	}
	
	public static Block[] getDoubleBlock() {
		Block b1 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize());
		Block b2 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize(), b1);
		Block[] doubleBlock = {b1, b2};
		return doubleBlock;
	}
	
	public static Block[] getTripleBlock() {
		Block b1 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize());
		Block b2 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize(), b1);
		Block b3 = new Block(Grid.getStandardX(), Grid.getStandardY(), Grid.getStandardSize(), b2);
		Block[] tripleBlock = {b1, b2, b3};
		return tripleBlock;
	}
}
