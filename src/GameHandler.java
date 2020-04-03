import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.text.Text;

public class GameHandler {
	
	private static String scorePath = "score.txt";
	private static Integer score;
	private static Integer highScore;
	private static Text scoreText;
	private static Text highScoreText;
	
	private GameHandler() {
		
	}
	
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
	
	public static void updateScore(int scoreToAdd) {
		score += scoreToAdd;
		scoreText.setText("Score: " + score);
		if(score >= highScore) updateHighScore();
	}

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
