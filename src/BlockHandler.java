import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseEvent;

public class BlockHandler {
	
	static List<Block> done = new ArrayList<>();
	
	public static void handleClicked(MouseEvent t, Block b) {
		b.onMouseClicked(t);
		done.add(b);
		for(Block neighbor : b.getNeighboringBlocks()) if(neighbor != null && !done.contains(neighbor)) handleClicked(t, neighbor);
		// Check if this is the first call if handleDragged - if so, all blocks of the figure have been checked, and the list can be cleared
		System.out.println(b);
		if(b == done.get(0)) done.clear();
	}
	
	public static void handleDragged(MouseEvent t, Block b) {
		b.onMouseDragged(t);
		done.add(b);
		for(Block neighbor : b.getNeighboringBlocks()) if(neighbor != null && !done.contains(neighbor)) handleDragged(t, neighbor);
		// Check if this is the first call if handleDragged - if so, all blocks of the figure have been checked, and the list can be cleared
		if(b == done.get(0)) done.clear();
	}
}
