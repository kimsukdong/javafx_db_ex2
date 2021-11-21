package application;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MainViewController {
	@FXML
	AnchorPane root;

	@FXML
	void onClickAdd(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Add.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickClose(ActionEvent event) {
		int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want really to close?");
		if(dialogresult == JOptionPane.YES_NO_OPTION)
		{
			System.exit(0);
		}
	}

	@FXML
	void onClickDelete(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickHome(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	void onClickMenu(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickSearch(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Search.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickUpdate(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Update.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
