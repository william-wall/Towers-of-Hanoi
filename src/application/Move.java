package application;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
//Designed and Developed by: William Wall
//SSD: Y2
//20070255
public class Move implements Serializable {
	
	private VBox source;

	private VBox destination; 
	
	Move(VBox source, VBox destination)
	{
		this.source = source;
		this.destination = destination;
	}

	public VBox getSource() {
		return source;
	}

	public void setSource(VBox source) {
		this.source = source;
	}

	public VBox getDestination() {
		return destination;
	}

	public void setDestination(VBox destination) {
		this.destination = destination;
	}
}
