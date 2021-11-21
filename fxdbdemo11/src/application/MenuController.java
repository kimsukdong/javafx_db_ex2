package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML
    void onClickAdd(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("Add.fxml"));
    	Main.mainLayout.setCenter(root);
    }

    @FXML
    void onClickDelete(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
    	Main.mainLayout.setCenter(root);
    }

    @FXML
    void onClickSearch(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("Search.fxml"));
    	Main.mainLayout.setCenter(root);
    }

    @FXML
    void onClickUpdate(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("Update.fxml"));
    	Main.mainLayout.setCenter(root);
    }

    @FXML
    void onClickHome(ActionEvent event) throws IOException {
    	AnchorPane root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
    	Main.mainLayout.setCenter(root);
    }
}
