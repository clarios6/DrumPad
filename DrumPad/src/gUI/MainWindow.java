package gUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import audio.Test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainWindow extends Application implements KeyListener{
	final private String STAGE_TITLE = "Drummer r1";
	
	private Test[] sounds = new Test[26];
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(STAGE_TITLE);
		BorderPane bP = new BorderPane();
		MenuBar menuBar = createMenuBar();
		
		Label keyPressed = new Label();
		keyPressed.setOnKeyPressed(e -> {
			System.out.println(e.KEY_PRESSED);
		});
		
		bP.setTop(menuBar);
		bP.setCenter(keyPressed);
		Scene scene = new Scene(bP);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Creates the top MenuBar for the program
	 * @return An object of type MenuBar
	 */
	private MenuBar createMenuBar(){
		MenuBar menuBar = new MenuBar();
		Menu mFile = new Menu("File");
		MenuItem load = new MenuItem("Load");
		load.setOnAction(e -> loadAudioClip());
		
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				System.out.println("Exiting");
				System.exit(0);
			}
		});
		mFile.getItems().addAll(load, exit);
		Menu mAbout = new Menu("About");
		menuBar.getMenus().addAll(mFile, mAbout);
		
		return menuBar;
		
	}
	
	private void testAudio(){
		Test t = new Test();
		t.print();
	}
	
	private void loadAudioClip(){
		File file = new LoadWindow().load();
		/*
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
			System.out.println(file);
		}
		*/
		System.out.println(file);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
