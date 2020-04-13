import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.Group;

/**
 * Class to generate and place figures
 * @author Timon
 *
 */
public class FigureHandler {

	static Group root;
	
	private FigureHandler() {
		
	}
	
	
	/**
	 * Initializes three random figures to their respective places
	 */
	public static void initFiguresToPlace() {
		Block[] firstFigure = getRandomFigure(0);
	    Block[] secondFigure = getRandomFigure(1);
	    Block[] thirdFigure = getRandomFigure(2);
	    addNewFigure(firstFigure);
	    addNewFigure(secondFigure);
	    addNewFigure(thirdFigure);
	}
	
	/**
	 * sets the standard X and Y for each Block of the figure as its current X and Y
	 * @param figure
	 */
	private static void setStandardXYForFigure(Block[] figure) {
		for(Block b : figure) b.setStandard(b.getX(), b.getY());
	}
	
	
	/**
	 * Evaluates where the figure is to be placed on the X-axis depending on whether it's the first, second or third place
	 * @param place 1, 2 or 3
	 * @return returns the static Grid's standard X for first, second or third place
	 */
	private static double getStandardX(int place) {
		return place == 0 ? Grid.getStandardX() : (place == 1 ? Grid.getStandardFigure2X() : Grid.getStandardFigure3X());
	}
	
	/**
	 * Evaluates where the figure is to be placed on the Y-axis depending on whether it's the first, second or third place
	 * @param place 1, 2 or 3
	 * @return returns the static Grid's standard Y for first, second or third place
	 */
	private static double getStandardY(int place) {
		return place == 0 ? Grid.getStandardY() : (place == 1 ? Grid.getStandardFigure2Y() : Grid.getStandardFigure3Y());
	}
	
	/**
	 * Sets the standard X and Y positions for the figure (to which they return if they aren't placed at a placeable spot) 
	 * and sets the figure for each Block of the figure
	 * @param figure
	 */
	private static void setStandardXYAndSetFigure(Block[] figure) {
		setStandardXYForFigure(figure);
		for(Block b : figure) b.setFigure(figure);
	}
	
	
	/**
	 *   #
	 * ###
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getLeftRotatedL(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block b4 = new Block();
		b4.setDownBlock(b3);
		b3.setUpBlock(b4);
		Block[] leftRotatedL = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(leftRotatedL);
		return leftRotatedL;
	}
	
	/**
	 * #
	 * #
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getDoubleBlockVertical(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block(b1);
		Block[] doubleBlock = {b1, b2};
		setStandardXYAndSetFigure(doubleBlock);
		return doubleBlock;
	}
	
	/**
	 * ##
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getDoubleBlockHorizontal(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block();
		b2.setDownBlock(b1);
		b1.setUpBlock(b2);
		Block[] doubleBlock = {b1, b2};
		setStandardXYAndSetFigure(doubleBlock);
		return doubleBlock;
	}
	
	/**
	 * #
	 * #
	 * #
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getTripleBlockVertical(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block[] tripleBlock = {b1, b2, b3};
		setStandardXYAndSetFigure(tripleBlock);
		return tripleBlock;
	}
	
	/**
	 * ###
	 *  #
	 *  #
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getT(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block b4 = new Block();
		b4.setUpBlock(b2);
		b2.setDownBlock(b4);
		Block b5 = new Block();
		b5.setUpBlock(b4);
		b4.setDownBlock(b5);
		Block[] tFigure = {b1, b2, b3, b4, b5};
		setStandardXYAndSetFigure(tFigure);
		return tFigure;
	}
	
	
	/**
	 * #
	 * ###
	 * #
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getLeftRotatedT(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
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
	
	
	/**
	 *   #
	 * ###
	 *   #  
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getRightRotatedT(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
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
	
	/**
	 * #
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getSingleBlock(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block[] singleBlockFigure = {b1};
		setStandardXYAndSetFigure(singleBlockFigure);
		return singleBlockFigure;
	}
	
	
	/**
	 * ##
	 * ##
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getQuadrupelBlock(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
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
	
	
	/**
	 * #
	 * ###
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getRightRotatedL(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block(b1);
		Block b3 = new Block(b2);
		Block b4 = new Block();
		b4.setUpBlock(b1);
		b1.setDownBlock(b4);
		Block[] rightRotatedL = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(rightRotatedL);
		return rightRotatedL;
	}
	
	
	/**
	 * #
	 * #
	 * ##
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getL(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
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
	
	
	/**
	 * ###
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getTripleBlockHorizontal(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
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
	
	
	/**
	 * #
	 * ##
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getStep(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block(b2);
		Block[] step = {b1, b2, b3};
		setStandardXYAndSetFigure(step);
		return step;
	}
	
	
	/**
	 * ##
	 * #
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getRightRotatedStep(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block();
		b2.setUpBlock(b1);
		b1.setDownBlock(b2);
		Block b3 = new Block(b1);
		Block[] step = {b1, b2, b3};
		setStandardXYAndSetFigure(step);
		return step;
	}
	
	
	/**
	 *  #
	 * ##
	 * @param place the place of the figure (whether it's to be placed as first, second or third figure)
	 * @return Block[] figure, an array of Block-Objects
	 */
	public static Block[] getLeftRotatedStep(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY);
		Block b2 = new Block(b1);
		Block b3 = new Block();
		b3.setDownBlock(b2);
		b2.setUpBlock(b3);
		Block[] step = {b1, b2, b3};
		setStandardXYAndSetFigure(step);
		return step;
	}
	
	
	
	/**
	 * returns a random figure
	 * @param place the place of the figure (whether it's the first, second or third) for determining its position
	 * @return a random figure (Array of Block-Objects)
	 */
	public static Block[] getRandomFigure(int place) {
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
			return getRandomFigure(place);
		}
	}
	
	public static void setRoot(Group root) {
		FigureHandler.root = root;
	}
	
	public static Group getRoot() {
		return FigureHandler.root;
	}
	
	
	/**
	 * adds a new figure to the root, so that they can be displayed
	 * @param figure Array of Block-Objects
	 */
	public static void addNewFigure(Block[] figure) {
	    root.getChildren().addAll(figure);
	}
}
