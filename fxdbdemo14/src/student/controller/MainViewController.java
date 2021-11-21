package student.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import student.Main;

public class MainViewController {
	@FXML
	AnchorPane root;

	@FXML
	void onClickAdd(ActionEvent event) throws IOException {
		if(Main.login.equals("ON")) {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Add.fxml"));
			Main.mainLayout.setCenter(root);
		} 
		else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
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
	void onClickDelete(ActionEvent event) throws IOException {
		if(Main.login.equals("ON")) {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Delete.fxml"));
			Main.mainLayout.setCenter(root);
		} 
		else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickHome(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/student/view/Sample.fxml"));
			Main.mainLayout.setCenter(root);
			Main.login = "OFF";
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	void onClickMenu(ActionEvent event) throws IOException {
		if(Main.login.equals("ON")) {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Menu.fxml"));
			Main.mainLayout.setCenter(root);
		} 
		else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickSearch(ActionEvent event) throws IOException {
		if(Main.login.equals("ON")) {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Search.fxml"));
			Main.mainLayout.setCenter(root);
		} 
		else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickUpdate(ActionEvent event) throws IOException {
		if(Main.login.equals("ON")) {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Update.fxml"));
			Main.mainLayout.setCenter(root);
		} 
		else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickHelp(ActionEvent event) throws IOException {
		AnchorPane root = FXMLLoader.load(getClass().getResource("/student/view/Help.fxml"));
		Main.mainLayout.setCenter(root);
	}

}
