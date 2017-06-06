package gUI;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoadWindow {
	File file;
	
	public File load(){
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Load");
		
		/*
		 * LOADING STUFF
		 */
		TextField directory = new TextField();
		
		Button load = new Button("Browse");
		load.setOnAction(e_-> {
			this.file = loadFileWindow();
			if(this.file != null){
				directory.setText(this.file.toString());
			}
		});
		
		ToggleGroup loopChoices = new ToggleGroup();
		
		RadioButton whilePressed = new RadioButton("Play Sound While Key is Pressed");
		whilePressed.setToggleGroup(loopChoices);
		
		RadioButton fullPressed = new RadioButton("Play Full Sound on Key Press");
		fullPressed.setToggleGroup(loopChoices);
		fullPressed.setSelected(true);
		
		RadioButton loopPressed = new RadioButton("Loop Toggle");
		loopPressed.setToggleGroup(loopChoices);
		
		
		//Label radioButtonTitle = new Label("Playback Choices:");
		VBox radioButtons = new VBox();
		radioButtons.getChildren().addAll(/*radioButtonTitle,*/ whilePressed, fullPressed, loopPressed);
		
		HBox loadLayout = new HBox();
		loadLayout.getChildren().addAll(directory, load, radioButtons);
		loadLayout.setAlignment(Pos.CENTER);
		loadLayout.setSpacing(5);
		/*
		 * LOADING STUFF END
		 */
		
		/*
		 * BOTTOM BUTTONS
		 */
		Button cancel = new Button("Cancel");
		cancel.setOnAction(e -> window.close());
		
		Button ok = new Button("OK");
		ok.setOnAction(e ->{
			window.close();
		});
		
		HBox bottomButtons = new HBox();
		bottomButtons.setAlignment(Pos.BASELINE_RIGHT);
		bottomButtons.setSpacing(5);
		bottomButtons.getChildren().addAll(ok, cancel);
		/*
		 * BOTTOM BUTTONS END
		 */
		
		VBox layout = new VBox();
		layout.setSpacing(5);
		layout.getChildren().addAll(loadLayout, bottomButtons);
		layout.setAlignment(Pos.CENTER_RIGHT);
		
		
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return this.file;
		
	}
	
	private File loadFileWindow(){
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Choose an Audio File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("WAV", "*.wav"),
				new FileChooser.ExtensionFilter("AU", "*.au"),
				new FileChooser.ExtensionFilter("AIFF", "*.aiff")
				);
		File file = fileChooser.showOpenDialog(stage);
		if(file != null){
			return file;
		}
		return null;
	}
	
	 
}
