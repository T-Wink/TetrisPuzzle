import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

public class FigureHandler {

	static Group root;
	
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
		if(place > 2) return null;
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(Grid.getStandardBlockSize());
		b2.setUpBlock(b1);
		b1.setUpBlock(b2);
		Block b3 = new Block(Grid.getStandardBlockSize());
		b3.setRightBlock(b2);
		b2.setLeftBlock(b3);
		Block b4 = new Block(Grid.getStandardBlockSize());
		b4.setRightBlock(b3);
		b3.setLeftBlock(b4);
		Block[] leftRotatedL = {b1, b2, b3, b4};
		setStandardXYAndSetFigure(leftRotatedL);
		return leftRotatedL;
	}
	
	public static Block[] getDoubleBlock(int place) {
		if(place > 2) return null;
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block b2 = new Block(Grid.getStandardBlockSize(), b1);
		Block[] doubleBlock = {b1, b2};
		setStandardXYAndSetFigure(doubleBlock);
		return doubleBlock;
	}
	
	public static Block[] getTripleBlock(int place) {
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
	
	public static Block[] getSingleBlock(int place) {
		double posX = getStandardX(place);
		double posY = getStandardY(place);
		Block b1 = new Block(posX, posY, Grid.getStandardBlockSize());
		Block[] singleBlockFigure = {b1};
		setStandardXYAndSetFigure(singleBlockFigure);
		return singleBlockFigure;
	}
	
	
	public static Block[] getRandomShape(int place) {
		int i = ThreadLocalRandom.current().nextInt(0, 10);
		switch(i) {
		case 0:
			return getLeftRotatedL(place);
		case 1:
			return getDoubleBlock(place);
		case 2:
			return getTripleBlock(place);
		case 3:
			return getT(place);
		case 4:
			return getLeftRotatedT(place);
		case 5:
			return getSingleBlock(place);
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
