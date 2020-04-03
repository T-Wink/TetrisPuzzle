import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.Group;

public class FigureHandler {

	static Group root;
	
	private FigureHandler() {
		
	}
	
	public static void initFiguresToPlace() {
		Block[] firstFigure = getRandomShape(0);
	    Block[] secondFigure = getRandomShape(1);
	    Block[] thirdFigure = getRandomShape(2);
	    addNewFigure(firstFigure);
	    addNewFigure(secondFigure);
	    addNewFigure(thirdFigure);
	}
	
	private static void setStandardXYForFigure(Block[] figure) {
		for(Block b : figure) b.setStandard(b.getX(), b.getY());
	}
	
	private static double getStandardX(int place) {
		return place == 0 ? Grid.getStandardX() : (place == 1 ? Grid.getStandardFigure2X() : Grid.getStandardFigure3X());
	}
	
	private static double getStandardY(int place) {
		return place == 0 ? Grid.getStandardY() : (place == 1 ? Grid.getStandardFigure2Y() : Grid.getStandardFigure3Y());
	}
	
	private static void setStandardXYAndSetFigure(Block[] figure) {
		setStandardXYForFigure(figure);
		for(Block b : figure) b.setFigure(figure);
	}
	
	public static Block[] getLeftRotatedL(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block b4 = new Block();
		b4.setDownBlock(b3);
		b3.setUpBlock(b4);
		Block[] leftRotatedL = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(leftRotatedL);
		return leftRotatedL;
	}
	
	public static Block[] getDoubleBlockVertical(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(Grid.getStandardBlockSize(), b1);
		Block[] doubleBlock = {b1, b2};
		setStandardXYAndSetFigure(doubleBlock);
		return doubleBlock;
	}
	
	public static Block[] getDoubleBlockHorizontal(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(Grid.getStandardBlockSize());
		b2.setDownBlock(b1);
		b1.setUpBlock(b2);
		Block[] doubleBlock = {b1, b2};
		setStandardXYAndSetFigure(doubleBlock);
		return doubleBlock;
	}
	
	public static Block[] getTripleBlockVertical(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(Grid.getStandardBlockSize(), b1);
		Block b3 = new Block(Grid.getStandardBlockSize(), b2);
		Block[] tripleBlock = {b1, b2, b3};
		setStandardXYAndSetFigure(tripleBlock);
		return tripleBlock;
	}
	
	public static Block[] getT(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(Grid.getStandardBlockSize(), b1);
		Block b3 = new Block(Grid.getStandardBlockSize(), b2);
		Block b4 = new Block(Grid.getStandardBlockSize());
		b4.setUpBlock(b2);
		b2.setDownBlock(b4);
		Block b5 = new Block(Grid.getStandardBlockSize());
		b5.setUpBlock(b4);
		b4.setDownBlock(b5);
		Block[] tFigure = {b1, b2, b3, b4, b5};
		setStandardXYAndSetFigure(tFigure);
		return tFigure;
	}
	
	public static Block[] getLeftRotatedT(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block();
		b3.setUpBlock(b2);
		b2.setDownBlock(b3);
		Block b4 = new Block(b2);
		Block b5 = new Block(b4);
		Block[] tFigure = {b1, b2, b3, b4, b5};
		setStandardXYAndSetFigure(tFigure);
		return tFigure;
	}
	
	public static Block[] getRightRotatedT(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block b4 = new Block();
		b4.setDownBlock(b3);
		b3.setUpBlock(b4);
		Block b5 = new Block();
		b5.setUpBlock(b3);
		b3.setDownBlock(b5);
		Block[] tFigure = {b1, b2, b3, b4, b5};
		setStandardXYAndSetFigure(tFigure);
		return tFigure;
	}
	
	public static Block[] getSingleBlock(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block[] singleBlockFigure = {b1};
		setStandardXYAndSetFigure(singleBlockFigure);
		return singleBlockFigure;
	}
	
	public static Block[] getQuadrupelBlock(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(b1);
		Block b3 = new Block();
		b3.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b4 = new Block(b3);
		b4.setUpBlock(b2);
		b2.setDownBlock(b4);
		Block[] quadrupelBlock = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(quadrupelBlock);
		return quadrupelBlock;
	}
	
	public static Block[] getRightRotatedL(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block b4 = new Block();
		b4.setUpBlock(b1);
		b1.setDownBlock(b4);
		Block[] rightRotatedL = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(rightRotatedL);
		return rightRotatedL;
	}
	
	public static Block[] getL(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block();
		b3.setUpBlock(b2);
		b2.setDownBlock(b3);
		Block b4 = new Block(b3);
		Block[] L = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(L);
		return L;
	}
	
	public static Block[] getTripleBlockHorizontal(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block();
		b3.setUpBlock(b2);
		b2.setDownBlock(b3);
		Block[] tripleBlock = {b1, b2, b3};
		setStandardXYAndSetFigure(tripleBlock);
		return tripleBlock;
	}
	
	public static Block[] getStep(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block(Grid.getStandardBlockSize(), b2);
		Block[] step = {b1, b2, b3};
		setStandardXYAndSetFigure(step);
		return step;
	}
	
	public static Block[] getRightRotatedStep(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block(Grid.getStandardBlockSize(), b1);
		Block[] step = {b1, b2, b3};
		setStandardXYAndSetFigure(step);
		return step;
	}
	
	public static Block[] getLeftRotatedStep(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(b1);
		Block b3 = new Block();
		b3.setDownBlock(b2);
		b2.setUpBlock(b3);
		Block[] step = {b1, b2, b3};
		setStandardXYAndSetFigure(step);
		return step;
	}
	
	
	public static Block[] getRandomShape(int place) {
		int i = ThreadLocalRandom.current().nextInt(0, 16);
		switch(i) {
		case 0:
			return getSingleBlock(place);
		case 1:
			return getDoubleBlockVertical(place);
		case 2:
			return getDoubleBlockHorizontal(place);
		case 3:
			return getStep(place);
		case 4:
			return getLeftRotatedStep(place);
		case 5:
			return getRightRotatedStep(place);
		case 6:
			return getTripleBlockVertical(place);
		case 7:
			return getTripleBlockHorizontal(place);
		case 8:
			return getQuadrupelBlock(place);
		case 9:
			return getL(place);
		case 10:
			return getLeftRotatedL(place);
		case 11:
			return getRightRotatedL(place);
		case 12:
			return getT(place);
		case 13:
			return getRightRotatedT(place);
		case 14:
			return getLeftRotatedT(place);
		default:
			return getRandomShape(place);
		}
	}
	
	public static void setRoot(Group root) {
		FigureHandler.root = root;
	}
	
	public static Group getRoot() {
		return FigureHandler.root;
	}
	
	public static void addNewFigure(Block[] figure) {
	    root.getChildren().addAll(figure);
	}
}
