package gUI;

import audio.Test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIMain extends Application {
	final String STAGE_TITLE = "Drummer r1";
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle(STAGE_TITLE);
		BorderPane bP = new BorderPane();
		
		//Menu Options Adding Start
		MenuBar menuBar = new MenuBar();
		Menu mFile = new Menu("File");
		mFile.getItems().add(new MenuItem("Load", testAudio()));
		
		Menu mAbout = new Menu("About");
		menuBar.getMenus().addAll(mFile, mAbout);
		//Menu Options Adding End
		
		bP.setTop(menuBar);
		Scene scene = new Scene(bP);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void testAudio(){
		Test t = new Test();
		t.print();
	}

	
}
