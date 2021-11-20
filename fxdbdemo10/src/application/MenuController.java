package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    void onClickAdd(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void onClickDelete(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void onClickSearch(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void onClickUpdate(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Update.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void onClickHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }
}
