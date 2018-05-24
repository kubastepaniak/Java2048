package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Rectangle box = new Rectangle(75, 350, 575, 575);
			box.setFill(Color.TRANSPARENT);
			Group root = new Group(box);
			ObservableList<Node> rootList = root.getChildren();
			Rectangle tile1 = new Rectangle(75, 350, 125, 125);
			rootList.add(tile1);
			Rectangle tile2 = new Rectangle(225, 500, 125, 125);
			rootList.add(tile2);
			Rectangle tile3 = new Rectangle(375, 650, 125, 125);
			rootList.add(tile3);
			Rectangle tile4 = new Rectangle(525, 800, 125, 125);
			rootList.add(tile4);
			Rectangle tile5 = new Rectangle(75, 500, 125, 125);
			rootList.add(tile5);
			Rectangle tile6 = new Rectangle(75, 650, 125, 125);
			rootList.add(tile6);
			Rectangle tile7 = new Rectangle(75, 800, 125, 125);
			rootList.add(tile7);
			Rectangle tile8 = new Rectangle(225, 350, 125, 125);
			rootList.add(tile8);
			Rectangle tile9 = new Rectangle(225, 650, 125, 125);
			rootList.add(tile9);
			Rectangle tile10 = new Rectangle(225, 800, 125, 125);
			rootList.add(tile10);
			Rectangle tile11 = new Rectangle(375, 350, 125, 125);
			rootList.add(tile11);
			Rectangle tile12 = new Rectangle(375, 500, 125, 125);
			rootList.add(tile12);
			Rectangle tile13 = new Rectangle(375, 800, 125, 125);
			rootList.add(tile13);
			Rectangle tile14 = new Rectangle(525, 350, 125, 125);
			rootList.add(tile14);
			Rectangle tile15 = new Rectangle(525, 500, 125, 125);
			rootList.add(tile15);
			Rectangle tile16 = new Rectangle(525, 650, 125, 125);
			rootList.add(tile16);
			Scene scene = new Scene(root,725,1000);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
