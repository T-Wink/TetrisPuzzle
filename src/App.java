import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
	
	Double mainSceneX = new Double(0);
	Double mainSceneY = new Double(0);

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
	    Scene scene = new Scene(root, 1280, Grid.standardTileSize * 10);
	    Grid.init();
	    FigureHandler.setRoot(root);
	    Integer highScore = GameHandler.loadHighScore();
	    Integer score = 0;
	    Text highScoreText = new Text("HighScore: " + highScore);
	    highScoreText.setStyle("-fx-font: 24 arial;");
	    highScoreText.relocate(Grid.getStandardTileSize() * 9 + 50, Grid.getStandardTileSize() / 2);
	    highScoreText.setFill(Color.BLACK);
	    Text scoreText = new Text("Score: " + score);
	    scoreText.setStyle("-fx-font: 24 arial;");
	    scoreText.relocate(Grid.getStandardTileSize() * 9 + 50, Grid.getStandardTileSize());
	    scoreText.setFill(Color.BLACK);
	    GameHandler.setScoreText(scoreText);
	    GameHandler.setHighScoreText(highScoreText);
	    GameHandler.setScore(score);
	    
	    
	    for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				root.getChildren().add(Grid.getTiles()[i][j]);
			}
		}
	    
	    scoreText.setVisible(true);
	    root.getChildren().addAll(highScoreText, scoreText);
	    
	    FigureHandler.initFiguresToPlace();

	    primaryStage.setScene(scene);
	    primaryStage.setOnCloseRequest(v -> {
	    	GameHandler.persistHighScore();
	    });
	    primaryStage.show();
	  }
	
	public static void main(String[] args) {
		launch(args);
	}

}
