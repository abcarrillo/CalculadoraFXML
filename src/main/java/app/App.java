package app;

import controller.CalcController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	private CalcController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		controller = new CalcController();
		
		Scene scene = new Scene(controller.getView(), 514, 428);
		
		primaryStage.setTitle("Calculadora FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
