package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Stack;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//William Wall
//SSD YR 2
//20070255
public class ControllerAlternative implements Initializable, Serializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////

	public int p1clicked = 0, p2clicked = 0;

	ObservableList<Integer> p1list = FXCollections.observableArrayList(3, 4, 5, 6, 7, 8, 9);
	ObservableList<Integer> p2list = FXCollections.observableArrayList(3, 4, 5, 6, 7, 8, 9);

	Stack<Move> p1moves = new Stack<Move>();
	Stack<Move> p2moves = new Stack<Move>();

	////////////////////////
	// private Pane inside = null;
	//
	// private double origX = 0.0;
	// private double origY = 0.0;
	//
	// private double deltaX = 0.0;
	// private double deltaY = 0.0;
	//////////////////////////

	@FXML
	private Label p1num, p2num, p1num1, p2num2;

	@FXML
	private Button start, exit, classic, alternative, player1, player2, player1first, player2first;

	@FXML
	private Button save, load, finish, mainmenu, exit2, finish2, startp2, exitp2;

	@FXML
	private ComboBox combo1, combo2;

	@FXML
	private VBox source1 = null, source2 = null;

	@FXML
	private VBox destination1 = null, destination2 = null;

	// @FXML
	// private Pane drag = null;
	//
	// @FXML
	// private VBox destination = null;

	// @FXML
	// private VBox lastSource = null;
	//
	// @FXML
	// private VBox lastDestination = null;

	@FXML
	Pane covers1, covers2, midPane;

	@FXML
	VBox main;

	@FXML
	Pane block1p1, block2p1, block3p1, block4p1, block5p1, block6p1, block7p1, block8p1, block9p1;

	@FXML
	Pane block1p2, block2p2, block3p2, block4p2, block5p2, block6p2, block7p2, block8p2, block9p2;

	@FXML
	Button button1, button2, button3, button1p2, button2p2, button3p2, undo, p2undo;

	@FXML
	public VBox vb1p1, vb2p1, vb3p1, vb1p2, vb2p2, vb3p2;

	///////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p1Tower1(MouseEvent event) {
		if (source1 == null) {
			source1 = vb1p1;
		} else {
			destination1 = vb1p1;
			p1moveBrick();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p1Tower2(MouseEvent event) {
		if (source1 == null) {
			source1 = vb2p1;
		} else {
			destination1 = vb2p1;
			p1moveBrick();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p1Tower3(MouseEvent event) {
		if (source1 == null) {
			source1 = vb3p1;

		} else {
			destination1 = vb3p1;
			p1moveBrick();
		}
	}

	@FXML
	public void test(MouseEvent event) {
		System.out.print("HI");

	}

	@FXML
	public void p2Tower1(MouseEvent event) {
		if (source2 == null) {
			source2 = vb1p2;
		} else {
			destination2 = vb1p2;
			p2moveBrick();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p2Tower2(MouseEvent event) {
		if (source2 == null) {
			source2 = vb2p2;
		} else {
			destination2 = vb2p2;
			p2moveBrick();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p2Tower3(MouseEvent event) {
		if (source2 == null) {
			source2 = vb3p2;

		} else {
			destination2 = vb3p2;
			p2moveBrick();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower1Pressed(MouseEvent event) {
		// System.out.print("NH");
		if (source1 == null) {
			source1 = vb1p1;
		} else {
			destination1 = vb1p1;
			p1moveBrick();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower2Pressed(MouseEvent event) {
		if (source1 == null) {
			source1 = vb2p1;
		} else {
			destination1 = vb2p1;
			p1moveBrick();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Tower3Pressed(MouseEvent event) {
		if (source1 == null) {
			source1 = vb3p1;

		} else {
			destination1 = vb3p1;
			p1moveBrick();
		}
	}

	@FXML
	public void p2Tower1Pressed(MouseEvent event) {
		if (source2 == null) {
			source2 = vb1p2;
		} else {
			destination2 = vb1p2;
			p2moveBrick();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p2Tower2Pressed(MouseEvent event) {
		if (source2 == null) {
			source2 = vb2p2;
		} else {
			destination2 = vb2p2;
			p2moveBrick();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p2Tower3Pressed(MouseEvent event) {
		if (source2 == null) {
			source2 = vb3p2;

		} else {
			destination2 = vb3p2;
			p2moveBrick();
		}
	}

	////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void Restart(MouseEvent event) {
		vb1p1.getChildren().clear();
		vb2p1.getChildren().clear();
		vb3p1.getChildren().clear();
		vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1, block5p1, block6p1, block7p1, block8p1,
				block9p1);
		p1clicked = 0;
		p1num.setText(String.valueOf(p1clicked));
	}

	@FXML
	public void p2Restart(MouseEvent event) {
		vb1p2.getChildren().clear();
		vb2p2.getChildren().clear();
		vb3p2.getChildren().clear();
		vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2, block5p2, block6p2, block7p2, block8p2,
				block9p2);
		p2clicked = 0;
		p2num.setText(String.valueOf(p2clicked));
	}

	///////////////////////////////////////////////////////////////////////////////////

	@FXML
	public void Undo(MouseEvent event) {
		// source = lastDestination;
		// destination = lastSource;
		Move move = p1moves.pop();
		source1 = move.getDestination();
		destination1 = move.getSource();
		// lastSource = null;
		// lastDestination = null;
		p1moveBrick();
		move = p1moves.pop();
		p1clicked = p1clicked - 2;
		p1num.setText(String.valueOf(p1clicked));
	}

	@FXML
	public void p2Undo(MouseEvent event) {
		// source = lastDestination;
		// destination = lastSource;
		Move move = p2moves.pop();
		source2 = move.getDestination();
		destination2 = move.getSource();
		// lastSource = null;
		// lastDestination = null;
		p2moveBrick();
		move = p2moves.pop();
		p2clicked = p2clicked - 2;
		p2num.setText(String.valueOf(p2clicked));
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
			// get reference to the button's stage
			stage = (Stage) mainmenu.getScene().getWindow();
			// load up OTHER FXML document
			root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		}

		else {
			stage = (Stage) finish.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("TowersOfHanoi.fxml"));
		}
		// create a new scene with root and set the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void writeArrayListToFile() { // file handling - write to file - this
											// will execute when user presses
											// exit option

		System.out.print("HI");
		try {
			File f = new File("hanoiData.dat");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p1moves);

			JOptionPane.showMessageDialog(null, "File handling - Written to file!");
			oos.close();
			fos.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void readArrayListFromFile() { // file handling - read from file

		try {
			File f = new File("hanoiData.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			p1moves = (Stack<Move>) ois.readObject();

			JOptionPane.showMessageDialog(null, "File handling - Read from file!");
			ois.close();
			fis.close();

		} catch (Exception e) {
			// System.out.println("Error: " + e.getMessage());
			p1moves = new Stack<>();
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void chooseBricks(MouseEvent event) {
		// combo.setValue(9);
		combo1.setItems(p1list);
		if (combo1.getValue().equals(3)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1);
		} else if (combo1.getValue().equals(4)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1);
		} else if (combo1.getValue().equals(5)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1, block5p1);
		} else if (combo1.getValue().equals(6)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1, block5p1, block6p1);
		} else if (combo1.getValue().equals(7)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1, block5p1, block6p1, block7p1);
		} else if (combo1.getValue().equals(8)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1, block5p1, block6p1, block7p1, block8p1);
		} else if (combo1.getValue().equals(9)) {
			vb1p1.getChildren().clear();
			vb1p1.getChildren().addAll(block1p1, block2p1, block3p1, block4p1, block5p1, block6p1, block7p1, block8p1,
					block9p1);
		}
	}

	@FXML
	public void p2chooseBricks(MouseEvent event) {
		// combo.setValue(9);
		combo2.setItems(p2list);
		if (combo2.getValue().equals(3)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2);
		} else if (combo2.getValue().equals(4)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2);
		} else if (combo2.getValue().equals(5)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2, block5p2);
		} else if (combo2.getValue().equals(6)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2, block5p2, block6p2);
		} else if (combo2.getValue().equals(7)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2, block5p2, block6p2, block7p2);
		} else if (combo2.getValue().equals(8)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2, block5p2, block6p2, block7p2, block8p2);
		} else if (combo2.getValue().equals(9)) {
			vb1p2.getChildren().clear();
			vb1p2.getChildren().addAll(block1p2, block2p2, block3p2, block4p2, block5p2, block6p2, block7p2, block8p2,
					block9p2);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////
	@FXML
	public void p1moveBrick() {

		if (p1clicked == 10 || p1clicked == 20 || p1clicked == 30 || p1clicked == 40 || p1clicked == 50 || p1clicked == 60 || p1clicked == 70 || p1clicked == 80 || p1clicked == 90 || p1clicked == 100) {
			midPane.getChildren().remove(covers2);
			midPane.getChildren().add(covers1);
			covers1.getChildren().remove(player1first);
			//			p1clicked = 0;
//			p1clicked = 11;
		}
		if (source1.getChildren().isEmpty()) {
			JOptionPane.showMessageDialog(null, "That tower was empty try again");
			source1 = null;
			destination1 = null;
			return;
		}
		if (!destination1.getChildren().isEmpty()) {
			Pane block1 = (Pane) source1.getChildren().get(0);
			Pane block2 = (Pane) destination1.getChildren().get(0);
			if (block1.getWidth() > block2.getWidth()) {
				JOptionPane.showMessageDialog(null, "You cannot put a big block on a smaller block");
				source1 = null;
				destination1 = null;
				return;
			}
		}
		Move move = new Move(source1, destination1);

		Pane block = (Pane) source1.getChildren().get(0);
		source1.getChildren().remove(block);
		destination1.getChildren().add(0, block);
		p1moves.push(move);
		// lastSource = source;
		// lastDestination = destination;
		source1 = null;
		destination1 = null;
		p1clicked++;
		p1num.setText(String.valueOf(p1clicked));
		p1num1.setText(String.valueOf(p1clicked));
	}

	@FXML
	public void p2moveBrick() {
		if (p2clicked == 10 || p2clicked == 20 || p2clicked == 30 || p2clicked == 40 || p2clicked == 50 || p2clicked == 60 || p2clicked == 70 || p2clicked == 80 || p2clicked == 90 || p2clicked == 100) {
			midPane.getChildren().remove(covers1);
			midPane.getChildren().add(covers2);
			covers2.getChildren().remove(player2first);
		}
		if (source2.getChildren().isEmpty()) {
			JOptionPane.showMessageDialog(null, "That tower was empty try again");
			source2 = null;
			destination2 = null;
			return;
		}
		if (!destination2.getChildren().isEmpty()) {
			Pane block1 = (Pane) source2.getChildren().get(0);
			Pane block2 = (Pane) destination2.getChildren().get(0);
			if (block1.getWidth() > block2.getWidth()) {
				JOptionPane.showMessageDialog(null, "You cannot put a big block on a smaller block");
				source2 = null;
				destination2 = null;
				return;
			}
		}
		Move move = new Move(source2, destination2);

		Pane block = (Pane) source2.getChildren().get(0);
		source2.getChildren().remove(block);
		destination2.getChildren().add(0, block);
		p2moves.push(move);
		// lastSource = source;
		// lastDestination = destination;
		source2 = null;
		destination2 = null;
		p2clicked++;
		p2num.setText(String.valueOf(p2clicked));
		p2num2.setText(String.valueOf(p2clicked));
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
		} else if (event.getSource() == alternative) {
			stage = (Stage) alternative.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("1or2.fxml"));
		} else if (event.getSource() == exit) {
			Stage stage1 = (Stage) exit.getScene().getWindow();
			try{
			stage1.close();
			}
			catch(Exception e)
			{
				System.out.print("Game Over");
			}
		} else {
			stage = (Stage) finish.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void twoPlayer(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		if (event.getSource() == player1) {
			stage = (Stage) player1.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("AlternativeVersion.fxml"));
		} else if (event.getSource() == player2) {
			stage = (Stage) player2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Rules2Player.fxml"));
		} else if (event.getSource() == exit2) {
			Stage stage1 = (Stage) exit2.getScene().getWindow();
			stage1.close();
		} else {
			stage = (Stage) finish2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void rules(ActionEvent event) throws IOException {
		
		Stage stage = null;
		Parent root = null;
		if (event.getSource() == startp2) {
			stage = (Stage) startp2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("AlternativeVersion.fxml"));
		} else if (event.getSource() == exitp2) {
			stage = (Stage) exitp2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("1or2.fxml"));
		} else {
			stage = (Stage) finish2.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void p1First() {
		midPane.getChildren().remove(covers1);
		covers2.getChildren().remove(player2first);

	}

	@FXML
	public void p2First() {
		midPane.getChildren().remove(covers2);
		covers1.getChildren().remove(player1first);
	}

	// @FXML
	// public void DragSource(MouseEvent event) {
	//
	// if (source == null) {
	// source = vb1;
	// } else {
	// destination = vb1;
	// moveBrick();
	// }
	//
	// }
	// @FXML
	// public void DragDestination(MouseEvent event) {
	//
	//
	// //Pane block=(Pane)destination.getChildren().get(0);
	//
	// }

	@FXML
	public void onTower1MousePressed(MouseEvent event) {
		// System.out.println("1");
		//
		// // System.out.println("***"+vb1);
		// // System.out.println("***"+vb1.getChildren());
		// // System.out.println("***"+vb1.getChildren().get(0));
		// drag = (Pane) vb1.getChildren().get(0);
		//
		// origX = drag.getLayoutX();
		// origY = drag.getLayoutY();
		//
		// drag.setTranslateX(event.getX() - drag.getWidth() / 2);
		// drag.setTranslateY(event.getY() - drag.getWidth() / 2);
		//
		// //drag.relocate(event.getX() - drag.getWidth() / 2,
		// // event.getY() - drag.getHeight() / 2);
		//
		// deltaX = drag.getLayoutX() - event.getSceneX();
		// deltaY = drag.getLayoutY() - event.getSceneY();
	}

	@FXML
	public void onTower1MouseDragged(MouseEvent event) {
		// System.out.print("2:" + event.getSceneX()+deltaX);
		// drag.relocate(event.getSceneX()+deltaX, event.getSceneY()+deltaY);
		// System.out.print("2");
		// drag.setTranslateX(event.getSceneX()+deltaX);
		// drag.setTranslateY(event.getSceneY()+deltaY);
		// if(event.getSceneX() >= vb2.getLayoutX()&&
		// event.getSceneX() >= vb2.getLayoutX() + vb2.getWidth() &&
		// event.getSceneY() >= vb2.getLayoutY()&&
		// event.getSceneY() >= vb2.getLayoutY()+vb2.getHeight())
		// {
		// inside = vb2;
		// }
		// else{
		// inside = null;
		// }
	}

	@FXML
	public void onTower1MouseReleased(MouseEvent event) {
		// System.out.print("3");
		// //drag.relocate(origX, origY);
		// drag.setTranslateX(origX);
		// drag.setTranslateY(origY);
		// if(inside != null)
		// {
		// vb2.getChildren().add(drag);
		// // moveBrick();
		// }
	}

	// Calendar cal = Calendar.getInstance();
	// SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	// System.out.print( sdf.format(cal.getTime()) );
}
