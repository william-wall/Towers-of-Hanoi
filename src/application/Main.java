package application;
import javafx.scene.media.Media;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import java.io.File;

//import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//Designed and Developed by: William Wall
//SSD: Y2
//20070255
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root2 = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root2, 805, 527);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Towers of Hanoi");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
