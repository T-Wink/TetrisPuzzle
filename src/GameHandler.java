import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.text.Text;

/**
 * Handles the score and highscore. Reads and persists the highscore, and update the respective Text-Objects.
 * @author Timon W.
 */
public class GameHandler {
	
	private static String scorePath = "score.txt";
	private static Integer score;
	private static Integer highScore;
	private static Text scoreText;
	private static Text highScoreText;
	
	private GameHandler() {
		
	}
	
	/**
	 * Reads and returns the persisted highscore. If reading fails, because there perhaps is no highscore persisted, 0 is returned.
	 * @return the highscore
	 */
	public static int loadHighScore() {
		try {
			FileReader fR = new FileReader(scorePath);
			BufferedReader bR = new BufferedReader(fR);
			highScore = Integer.valueOf(bR.readLine());
			bR.close();
		} catch (Exception e) {
			highScore = 0;
		}
		
		return highScore;
	}
	
	/**
	 * Persists the highscore. If persisting is not possible, prints out the stacktrace.
	 */
	public static void persistHighScore() {
		try {
			FileWriter fW = new FileWriter(scorePath);
			fW.write(String.valueOf(highScore));
			fW.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Adds the newly gained points to the current score. If the current score exceeds the highscore, the latter is also updated.
	 * @param scoreToAdd the score points to add
	 */
	public static void updateScore(int scoreToAdd) {
		score += scoreToAdd;
		scoreText.setText("Score: " + score);
		if(score >= highScore) updateHighScore();
	}

	/**
	 * Updates the current highscore.
	 */
	public static void updateHighScore() {
		highScore = score;
		highScoreText.setText("HighScore:" + highScore);
	}

	public static void setScore(Integer score) {
		GameHandler.score = score;
	}

	public static void setScoreText(Text scoreText) {
		GameHandler.scoreText = scoreText;
	}

	public static void setHighScoreText(Text highScoreText) {
		GameHandler.highScoreText = highScoreText;
	}

}
