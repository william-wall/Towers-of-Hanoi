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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Stack;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Designed and Developed by: William Wall
//SSD: Y2
//20070255
public class Controller implements Initializable, Serializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public int clicked = 0;

	ObservableList<Integer> list = FXCollections.observableArrayList(3, 4, 5, 6, 7, 8, 9);

	Stack<Move> moves = new Stack<Move>();

	private Pane inside = null;

	private double origX = 0.0;
	private double origY = 0.0;

	private double deltaX = 0.0;
	private double deltaY = 0.0;

	@FXML
	private Label num, dateTime;

	@FXML
	private Button start, exit, classic, alternative, mainmenu, finish, save, load, music, off, button1, button2,
			button3, undo, ok;

	@FXML
	private ComboBox combo;

	@FXML
	private VBox source = null, destination = null, vb1, vb2, vb3;

	@FXML
	private Pane drag = null;

	@FXML
	Pane block1, block2, block3, block4, block5, block6, block7, block8, block9;

	///////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower1(MouseEvent event) {
		if (source == null) {
			source = vb1;
		} else {
			destination = vb1;
			moveBrick();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower2(MouseEvent event) {
		if (source == null) {
			source = vb2;
		} else {
			destination = vb2;
			moveBrick();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower3(MouseEvent event) {
		if (source == null) {
			source = vb3;
		} else {
			destination = vb3;
			moveBrick();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower1Pressed(MouseEvent event) {
		if (source == null) {
			source = vb1;
		} else {
			destination = vb1;
			moveBrick();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower2Pressed(MouseEvent event) {
		if (source == null) {
			source = vb2;
		} else {
			destination = vb2;
			moveBrick();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower3Pressed(MouseEvent event) {
		if (source == null) {
			source = vb3;
		} else {
			destination = vb3;
			moveBrick();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Restart(MouseEvent event) {
		vb1.getChildren().clear();
		vb2.getChildren().clear();
		vb3.getChildren().clear();
		vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7, block8, block9);
		clicked = 0;
		num.setText(String.valueOf(clicked));
	}

	///////////////////////////////////////////////////////////////////////////////////

	@FXML
	public void Undo(MouseEvent event) {

		Move move = moves.pop();
		source = move.getDestination();
		destination = move.getSource();
		moveBrick();
		move = moves.pop();
		clicked = clicked - 2;
		num.setText(String.valueOf(clicked));
	}

	///////////////////////////////////////////////////////////////////////////////////

	@FXML
	public void Save(MouseEvent event) {
		writeArrayListToFile();
	}

	@FXML
	public void Load(MouseEvent event) {
		readArrayListFromFile();
	}

	@FXML
	public void MainMenu(MouseEvent event) throws IOException {

		Stage stage = null;
		Parent root = null;
		if (event.getSource() == mainmenu) {
			stage = (Stage) mainmenu.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		} else {
			stage = (Stage) finish.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("TowersOfHanoi.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void writeArrayListToFile() {

		try {
			File f = new File("hanoiData.dat");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(moves);
			JOptionPane.showMessageDialog(null, "File handling - Written to file!");
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void readArrayListFromFile() {

		try {
			File f = new File("hanoiData.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			moves = (Stack<Move>) ois.readObject();
			JOptionPane.showMessageDialog(null, "File handling - Read from file!");
			ois.close();
			fis.close();
		} catch (Exception e) {
			moves = new Stack<>();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void chooseBricks(MouseEvent event) {

		combo.setItems(list);
		if (combo.getValue().equals(3)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3);
		} else if (combo.getValue().equals(4)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4);
		} else if (combo.getValue().equals(5)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5);
		} else if (combo.getValue().equals(6)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6);
		} else if (combo.getValue().equals(7)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7);
		} else if (combo.getValue().equals(8)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7, block8);
		} else if (combo.getValue().equals(9)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7, block8, block9);
		}
		clicked = 0;
		num.setText(String.valueOf(clicked));
	}

	@FXML
	public void chooseBricksOk(MouseEvent event) {
		if (combo.getValue().equals(3)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3);
		} else if (combo.getValue().equals(4)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4);
		} else if (combo.getValue().equals(5)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5);
		} else if (combo.getValue().equals(6)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6);
		} else if (combo.getValue().equals(7)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7);
		} else if (combo.getValue().equals(8)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7, block8);
		} else if (combo.getValue().equals(9)) {
			vb1.getChildren().clear();
			vb1.getChildren().addAll(block1, block2, block3, block4, block5, block6, block7, block8, block9);
		}
		clicked = 0;
		num.setText(String.valueOf(clicked));
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void moveBrick() {
		
		if (source.getChildren().isEmpty()) {
			final ImageIcon emptyTower = new ImageIcon("..\\Assignment2\\src\\images\\empty.jpg");
			JOptionPane.showMessageDialog(null, "", "Empty Tower Selected", JOptionPane.INFORMATION_MESSAGE, emptyTower);
			source = null;
			destination = null;
			return;
		}
		if (!destination.getChildren().isEmpty()) {
			Pane block1 = (Pane) source.getChildren().get(0);
			Pane block2 = (Pane) destination.getChildren().get(0);
			if (block1.getWidth() > block2.getWidth()) {
				final ImageIcon big = new ImageIcon("..\\Assignment2\\src\\images\\big.jpg");
				JOptionPane.showMessageDialog(null, "", "Cannot Put Bigger Block On Smaller Block", JOptionPane.INFORMATION_MESSAGE, big);
				source = null;
				destination = null;
				return;
			}
		}
		Move move = new Move(source, destination);
		Pane block = (Pane) source.getChildren().get(0);
		source.getChildren().remove(block);
		destination.getChildren().add(0, block);
		moves.push(move);
		source = null;
		destination = null;
		clicked++;
		num.setText(String.valueOf(clicked));
		Date date = new Date();
		dateTime.setText(String.valueOf(date));
		if (vb1.getChildren().isEmpty() && vb2.getChildren().isEmpty()) {
			final ImageIcon winnerWindow = new ImageIcon("..\\Assignment2\\src\\images\\winner.gif");
			JOptionPane.showMessageDialog(null, "", "Congratulations", JOptionPane.INFORMATION_MESSAGE, winnerWindow);
		}
	}

	///////////////////////////////////////////////////////////////////////////

	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		if (event.getSource() == start) {
			stage = (Stage) start.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("TowersOfHanoi.fxml"));
		} else if (event.getSource() == classic) {
			stage = (Stage) classic.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("TowersOfHanoi.fxml"));
		} else if (event.getSource() == save) {
			writeArrayListToFile();
		} else if (event.getSource() == load) {
			readArrayListFromFile();
		} else if (event.getSource() == alternative) {
			stage = (Stage) alternative.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("1or2.fxml"));
		} else if (event.getSource() == exit) {
			Stage stage1 = (Stage) exit.getScene().getWindow();
			stage1.close();
		} else if (event.getSource() == music) {
			final URL resource = getClass()
					.getResource("../music/1 Hour of Beautiful, Relaxing, Atmospheric Video Game Music (Vol 1).mp3");
			final Media media = new Media(resource.toString());
			final MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.play();
		} else if (event.getSource() == off) {
			final URL resource = getClass()
					.getResource("../music/1 Hour of Beautiful, Relaxing, Atmospheric Video Game Music (Vol 1).mp3");
			final Media media = new Media(resource.toString());
			final MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.stop();
		} else {
			stage = (Stage) finish.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void onTower1MousePressed(MouseEvent event) {

		drag = (Pane) vb1.getChildren().get(0);
		origX = drag.getLayoutX();
		origY = drag.getLayoutY();
		deltaX = event.getSceneX();
		deltaY = event.getSceneY();

	}

	@FXML
	public void onTower1MouseDragged(MouseEvent event) {

		drag.setTranslateX(event.getSceneX() - deltaX);
		drag.setTranslateY(event.getSceneY() - deltaY);
		if (vb2.contains(vb2.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			inside = vb2;
		} else if (vb3.contains(vb3.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			inside = vb3;
		} else {
			inside = null;
		}
	}

	@FXML
	public void onTower1MouseReleased(MouseEvent event) {

		drag.setTranslateX(0);
		drag.setTranslateY(0);
		if (inside == null) {
		} else {
			source = vb1;
			destination = (VBox) inside;
			moveBrick();
			inside = null;
		}
	}

	@FXML
	public void onTower2MousePressed(MouseEvent event) {

		drag = (Pane) vb2.getChildren().get(0);
		origX = drag.getLayoutX();
		origY = drag.getLayoutY();
		deltaX = event.getSceneX();
		deltaY = event.getSceneY();
	}

	@FXML
	public void onTower2MouseDragged(MouseEvent event) {

		drag.setTranslateX(event.getSceneX() - deltaX);
		drag.setTranslateY(event.getSceneY() - deltaY);
		if (vb1.contains(vb1.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			inside = vb1;
		} else if (vb3.contains(vb3.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			inside = vb3;
		} else {
			inside = null;
		}
	}

	@FXML
	public void onTower2MouseReleased(MouseEvent event) {

		drag.setTranslateX(0);
		drag.setTranslateY(0);
		if (inside == null) {
		} else {
			source = vb2;
			destination = (VBox) inside;
			moveBrick();
			inside = null;
		}
	}

	@FXML
	public void onTower3MousePressed(MouseEvent event) {

		drag = (Pane) vb3.getChildren().get(0);
		origX = drag.getLayoutX();
		origY = drag.getLayoutY();
		deltaX = event.getSceneX();
		deltaY = event.getSceneY();
	}

	@FXML
	public void onTower3MouseDragged(MouseEvent event) {

		drag.setTranslateX(event.getSceneX() - deltaX);
		drag.setTranslateY(event.getSceneY() - deltaY);
		if (vb1.contains(vb1.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			inside = vb1;
		} else if (vb2.contains(vb2.sceneToLocal(new Point2D(event.getSceneX(), event.getSceneY())))) {
			inside = vb2;
		} else {
			inside = null;
		}
	}

	@FXML
	public void onTower3MouseReleased(MouseEvent event) {

		drag.setTranslateX(0);
		drag.setTranslateY(0);
		if (inside == null) {
		} else {
			source = vb3;
			destination = (VBox) inside;
			moveBrick();
			inside = null;
		}
	}

	// Designed and Developed by: William Wall
	// SSD: Y2
	// 20070255
}
