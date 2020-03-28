
public class Grid {
	
	static Double standardX = (double) 200;
	static Double standardY = (double) 200;
	static Double standardSize = (double) 50;

	public Grid(Double standardX, Double standardY, Double standardSize) {
		Grid.standardX = standardX;
		Grid.standardY = standardY;
		Grid.standardSize = standardSize;
	}
	
	public static double getStandardX() {
		return standardX;
	}
	
	public void setStandardX(Double standardX) {
		Grid.standardX = standardX;
	}

	public static Double getStandardY() {
		return standardY;
	}

	public void setStandardY(Double standardY) {
		Grid.standardY = standardY;
	}

	public static Double getStandardSize() {
		return standardSize;
	}

	public void setStandardSize(Double standardSize) {
		Grid.standardSize = standardSize;
	}
	
	
}
