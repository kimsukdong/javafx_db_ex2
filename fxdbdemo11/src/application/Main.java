package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// 메뉴바 사용

public class Main extends Application {
	private static Stage primaryStage;
	public static BorderPane mainLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;						
			
			showMainView();		
			showMainItems();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showMainView() {
		try {
			mainLayout = FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene scene = new Scene(mainLayout,600,510);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("학생 명단 관리");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void showMainItems() {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
